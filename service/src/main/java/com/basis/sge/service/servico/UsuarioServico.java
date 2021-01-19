package com.basis.sge.service.servico;


import com.basis.sge.service.dominio.Usuario;
import com.basis.sge.service.repositorio.UsuarioRepositorio;
import com.basis.sge.service.servico.Exception.RegraNegocioException;
import com.basis.sge.service.servico.dto.EmailDTO;
import com.basis.sge.service.servico.dto.UsuarioDTO;
import com.basis.sge.service.servico.mapper.UsuarioMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
@Transactional
public class UsuarioServico {

    private final UsuarioRepositorio usuarioRepositorio;
    private final UsuarioMapper usuarioMapper;
    private final EmailServico emailServico;

    public List<UsuarioDTO> listar() {
        List<Usuario> usuarios = usuarioRepositorio.findAll();
        return usuarioMapper.toDto(usuarios);
    }

    public UsuarioDTO obterPorId(Integer id) {
        Usuario usuario = usuarioRepositorio.findById(id).orElseThrow(()
                -> new RegraNegocioException("Usuario nao encontrado"));
        return usuarioMapper.toDto(usuario);
    }


    public UsuarioDTO salvar(UsuarioDTO usuarioDTO) {
        verificarUsuario(usuarioDTO);
        Usuario usuario = usuarioMapper.toEntity(usuarioDTO);
        usuario.setChave(UUID.randomUUID().toString());
        EmailDTO emailDTO = new EmailDTO();
        emailDTO.setAssunto("Cadastro do usuario");
        emailDTO.setCorpo("Obrigado por se inscrever no nosso evento! Sua chave:" + usuario.getChave());
        emailDTO.setDestinatario(usuario.getEmail());
        emailDTO.setCopias(emailDTO.getCopias());
        emailServico.sendMail(emailDTO);
        usuarioRepositorio.save(usuario);
        return usuarioMapper.toDto(usuario);

    }


           /* public UsuarioDTO criar (UsuarioDTO usuarioDTO){
                verificarUsuario(usuarioDTO);
                Usuario usuario = usuarioMapper.toEntity(usuarioDTO);
                usuario.setChave(UUID.randomUUID().toString());

                usuarioRepositorio.save(usuario);
                return usuarioMapper.toDto(usuario);

            }*/

    public UsuarioDTO atualizar(UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioRepositorio.findById(usuarioDTO.getId()).orElseThrow(() -> new com.basis.sge.service.servico.RegraNegocioException("Usuario não encontrado!"));
        verificarUsuarioAtualizar(usuarioDTO);
        usuario.setNome(usuarioDTO.getNome());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setCpf(usuarioDTO.getCpf());
        usuario.setTelefone(usuarioDTO.getTelefone());
        usuario.setDataNascimento(usuarioDTO.getDataNascimento());
        Usuario usuarioAtualizado = usuarioRepositorio.save(usuario);

        return usuarioMapper.toDto(usuarioAtualizado);

    }


    public void remover(Integer id) {
        Usuario usuario = usuarioRepositorio.findById(id).orElseThrow(()
                -> new RegraNegocioException("Usuario não encontrado"));
        usuarioRepositorio.deleteById(id);
    }


    public void verificarUsuario(UsuarioDTO usuarioDTO) {
        if (usuarioDTO != null) {
            throw new RegraNegocioException("Dados invalidos!");
        } else if (usuarioRepositorio.findByEmail(usuarioDTO.getEmail()) != null) {
            throw new RegraNegocioException("Email já cadastrado");

        } else if (usuarioRepositorio.findByCpf(usuarioDTO.getCpf()) != null) {
            throw new RegraNegocioException("CPF já cadastrado");

        }
    }


    public void verificarUsuarioAtualizar(UsuarioDTO usuarioNovo) {
        UsuarioDTO usuarioAntigo = obterPorId(usuarioNovo.getId());
        if(usuarioRepositorio.findByCpf(usuarioNovo.getCpf()) && !usuarioAntigo.getCpf().equals(usuarioNovo.getCpf()))
            throw new RegraNegocioException("CPF já existente!");

        else if(usuarioRepositorio.findByEmail(usuarioNovo.getEmail()) && !usuarioAntigo.getEmail().equals(usuarioNovo.getEmail()))
            throw new RegraNegocioException("Email já existente!");
    }


}