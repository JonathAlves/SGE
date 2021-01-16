package com.basis.sge.service.recurso;
import com.basis.sge.service.servico.TipoSituacaoServico;
import com.basis.sge.service.servico.dto.TipoSituacaoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/inscricoes/tipoSituacao")
@RequiredArgsConstructor
public class TipoSituacaoRecurso {

    private final TipoSituacaoServico tipoSituacaoServico;

    @GetMapping
    public ResponseEntity<List<TipoSituacaoDTO>> listar(){
        List list = tipoSituacaoServico.listar();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity <TipoSituacaoDTO> obterPorId(@PathVariable Integer id){
        TipoSituacaoDTO tipoSituacaoDTO = tipoSituacaoServico.obterPorId(id);
        return ResponseEntity.ok(tipoSituacaoDTO);
    }

    @PostMapping
    public ResponseEntity <TipoSituacaoDTO> salvar(@RequestBody TipoSituacaoDTO tipoSituacaoDTO){
        TipoSituacaoDTO tipoSituacao = tipoSituacaoServico.salvar(tipoSituacaoDTO);
        return ResponseEntity.ok(tipoSituacao);
    }

    @PutMapping
    public ResponseEntity <TipoSituacaoDTO> editar(@RequestBody TipoSituacaoDTO tipoSituacaoDTO){
        TipoSituacaoDTO tipoSituacao = tipoSituacaoServico.editar(tipoSituacaoDTO);
        return ResponseEntity.ok(tipoSituacao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Void> remover (@PathVariable Integer id){
        tipoSituacaoServico.remover(id);
        return ResponseEntity.ok().build();
    }
}
