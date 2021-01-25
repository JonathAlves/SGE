package com.basis.sge.service.recurso;

import com.basis.sge.service.builder.InscricaoBuilder;
import com.basis.sge.service.dominio.Inscricao;
import com.basis.sge.service.util.IntTestComum;
import com.basis.sge.service.util.TestUtil;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@Transactional
public class InscricaoRecursoIT extends IntTestComum {

    @Autowired
    private InscricaoBuilder inscricaoBuilder;
    @Autowired
    private Inscricao inscricao;


    @BeforeEach
    public void limparBanco(){
        inscricaoBuilder.limparBanco();
    }

    @Test
    public void listar() throws Exception{
        inscricaoBuilder.construir();
        getMockMvc().perform(get("/api/inscricoes"))
                .andExpect(status().isOk());
    }

    @Test
    public void buscarPorId() throws Exception{
        inscricaoBuilder.construir();
        getMockMvc().perform(get("/api/inscricoes/" + inscricao.getId()));
    }

    @Test
    public void salvar() throws Exception{
        inscricaoBuilder.construirEntidade();
        getMockMvc().perform(post("/api/inscricoes")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(inscricaoBuilder.convertToDto(inscricao))))
                .andExpect(status().isOk());
    }

    @Test
    public void removerPorId() throws Exception {
        inscricaoBuilder.construir();
        getMockMvc().perform(delete("/api/inscricoes/" + inscricao.getId()))
                .andExpect(status().isOk());
    }

    @Test
    public void salvarExistente() throws Exception{
        inscricaoBuilder.construirEntidade();
        getMockMvc().perform(post("/api/inscricoes")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(inscricaoBuilder.convertToDto(inscricao))));
        getMockMvc().perform(post("/api/inscricoes")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(inscricaoBuilder.convertToDto(inscricao))))
                .andExpect(status().isBadRequest());
    }
}

