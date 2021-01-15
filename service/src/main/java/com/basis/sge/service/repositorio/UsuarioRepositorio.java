package com.basis.sge.service.repositorio;

import com.basis.sge.service.dominio.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {


}
