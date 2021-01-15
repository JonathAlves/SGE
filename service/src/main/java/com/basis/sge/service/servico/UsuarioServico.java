package com.basis.sge.service.servico;


import com.basis.sge.service.dominio.Usuario;
import com.basis.sge.service.repositorio.UsuarioRepositorio;
import com.basis.sge.service.servico.Exception.RegraNegocioException;
import com.basis.sge.service.servico.dto.UsuarioDTO;
import com.basis.sge.service.servico.mapper.UsuarioMapper;
import liquibase.pro.packaged.U;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.List;

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
               -> new RegraNegocioException("Usuario nao encontrado");
                return usuarioMapper.toDto(usuario);
    }
    public UsuarioDTO salvar(UsuarioDTO usuarioDTO){
        Usuario usuario = usuarioRepositorio.findByEmail(usuarioDTO.getEmail());

        if(usuario =! null){

        }
        usuarioRepositorio.save((usuario);
        return usuarioMapper.toDto(usuario);


    }
    public UsuarioDTO editar(UsuarioDTO usuarioDTO){
        Usuario usuario = usuarioRepositorio.findByNome(usuarioDTO.getNome());

        if(usuario =! null){

        }
        usuarioRepositorio.save((usuario);
        return usuarioMapper.toDto(usuario);




    /*private boolean findByEmail(Usuario email){

    }*/


}
