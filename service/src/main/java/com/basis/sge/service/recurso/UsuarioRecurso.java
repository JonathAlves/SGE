package com.basis.sge.service.recurso;

import com.basis.sge.service.dominio.Usuario;
import com.basis.sge.service.servico.UsuarioServico;
import com.basis.sge.service.servico.dto.UsuarioDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.rmi.server.UID;
import java.util.List;

@RestController
@RequestMapping ("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioRecurso {
    @Autowired
    private final UsuarioServico usuarioServico;


    @GetMapping
    public ResponseEntity<List <UsuarioDTO>> listar(){
        List list = usuarioServico.listar();
        return ResponseEntity.ok(list);
    }

    @GetMapping ("/{id}")
    public  ResponseEntity<UsuarioDTO> buscar(@PathVariable Integer id){
        UsuarioDTO usuarioDTO = usuarioServico.obterPorId(id);
        return ResponseEntity.ok(usuarioDTO);
    }




    @PostMapping
    public ResponseEntity<UsuarioDTO> adicionar(@Valid @RequestBody UsuarioDTO usuarioDTO) throws URISyntaxException {
        UsuarioDTO usuario = usuarioServico.salvar(usuarioDTO);
        return ResponseEntity.created(new URI("/api/usuarios")).body(usuario);
    }

    @PutMapping
    public ResponseEntity<UsuarioDTO> atualizar(@RequestBody UsuarioDTO usuarioDTO){
        UsuarioDTO usuario = usuarioServico.atualizar(usuarioDTO);
        return ResponseEntity.ok(usuario);

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Integer id){
        usuarioServico.remover(id);
        return ResponseEntity.ok().build();
    }




}
