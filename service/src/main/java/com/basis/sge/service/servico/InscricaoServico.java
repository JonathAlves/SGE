package com.basis.sge.service.servico;
import com.basis.sge.service.dominio.Inscricao;
import com.basis.sge.service.dominio.InscricaoResposta;
import com.basis.sge.service.dominio.TipoSituacao;
import com.basis.sge.service.repositorio.InscricaoRepositorio;
import com.basis.sge.service.repositorio.InscricaoRespostaRepositorio;
import com.basis.sge.service.repositorio.TipoSituacaoRepositorio;
import com.basis.sge.service.repositorio.UsuarioRepositorio;
import com.basis.sge.service.servico.dto.EmailDTO;
import com.basis.sge.service.servico.dto.InscricaoDTO;
import com.basis.sge.service.servico.dto.TipoSituacaoDTO;
import com.basis.sge.service.servico.mapper.InscricaoMapper;
//import com.basis.sge.service.utils.EmailUtils;
import com.basis.sge.service.servico.mapper.TipoSituacaoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class InscricaoServico {
    private final InscricaoRepositorio inscricaoRepositorio;
    private final InscricaoMapper inscricaoMapper;
    private final TipoSituacaoRepositorio tipoSituacaoRepositorio;
    private final TipoSituacaoMapper tipoSituacaoMapper;
    private final UsuarioRepositorio usuarioRepositorio;

    public List<InscricaoDTO> listar(){
        List<Inscricao> inscricoes = inscricaoRepositorio.findAll();
        return inscricaoMapper.toDto(inscricoes);
    }

    public InscricaoDTO obterPorId(Integer id){
        Inscricao inscricao = inscricaoRepositorio.findById(id).orElseThrow(() -> new RegraNegocioException("Inscrição não encontrada!"));
        return inscricaoMapper.toDto(inscricao);

    }

    public InscricaoDTO salvar(InscricaoDTO inscricaoDTO){

        Inscricao inscricao = inscricaoMapper.toEntity(inscricaoDTO);

        inscricaoRepositorio.save(inscricao);
        return inscricaoMapper.toDto(inscricao);
    }

    public InscricaoDTO editar(InscricaoDTO inscricaoDTO){
        Inscricao inscricao = inscricaoRepositorio.findById(inscricaoDTO.getId()).orElseThrow(() -> new RegraNegocioException( "Inscrição não encontrada!"));

        inscricaoRepositorio.save(inscricao);
        return inscricaoMapper.toDto(inscricao);
    }
    public void remover(Integer id){
        Inscricao inscricao = inscricaoRepositorio.findById(id).orElseThrow(() -> new RegraNegocioException("Inscrição não encontrada!"));
        inscricaoRepositorio.deleteById(id);
    }
}
