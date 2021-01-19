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

    public List<UsuarioDTO> listar(){
        List<Usuario> usuarios = usuarioRepositorio.findAll();
        return usuarioMapper.toDto(usuarios);
    }

    public UsuarioDTO obterPorId(Integer id){
       Usuario usuario = usuarioRepositorio.findById(id).orElseThrow(()
               -> new RegraNegocioException("Usuario nao encontrado"));
                return usuarioMapper.toDto(usuario);
    }


    public UsuarioDTO salvar(UsuarioDTO usuarioDTO) {
        verificarUsuario(usuarioDTO);
        Usuario usuario = usuarioMapper.toEntity(usuarioDTO);
        usuario.setChave(UUID.randomUUID().toString());

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

            public UsuarioDTO atualizar (UsuarioDTO usuarioDTO){
                Usuario usuario = usuarioRepositorio.findById(usuarioDTO.getId()).orElseThrow(() -> new com.basis.sge.service.servico.RegraNegocioException("Usuario não encontrado!"));
                Usuario usuarioRecebido = usuarioMapper.toEntity(usuarioDTO);
                usuarioRecebido.setChave(usuario.getChave());
                Usuario usuarioAtualizado = usuarioRepositorio.save(usuarioRecebido);

                return usuarioMapper.toDto(usuarioAtualizado);

            }


            public void remover(Integer id){
                Usuario usuario = usuarioRepositorio.findById(id).orElseThrow(()
                        -> new RegraNegocioException("Usuario não encontrado"));
                usuarioRepositorio.deleteById(id);
            }



            public void verificarUsuario(UsuarioDTO usuarioDTO){
                if (usuarioDTO == null) {
                    throw new RegraNegocioException("Dados invalidos!");
                } else if (usuarioRepositorio.findByEmail(usuarioDTO.getEmail()) != null) {
                    throw new RegraNegocioException("Email já cadastrado");

                } else if (usuarioRepositorio.findByCpf(usuarioDTO.getCpf()) != null) {
                    throw new RegraNegocioException("CPF já cadastrado");

                }
            }


            public void verificarUsuarioAtualizar (UsuarioDTO usuarioDTO){
                if (usuarioRepositorio.findByCpf(usuarioDTO.getCpf())) {
                    throw new RegraNegocioException("CPF já cadastrado");

                }

            }


        }