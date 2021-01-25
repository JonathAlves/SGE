package com.basis.sge.service.servico;

import com.basis.sge.service.dominio.TipoSituacao;
import com.basis.sge.service.repositorio.TipoSituacaoRepositorio;
import com.basis.sge.service.servico.dto.TipoSituacaoDTO;
import com.basis.sge.service.servico.mapper.TipoSituacaoMapper;
import com.basis.sge.service.servico.Exception.RegraNegocioException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TipoSituacaoServico {

    private final TipoSituacaoRepositorio tipoSituacaoRepositorio;
    private final TipoSituacaoMapper tipoSituacaoMapper;

    public List<TipoSituacaoDTO> listar(){
        List<TipoSituacao> tipoSituacaoList = tipoSituacaoRepositorio.findAll();
        return tipoSituacaoMapper.toDto(tipoSituacaoList);
    }

    public TipoSituacaoDTO obterPorId(Integer id){
        TipoSituacao tipoSituacao = tipoSituacaoRepositorio.findById(id).orElseThrow(() -> new RegraNegocioException("Tipo de situação não encontrado!"));
        return tipoSituacaoMapper.toDto(tipoSituacao);
    }


    public TipoSituacaoDTO editar(TipoSituacaoDTO tipoSituacaoDTO){
        TipoSituacao tipoSituacao = tipoSituacaoRepositorio.findById(tipoSituacaoDTO.getId()).orElseThrow(() -> new RegraNegocioException("Tipo de situação não encontrado!"));
        return tipoSituacaoMapper.toDto(tipoSituacao);
    }

//    public void remover(Integer id){
//        TipoSituacao tipoSituacao = tipoSituacaoRepositorio.findById(id).orElseThrow(() -> new RegraNegocioException("Não foi encontrada situação correspondente"));
//        System.out.println("Situação removida!");
//    }
}
