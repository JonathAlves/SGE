package com.basis.sge.service.servico;

import com.basis.sge.service.dominio.Pergunta;
import com.basis.sge.service.repositorio.PerguntaRepositorio;
import com.basis.sge.service.servico.Exception.RegraNegocioException;
import com.basis.sge.service.servico.dto.PerguntaDTO;
import com.basis.sge.service.servico.mapper.PerguntaMapper;
import com.basis.sge.service.servico.Exception.RegraNegocioException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
public class PerguntaServico {

    private final PerguntaRepositorio perguntaRepositorio;
    private final PerguntaMapper perguntaMapper;

    // GET
    public List<PerguntaDTO> listar() {
        List<Pergunta> listarPerguntas = perguntaRepositorio.findAll();
        return perguntaMapper.toDto(listarPerguntas);
    }

    // GET {id}
    public PerguntaDTO obterPorId(Integer id) {
        Pergunta pergunta = perguntaRepositorio.findById(id).orElseThrow(() -> new RegraNegocioException("Pergunta não encontrada"));
        return perguntaMapper.toDto(pergunta);
    }

    // POST
    public PerguntaDTO salvar(PerguntaDTO perguntaDTO) {
        if (perguntaDTO.getId() != null){
            Pergunta pergunta = perguntaRepositorio.findById(perguntaDTO.getId()).orElseThrow(() -> new RegraNegocioException(("Pergunta não existe")));
        }
        else
            checarDuplicata(perguntaDTO);

        Pergunta pergunta = perguntaMapper.toEntity(perguntaDTO);
        Pergunta perguntaSalvar = perguntaRepositorio.save(pergunta);
        return perguntaMapper.toDto(perguntaSalvar);

    }

    private void checarDuplicata(PerguntaDTO novaPergunta){
        for(PerguntaDTO perguntaInstancia: listar()){
            if(perguntaInstancia.getTitulo().equals(novaPergunta.getTitulo())){
                throw new RegraNegocioException("Perguntas duplicadas");
            }
        }
    }

    // DELETE {id}
    public void remover(Integer id) {
        Pergunta pergunta = perguntaRepositorio.findById(id).orElseThrow(() -> new RegraNegocioException("Pergunta não encontrado"));
        perguntaRepositorio.deleteById(id);
    }
}