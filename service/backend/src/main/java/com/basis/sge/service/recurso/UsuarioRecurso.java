package com.basis.sge.service.recurso;
import com.basis.sge.service.servico.UsuarioServico;
import com.basis.sge.service.servico.dto.ChaveDTO;
import com.basis.sge.service.servico.dto.UsuarioDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping ("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioRecurso {
    @Autowired
    private final UsuarioServico usuarioServico;


    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> listar() {
        List list = usuarioServico.listar();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> buscar(@PathVariable Integer id) {
        UsuarioDTO usuarioDTO = usuarioServico.obterPorId(id);
        return ResponseEntity.ok(usuarioDTO);
    }

    @PostMapping("/login")
    public ResponseEntity<UsuarioDTO>obterPorChave(@RequestBody ChaveDTO chaveDTO){
        UsuarioDTO usuario = usuarioServico.obterPorChave(chaveDTO);
        return ResponseEntity.ok(usuario);
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> inserir(@Valid @RequestBody UsuarioDTO usuarioDTO) throws URISyntaxException {
        UsuarioDTO usuario = usuarioServico.adicionar(usuarioDTO);
        return ResponseEntity.created(new URI("/api/usuarios")).body(usuario);
    }

    @PutMapping
    public ResponseEntity<UsuarioDTO> atualizar(@RequestBody UsuarioDTO usuarioDTO){
        UsuarioDTO usuario = usuarioServico.adicionar(usuarioDTO);
        return ResponseEntity.ok(usuario);

        }


        @DeleteMapping("/{id}")
        public void deletar (@PathVariable Integer id){
            usuarioServico.remover(id);

        }


}

