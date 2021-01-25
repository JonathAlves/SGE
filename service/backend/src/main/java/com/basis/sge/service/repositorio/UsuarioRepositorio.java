package com.basis.sge.service.repositorio;

import com.basis.sge.service.dominio.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {

      Boolean  findByCpf(String cpf);
      Boolean  findByEmail(String email);





}
