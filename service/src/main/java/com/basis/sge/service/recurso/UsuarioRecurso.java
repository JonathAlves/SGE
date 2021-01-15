package com.basis.sge.service.recurso;

import com.basis.sge.service.servico.UsuarioServico;
import com.basis.sge.service.servico.dto.UsuarioDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping ("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioRecurso {
    private final UsuarioServico usuarioServico;


    @GetMapping
    public ResponseEntity<List <UsuarioDTO>> listar(){
        List list = usuarioServico.listar();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<UsuarioDTO> obterPorId(@PathVariable Integer id){
        UsuarioDTO usuarioDTO = usuarioServico.obterPorId(id);
        return ResponseEntity.ok(usuarioDTO);
    }


    @PostMapping
    public ResponseEntity<UsuarioDTO> salvar(@RequestBody UsuarioDTO usuarioDTO){
        UsuarioDTO usuario = usuarioServico.salvar(usuarioDTO);
        return ResponseEntity.ok(usuario);

    }

    @PutMapping
    public ResponseEntity<UsuarioDTO> editar(@RequestBody UsuarioDTO usuarioDTO){
        UsuarioDTO usuario = usuarioServico.editar(usuarioDTO);
        return ResponseEntity.ok(usuario);

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Integer id){
        usuarioServico.remover(id);
        return ResponseEntity.ok().build();
    }







    }






