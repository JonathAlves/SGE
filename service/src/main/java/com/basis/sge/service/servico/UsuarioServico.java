package com.basis.sge.service.servico;
import com.basis.sge.service.dominio.Usuario;
import com.basis.sge.service.repositorio.UsuarioRepositorio;
import com.basis.sge.service.servico.Exception.RegraNegocioException;
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


    public UsuarioDTO adicionar (UsuarioDTO usuarioDTO){
        if(usuarioDTO.getId() != null){
            obterPorId(usuarioDTO.getId());
            verificarUsuarioAtualizar(usuarioDTO);
             verificarUsuarioAtualizar(usuarioDTO);
        }else
            verificarUsuario(usuarioDTO);
        Usuario usuario = usuarioMapper.toEntity(usuarioDTO);
        usuario.setChave(UUID.randomUUID().toString());
        emailServico.emailEnviarCadastro(usuario);
        Usuario usuarioSalvo = usuarioRepositorio.save(usuario);
        return usuarioMapper.toDto(usuarioSalvo);

    }


    public void remover(Integer id) {
        Usuario usuario = usuarioRepositorio.findById(id).orElseThrow(() -> new RegraNegocioException("Usuario nao encontrado"));
        usuarioRepositorio.deleteById(id);
    }


        public void verificarUsuario (UsuarioDTO usuarioDTO){

                     if (usuarioRepositorio.findByEmail(usuarioDTO.getEmail()) != null)
                        throw new RegraNegocioException("Email já cadastrado");

                    else if (usuarioRepositorio.findByCpf(usuarioDTO.getCpf()) != null) {
                        throw new RegraNegocioException("CPF já cadastrado");

                    }
                }





        public void verificarUsuarioAtualizar (UsuarioDTO usuarioNovo){
            UsuarioDTO usuarioAntigo = obterPorId(usuarioNovo.getId());

            if (usuarioRepositorio.findByCpf(usuarioNovo.getCpf()) != null && !usuarioAntigo.getCpf().equals(usuarioNovo.getCpf())){
                throw new RegraNegocioException("CPF já cadastrado!");
            }

            else if (usuarioRepositorio.findByEmail(usuarioNovo.getEmail()) != null && !usuarioAntigo.getCpf().equals(usuarioNovo.getCpf())){
                throw new RegraNegocioException("Email já existente!");
            }


        }

        

}







