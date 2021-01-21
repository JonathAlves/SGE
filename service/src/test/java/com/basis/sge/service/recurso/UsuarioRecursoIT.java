package com.basis.sge.service.recurso;
import com.basis.sge.service.builder.UsuarioBuilder;
import com.basis.sge.service.dominio.Usuario;
import com.basis.sge.service.repositorio.UsuarioRepositorio;
import com.basis.sge.service.servico.mapper.UsuarioMapper;
import com.basis.sge.service.util.IntTestComum;
import com.basis.sge.service.util.TestUtil;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import javax.transaction.Transactional;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@Transactional
public class UsuarioRecursoIT extends IntTestComum {
    @Autowired
    private UsuarioBuilder usuarioBuilder;
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    @Autowired
    private UsuarioMapper usuarioMapper;


    @BeforeEach
    public void inicializar() {
        usuarioRepositorio.deleteAll();
    }



    @Test
    public void listarTeste() throws Exception {
        Usuario usuario = usuarioBuilder.construir();

        getMockMvc().perform(get("/api/usuarios"))
                .andExpect(status().isOk());
    }
    @Test
    public void salvarTeste() throws Exception {
        Usuario usuario = usuarioBuilder.construirEntidade();
        getMockMvc().perform(post("/api/usuarios")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(usuarioMapper.toDto(usuario))))
                .andExpect(status().isCreated());
    }


    @Test
    public void editarTeste() throws Exception {
        Usuario usuario = usuarioBuilder.construir();
        usuario.setCpf("61256835080");
        usuario.setNome("Alterando Nome");
        usuario.setEmail("alterandoemail@gmail.com");
        
        getMockMvc().perform(put("/api/usuarios")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(usuarioMapper.toDto(usuario))))
                .andExpect(status().isOk());

    }
    @Test
    public void erroCpfIgual() throws Exception {
        Usuario usuario = usuarioBuilder.construir();
        Usuario usuario1 = usuarioBuilder.construirEntidade();
        usuario1.setCpf("49582458046");

        getMockMvc().perform(post("/api/usuarios"))
                .andExpect(status().isBadRequest());

    }

    @Test
    public void erroEmailIgual() throws Exception {
        Usuario usuario = usuarioBuilder.construir();
        Usuario usuario1 = usuarioBuilder.construirEntidade();
        usuario1.setEmail("aaaaatsts2321@gmail.com");

        getMockMvc().perform(post("/api/usuarios"))
                .andExpect(status().isBadRequest());

    }
    @Test
    public void erroIdInexistente() throws Exception{
        Usuario usuario = usuarioBuilder.construir();
        usuario.setId(111);
        getMockMvc().perform(get("/api/usuarios/" + usuario.getId()))
                .andExpect(status().isBadRequest());

    }

    @Test
    public void idTeste() throws Exception{
        Usuario usuario = usuarioBuilder.construir();
        getMockMvc().perform(get("/api/usuarios/" + usuario.getId()))
                .andExpect(status().isOk());

    }
    @Test
    public void deletarTeste() throws Exception{
        Usuario usuario = usuarioBuilder.construir();
        getMockMvc().perform(delete("/api/usuarios/" + usuario.getId()))
                .andExpect(status().isOk());
        Assert.assertEquals(0, usuarioRepositorio.findAll().size());


    }
}