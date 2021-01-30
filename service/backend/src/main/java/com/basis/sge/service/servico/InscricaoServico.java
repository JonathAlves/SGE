package com.basis.sge.service.servico;
import com.basis.sge.service.dominio.Inscricao;
import com.basis.sge.service.dominio.InscricaoResposta;
import com.basis.sge.service.repositorio.InscricaoRepositorio;
import com.basis.sge.service.repositorio.TipoSituacaoRepositorio;
import com.basis.sge.service.servico.Exception.RegraNegocioException;
import com.basis.sge.service.servico.dto.InscricaoDTO;
import com.basis.sge.service.servico.mapper.InscricaoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class InscricaoServico {
    private final InscricaoRepositorio inscricaoRepositorio;
    private final InscricaoMapper inscricaoMapper;
    private final TipoSituacaoRepositorio tipoSituacaoRepositorio;
    private final EmailServico emailServico;




    public List<InscricaoDTO> listar(){
        List<Inscricao> inscricoes = inscricaoRepositorio.findAll();
        return inscricaoMapper.toDto(inscricoes);
    }

    public InscricaoDTO obterPorId(Integer id){
        Inscricao inscricao = inscricaoRepositorio.findById(id).orElseThrow(() -> new RegraNegocioException("Inscrição não encontrada!"));
        return inscricaoMapper.toDto(inscricao);

    }

    public InscricaoDTO salvar(InscricaoDTO inscricaoDTO){
        verificaInscricaoExistente(inscricaoDTO.getIdUsuario(), inscricaoDTO.getIdEvento());
        verificaTipoSituacao(inscricaoDTO.getIdTipoSituacao());

        Inscricao inscricao = inscricaoMapper.toEntity(inscricaoDTO);
        List<InscricaoResposta> respostas = inscricao.getRespostas();
        inscricao.setRespostas(respostas);

        if(respostas != null && !respostas.isEmpty()){
            respostas.forEach(inscricaoResposta -> {
                inscricaoResposta.setInscricao(inscricao);
            });
        }
        emailServico.emailEnviarInscricao(inscricao);
        Inscricao novaInscricao = inscricaoRepositorio.save(inscricao);
        return inscricaoMapper.toDto(novaInscricao);


    }

    public void remover(Integer id){
        Inscricao inscricao = inscricaoRepositorio.findById(id).orElseThrow(() -> new RegraNegocioException("Inscrição não encontrada!"));
        inscricaoRepositorio.deleteById(id);
    }

    public void verificaInscricaoExistente(Integer idUsuario, Integer idEvento){
        for(InscricaoDTO inscr: listar()){
            if((inscr.getIdEvento() == idEvento) && (inscr.getIdUsuario() == idUsuario)){
                throw new RegraNegocioException("Usuario já inscrito neste evento!");
            }
        }
    }

    public void verificaTipoSituacao(Integer idTipoSituacao) {
        if(!tipoSituacaoRepositorio.existsById(idTipoSituacao)){
            throw new RegraNegocioException("Esse Tipo de situação não existe");
        }
    }
}
