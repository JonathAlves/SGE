package com.basis.sge.service.repositorio;

import com.basis.sge.service.dominio.Pergunta;
import com.basis.sge.service.servico.dto.PerguntaDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PerguntaRepositorio extends JpaRepository<Pergunta, Integer> {

    Pergunta findByTitulo(String titulo);
}
