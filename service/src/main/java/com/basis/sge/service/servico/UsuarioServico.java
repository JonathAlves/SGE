package com.basis.sge.service.servico;


import com.basis.sge.service.dominio.Usuario;
import com.basis.sge.service.repositorio.UsuarioRepositorio;
import com.basis.sge.service.servico.Exception.RegraNegocioException;
import com.basis.sge.service.servico.dto.UsuarioDTO;
import com.basis.sge.service.servico.mapper.UsuarioMapper;
import liquibase.pro.packaged.U;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.utility.RandomString;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.rmi.server.UID;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;
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
        Usuario usuario = usuarioMapper.toEntity(usuarioDTO);
        usuario.setChave(UUID.randomUUID().toString());
        if (usuarioRepositorio.findByEmail(usuario.getEmail()) != null) {
            throw new RegraNegocioException("Email já existe");

        } else if (usuarioRepositorio.findByCpf(usuario.getCpf()) != null) {
            throw new RegraNegocioException("CPF não existe");

        }

            usuarioRepositorio.save(usuario);
            return usuarioMapper.toDto(usuario);










    }

    public UsuarioDTO atualizar(UsuarioDTO verificarId){
            verificarId(verificarId.getId());
            Usuario usuario = usuarioMapper.toEntity(verificarId);
            usuario.setChave(usuario.getChave());
            if(verificarId != null){

                usuarioRepositorio.save(usuario);
                return usuarioMapper.toDto(usuario);

            }
            else
                throw new RegraNegocioException("Usuario não existe");


        }



       public void remover(Integer id){
        Usuario usuario = usuarioRepositorio.findById(id).orElseThrow(()
                -> new RegraNegocioException("Usuario não encontrado"));
        usuarioRepositorio.deleteById(usuario.getId());


    }

    public void verificarId(Integer id){
        Usuario usuario = usuarioRepositorio.findById(id).orElseThrow(()
                -> new RegraNegocioException("Usuario nao encontrado"));
    }


    public void verificarUsuario(UsuarioDTO usuarioDTO){
        if(usuarioRepositorio.findByCpf(usuarioDTO.getCpf())){
            throw new RegraNegocioException("CPF já cadastrado");

        }

    }



}
