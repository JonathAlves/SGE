package com.basis.sge.service.builder;

import com.basis.sge.service.dominio.Pergunta;
import com.basis.sge.service.servico.PerguntaServico;
import com.basis.sge.service.servico.dto.PerguntaDTO;
import com.basis.sge.service.servico.mapper.PerguntaMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.util.Collection;
import java.util.List;

public class PerguntaBuilder extends ConstrutorDeEntidade<Pergunta>{

    @Autowired
    private PerguntaServico perguntaServico;

    @Autowired
    private PerguntaMapper perguntaMapper;

    @Override
    protected Pergunta construirEntidade() throws ParseException {
        Pergunta pergunta = new Pergunta();
        pergunta.setTitulo("Já programar em ruby?");
        pergunta.setObrigatoriedade(true);
        return pergunta;
    }

    @Override
    protected Pergunta persistir(Pergunta entidade) {
        PerguntaDTO perguntaDTO = perguntaMapper.toDto(entidade);
        PerguntaDTO salvo = perguntaServico.salvar(perguntaDTO);
        return perguntaMapper.toEntity(salvo);
    }

    @Override
    protected Collection<Pergunta> obterTodos() {
        List<PerguntaDTO> perguntaDTOS = perguntaServico.listar();
        return perguntaMapper.toEntity(perguntaDTOS);
    }

    @Override
    protected Pergunta obterPorId(Long id) {
        return null;
    }

    @Autowired
    protected Pergunta obterPorId(Integer id) {
        PerguntaDTO pergunta = perguntaServico.obterPorId(id);
        return perguntaMapper.toEntity(pergunta);
    }

    protected void deletarPorId(Integer id){
        perguntaServico.remover(id);
    }
}
