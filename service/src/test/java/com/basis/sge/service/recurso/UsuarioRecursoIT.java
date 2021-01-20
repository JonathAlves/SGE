package com.basis.sge.service.recurso;

import com.basis.sge.service.builder.ConstrutorDeEntidade;
import com.basis.sge.service.builder.UsuarioBuilder;
import com.basis.sge.service.dominio.Usuario;
import com.basis.sge.service.util.IntTestComum;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;

@Transactional
public class UsuarioRecursoIT extends IntTestComum{
    @Autowired
    private UsuarioBuilder usuarioBuilder;


   /* @Test
    public void listar() throws Exception{
        Usuario usuario = usuarioBuilder
    }*/


}
