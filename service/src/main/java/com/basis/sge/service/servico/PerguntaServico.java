package com.basis.sge.service.servico;

import com.basis.sge.service.dominio.Pergunta;
import com.basis.sge.service.repositorio.PerguntaRepositorio;
import com.basis.sge.service.servico.dto.PerguntaDTO;
import com.basis.sge.service.servico.mapper.PerguntaMapper;
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
    public List<PerguntaDTO> listar(){
        List<Pergunta> perguntas = perguntaRepositorio.findAll();
        return perguntaMapper.toDto(perguntas);
    }

    // GET {id}
    public PerguntaDTO obterPorId(Integer Id){
        Pergunta pergunta = perguntaRepositorio.findById(Id)
                .orElseThrow(() -> new RegraNegocioException("Pergunta não encontrada"));
        PerguntaDTO perguntaDTO = perguntaMapper.toDto(pergunta);
        return perguntaDTO;
    }

    // POST
    public PerguntaDTO salvar(PerguntaDTO perguntaDTO){
        Pergunta pergunta = perguntaRepositorio.findByTitulo(perguntaDTO.getTitulo());

        if (pergunta != null){
            throw new RegraNegocioException("Pergunta já existe");
        }
        perguntaRepositorio.save(pergunta);
        return perguntaMapper.toDto(pergunta);
    }

    // PUT
    public PerguntaDTO editar(PerguntaDTO perguntaDTO){
        Pergunta pergunta = perguntaRepositorio.findByTitulo(perguntaDTO.getTitulo());
        if (pergunta != null){
            pergunta.setTitulo(perguntaDTO.getTitulo());
        }
        perguntaRepositorio.save(pergunta);
        return perguntaMapper.toDto(pergunta);
    }

    // DELETE {id}
    public void remover(Integer Id) {
        Pergunta pergunta = perguntaRepositorio.findById(Id)
                .orElseThrow(() -> new RegraNegocioException("Pergunta não encontrada"));
        perguntaRepositorio.deleteById(Id);

    }




}
