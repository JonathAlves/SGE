package com.basis.sge.service.recurso;

import com.basis.sge.service.builder.EventoBuilder;
import com.basis.sge.service.dominio.Evento;
import com.basis.sge.service.dominio.TipoEvento;
import com.basis.sge.service.repositorio.EventoRepositorio;
import com.basis.sge.service.servico.mapper.EventoMapper;
import com.basis.sge.service.util.IntTestComum;
import com.basis.sge.service.util.TestUtil;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Status;
import javax.transaction.Transactional;

import java.awt.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@Transactional
public class TestNegativosRecursoIT extends IntTestComum {

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
        eventoBuilder.construir();

        getMockMvc().perform(get("/api/eventos"))
                .andExpect(status().isOk());
    }

    @Test
    public void idInexistente() throws Exception{
        Evento evento = eventoBuilder.construir();
        Integer idInvalido = 10;
        getMockMvc().perform(get("/api/eventos/" + idInvalido))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void tituloIgual() throws Exception {
        Evento evento = eventoBuilder.construir();
        Evento evento1 = eventoBuilder.construirEntidade();
        evento1.setTitulo(evento.getTitulo());

        getMockMvc().perform(post("/api/eventos")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(eventoMapper.toDto(evento1))))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void tipoEventoInexistenteTest() throws Exception {
        Evento evento = eventoBuilder.construir();
        TipoEvento idTipoEvento = new TipoEvento();
        idTipoEvento.setId(10);
        evento.setTipoEvento(idTipoEvento);
        getMockMvc().perform(get("/api/eventos/" + evento.getTipoEvento()))
                .andExpect(status().isBadRequest());
    }

}
