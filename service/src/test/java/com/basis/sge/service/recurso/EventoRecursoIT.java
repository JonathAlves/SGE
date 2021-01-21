package com.basis.sge.service.recurso;

import com.basis.sge.service.builder.EventoBuilder;
import com.basis.sge.service.dominio.Evento;
import com.basis.sge.service.repositorio.EventoRepositorio;
import com.basis.sge.service.servico.mapper.EventoMapper;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@Transactional
public class EventoRecursoIT extends IntTestComum {

    @Autowired
    private EventoBuilder eventoBuilder;

    @Autowired
    private EventoMapper eventoMapper;

    @Autowired
    private EventoRepositorio eventoRepositorio;

    @BeforeEach
    public void inicializar() {
        eventoRepositorio.deleteAll();
    }

    @Test
    public void listarTeste() throws Exception {
        Evento evento = eventoBuilder.construir();

        getMockMvc().perform(get("/api/eventos"))
                .andExpect(status().isOk());
    }

    @Test
    public void salvarTeste() throws Exception {
        Evento evento = eventoBuilder.construirEntidade();
        getMockMvc().perform(post("/api/eventos")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(eventoMapper.toDto(evento))))
                .andExpect(status().isCreated());
    }

    @Test
    public void editarTeste() throws Exception {
        Evento evento = eventoBuilder.construir();
        evento.setTitulo("Torneio de dominó");
        evento.setLocal("sindicato do dominó");
        evento.setQtVagas(100);

        getMockMvc().perform(put("/api/eventos")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(eventoMapper.toDto(evento))))
                .andExpect(status().isCreated());

    }

    @Test
    public void tituloIgual() throws Exception {
        Evento evento = eventoBuilder.construir();
        Evento evento1 = eventoBuilder.construirEntidade();
        evento1.setTitulo("Campeonato de sinuca");

        getMockMvc().perform(post("/api/eventos"))
                .andExpect(status().isBadRequest());

    }

    @Test
    public void idInexistente() throws Exception{
        Evento evento = eventoBuilder.construir();
        evento.setId(10);

        getMockMvc().perform(get("/api/eventos" + evento.getId()))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void idTeste() throws Exception{
        Evento evento = eventoBuilder.construir();

        getMockMvc().perform(get("/api/eventos" + evento.getId()))
                .andExpect(status().isOk());
    }

    @Test
    public void deletarTeste() throws Exception{
        Evento evento = eventoBuilder.construir();

        getMockMvc().perform(delete("/api/eventos" + evento.getId()))
                .andExpect(status().isOk());
        Assert.assertEquals(0, eventoRepositorio.findAll().size());
    }
}
