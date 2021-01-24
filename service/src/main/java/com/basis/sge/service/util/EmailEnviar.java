package com.basis.sge.service.util;
import com.basis.sge.service.dominio.Usuario;
import com.basis.sge.service.repositorio.UsuarioRepositorio;
import com.basis.sge.service.servico.EmailServico;
import com.basis.sge.service.servico.UsuarioServico;
import com.basis.sge.service.servico.dto.EmailDTO;
import com.basis.sge.service.servico.mapper.UsuarioMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;


public class EmailEnviar {
    @Autowired
    private UsuarioServico usuarioServico;

    
    public void emailEnviarCadastro(){

    }


}
