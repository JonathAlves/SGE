package com.basis.sge.service.builder;

import com.basis.sge.service.dominio.Usuario;
import com.basis.sge.service.servico.UsuarioServico;
import com.basis.sge.service.servico.dto.UsuarioDTO;
import com.basis.sge.service.servico.mapper.UsuarioMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

public class UsuarioBuilder extends ConstrutorDeEntidade<Usuario {

    @Autowired
    private  UsuarioMapper usuarioMapper;

    @Autowired
    private UsuarioServico usuarioServico;


    @Override
    protected Usuario construirEntidade() throws ParseException {
        Usuario usuario = new Usuario();
        usuario.setNome("Tiaguin");
        usuario.setCpf("70180211030");
        usuario.setTelefone("33613677");
        usuario.setEmail("testeteste77@gmail.com");
        usuario.setDataNascimento(LocalDate.now());
        return usuario;

    }

    @Override
    protected Usuario persistir(Usuario entidade) {
        UsuarioDTO usuarioDTO = usuarioMapper.toDto(entidade);
        UsuarioDTO salvo = usuarioServico.salvar(usuarioDTO);
        return usuarioMapper.toEntity(salvo);
    }

    @Override
    protected Collection<Usuario> obterTodos() {
        List<UsuarioDTO> usuarioDTOS = usuarioServico.listar();
        return usuarioMapper.toEntity(usuarioDTOS);
    }

    @Override
    protected Usuario obterPorId(Integer id) {
       UsuarioDTO usuario = usuarioServico.obterPorId(id);
       return usuarioMapper.toEntity(usuario);
    }
}
