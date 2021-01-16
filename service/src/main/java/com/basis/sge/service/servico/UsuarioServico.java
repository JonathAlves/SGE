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
import java.time.LocalDate;
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
               -> new RegraNegocioException("Usuario nao encontrado"));
                return usuarioMapper.toDto(usuario);
    }
    public UsuarioDTO salvar(UsuarioDTO usuarioDTO){
        Usuario usuario = usuarioRepositorio.findByCpf(usuarioDTO.getCpf());

        if(usuario != null){
            throw new RegraNegocioException("Usuario já existe");

        }
        usuarioRepositorio.save(usuario);
        return usuarioMapper.toDto(usuario);

    }


    public UsuarioDTO editar(UsuarioDTO usuarioDTO){
        Usuario usuario = usuarioRepositorio.findByCpf(usuarioDTO.getCpf());
        if(usuario != null){
            usuario.setEmail(usuarioDTO.getEmail());
            usuario.setCpf(usuarioDTO.getCpf());
            usuario.setNome(usuarioDTO.getNome());
            usuario.setTelefone(usuarioDTO.getTelefone());
        }
        usuarioRepositorio.save(usuario);
        return usuarioMapper.toDto(usuario);



    }

       public void remover(Integer id){
        Usuario usuario = usuarioRepositorio.findById(id).orElseThrow(()
                -> new RegraNegocioException("Usuario não encontrado"));
        usuarioRepositorio.deleteById(usuario.getId());


    }

    /*public  void adicionar(UsuarioDTO usuarioDTO){
        Usuario usuario = usuarioRepositorio.findAll();


    }*/



}
