package com.basis.sge.service.builder;

import com.basis.sge.service.dominio.Inscricao;
import com.basis.sge.service.servico.InscricaoServico;
import com.basis.sge.service.servico.dto.InscricaoDTO;
import com.basis.sge.service.servico.mapper.InscricaoMapper;
import com.basis.sge.service.util.IntTestComum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Collection;
import java.util.List;

@Component
public class InscricaoBuilder extends ConstrutorDeEntidade<Inscricao> {

    @Autowired
    private InscricaoMapper inscricaoMapper;

    @Autowired
    private InscricaoServico inscricaoServico;

    @Override
    protected Inscricao construirEntidade() throws ParseException {
        Inscricao inscricao = new Inscricao();
        inscricao.setEvento(inscricao.getEvento());
        inscricao.setUsuario(inscricao.getUsuario());
        inscricao.setTipoSituacao(inscricao.getTipoSituacao());
        return inscricao;
    }

    @Override
    protected Inscricao persistir(Inscricao entidade) {
        InscricaoDTO inscricaoDTO = inscricaoMapper.toDto(entidade);
        InscricaoDTO dtoSalvo = inscricaoServico.salvar(inscricaoDTO);
        return inscricaoMapper.toEntity(dtoSalvo);
    }

    @Override
    protected Collection obterTodos() {
        List<InscricaoDTO> inscricaoDTO = inscricaoServico.listar();
        return inscricaoMapper.toEntity(inscricaoDTO);
    }

    @Override
    protected Inscricao obterPorId(Integer id) {
        InscricaoDTO inscricao = inscricaoServico.obterPorId(id);
        return inscricaoMapper.toEntity(inscricao);
    }

    protected void removerPorId(Integer id){
        inscricaoServico.remover(id);
    }
}
