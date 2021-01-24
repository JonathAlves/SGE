package com.basis.sge.service.builder;

import com.basis.sge.service.dominio.Inscricao;
import com.basis.sge.service.dominio.TipoEvento;
import com.basis.sge.service.dominio.TipoSituacao;
import com.basis.sge.service.repositorio.InscricaoRepositorio;
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

    @Autowired
    private InscricaoRepositorio inscricaoRepositorio;

    @Override
    public Inscricao construirEntidade() throws ParseException {
        TipoSituacao tipoSituacao = new TipoSituacao();
        tipoSituacao.setDescricao("Aguardando aprovação");
        tipoSituacao.setId(1);

        TipoEvento tipoEvento = new TipoEvento();
        tipoEvento.setDescricao("Mini curso");
        tipoEvento.setId(2);

        Inscricao inscricao = new Inscricao();
        inscricao.getEvento();
        inscricao.getUsuario();
        inscricao.setTipoSituacao(tipoSituacao);

        return inscricao;
    }

    @Override
    public Inscricao persistir(Inscricao entidade) {
        InscricaoDTO inscricaoDTO = inscricaoMapper.toDto(entidade);
        InscricaoDTO dtoSalvo = inscricaoServico.salvar(inscricaoDTO);
        return inscricaoMapper.toEntity(dtoSalvo);
    }

    @Override
    public Collection obterTodos() {
        return inscricaoRepositorio.findAll();
    }

    @Override
    public Inscricao obterPorId(Integer id) {
        InscricaoDTO inscricao = inscricaoServico.obterPorId(id);
        return inscricaoMapper.toEntity(inscricao);
    }

    public void removerPorId(Integer id){
        inscricaoRepositorio.deleteById(id);
    }

    public void limparBanco(){
        inscricaoRepositorio.deleteAll();
    }

    public InscricaoDTO convertToDto(Inscricao inscricao){
        return inscricaoMapper.toDto(inscricao);
    }

}
