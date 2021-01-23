package com.basis.sge.service.recurso;

import com.basis.sge.service.builder.PerguntaBuilder;
import com.basis.sge.service.dominio.Pergunta;
import com.basis.sge.service.repositorio.PerguntaRepositorio;
import com.basis.sge.service.servico.mapper.PerguntaMapper;
import com.basis.sge.service.util.IntTestComum;
import com.basis.sge.service.util.TestUtil;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@Transactional
public class PerguntaRecursoIT extends IntTestComum {

    @Autowired
    private PerguntaBuilder perguntaBuilder;

    @Autowired
    private PerguntaMapper perguntaMapper;

    @Autowired
    private PerguntaRepositorio perguntaRepositorio;

    @BeforeEach
    public void inicializarTeste(){
        perguntaRepositorio.deleteAll();
    }

    @Test
    public void listarTeste() throws Exception {
        perguntaBuilder.construir();
        getMockMvc().perform(get("/api/perguntas"))
                .andExpect(status().isOk());
    }

    @Test
    public void idTeste() throws Exception{
        Pergunta pergunta = perguntaBuilder.construir();
        getMockMvc().perform(get( "/api/perguntas/"+pergunta.getId()))
                .andExpect(status().isOk());
    }

    @Test
    public void salvarTeste() throws Exception{
        Pergunta pergunta = perguntaBuilder.construirEntidade();
        getMockMvc().perform(post("/api/perguntas").contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(perguntaMapper.toDto(pergunta))));
    }

    @Test
    public void editarTeste() throws Exception{
        Pergunta pergunta = perguntaBuilder.construirEntidade();
        pergunta.setTitulo("sabe HTML, CSS e Javascript ?");
        pergunta.setObrigatoriedade(true);

        getMockMvc().perform(put("/api/perguntas").contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(perguntaMapper.toDto(pergunta))));
    }
    @Test
    public void tituloNullTeste() throws Exception{
        Pergunta pergunta = perguntaBuilder.construirEntidade();
        pergunta.setTitulo(null);

        getMockMvc().perform(post("/api/perguntas"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void obrigatoriedadeNullTeste() throws Exception{
        Pergunta pergunta = perguntaBuilder.construirEntidade();
        pergunta.setObrigatoriedade(null);

        getMockMvc().perform(post("/api/perguntas"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void checarDuplicataTeste() throws Exception{
        Pergunta pergunta = perguntaBuilder.construirEntidade();
        pergunta.setTitulo("Já programar em ruby?");

        getMockMvc().perform(post("/api/perguntas"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void erroId() throws Exception{

    }

    @Test
    public void deletarTeste() throws Exception{
        Pergunta pergunta = perguntaBuilder.construir();
        getMockMvc().perform(delete("/api/perguntas/" + pergunta.getId()))
                .andExpect(status().isOk());
        Assert.assertEquals(0, perguntaRepositorio.findAll().size());
    }

    @Test
    public void erroIdDeletarTeste() throws Exception{
        getMockMvc().perform(delete("/api/perguntas/111111" ))
                .andExpect(status().isBadRequest());

    }
}
