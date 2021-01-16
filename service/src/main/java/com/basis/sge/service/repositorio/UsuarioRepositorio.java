package com.basis.sge.service.repositorio;

import com.basis.sge.service.dominio.Usuario;
import lombok.Getter;
import lombok.Setter;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sun.misc.Request;

@Repository

public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {

      Usuario existId(Integer id);
      Usuario  findByCpf(String cpf);
      Usuario findByEmail(String email);



}
