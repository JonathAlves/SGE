package com.basis.sge.service.recurso;

import com.basis.sge.service.repositorio.TipoEventoRepositorio;
import com.basis.sge.service.util.IntTestComum;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@Transactional
public class TipoEventoRecursoIT extends IntTestComum {
    @Autowired
    private TipoEventoRepositorio tipoEventoRepositorio;

    @Test
    public void listaTest() throws Exception{
        getMockMvc().perform(get("/api/eventos"))
                .andExpect(status().isOk());
    }
}
