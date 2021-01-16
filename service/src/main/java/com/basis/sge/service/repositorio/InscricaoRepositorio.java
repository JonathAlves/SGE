package com.basis.sge.service.repositorio;

import com.basis.sge.service.dominio.Inscricao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface InscricaoRepositorio extends JpaRepository<Inscricao, Integer>{
}
