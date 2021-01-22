package com.basis.sge.service.servico;

import com.basis.sge.service.dominio.InscricaoResposta;
import com.basis.sge.service.repositorio.InscricaoRespostaRepositorio;
import com.basis.sge.service.servico.dto.InscricaoRespostaDTO;
import com.basis.sge.service.servico.mapper.InscricaoRespostaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class InscricaoRespostaServico {

    private final InscricaoRespostaRepositorio inscricaoRespostaRepositorio;

    private final InscricaoRespostaMapper inscricaoRespostaMapper;

    //GET
    public List<InscricaoRespostaDTO> listar(){
        List<InscricaoResposta> inscricaoRespostas = inscricaoRespostaRepositorio.findAll();
        return inscricaoRespostaMapper.toDto(inscricaoRespostas);
    }

    // GET {id}
    public InscricaoRespostaDTO obterPorId(Integer Id){
        InscricaoResposta inscricaoResposta = inscricaoRespostaRepositorio.findById(Id)
                .orElseThrow(() -> new RegraNegocioException("Resposta não encontrada"));
        InscricaoRespostaDTO inscricaoRespostaDTO = inscricaoRespostaMapper.toDto(inscricaoResposta);
        return inscricaoRespostaDTO;
    }

    // POST
    public InscricaoRespostaDTO salvar(InscricaoRespostaDTO inscricaoRespostaDTO){
        InscricaoResposta inscricaoResposta = inscricaoRespostaRepositorio.findByResposta(inscricaoRespostaDTO.getResposta());

        if (inscricaoResposta != null){
            throw new RegraNegocioException("Resposta já existe");
        }
        inscricaoRespostaRepositorio.save(inscricaoResposta);
        return inscricaoRespostaMapper.toDto(inscricaoResposta);
    }

    // PUT
    public InscricaoRespostaDTO editar(InscricaoRespostaDTO inscricaoRespostaDTO){
        InscricaoResposta inscricaoResposta = inscricaoRespostaRepositorio.findByResposta(inscricaoRespostaDTO.getResposta());
        if (inscricaoResposta != null){
            inscricaoResposta.setResposta(inscricaoRespostaDTO.getResposta());
        }
        inscricaoRespostaRepositorio.save(inscricaoResposta);
        return inscricaoRespostaMapper.toDto(inscricaoResposta);
    }

    // DELETE {id}
    public void remover(Integer Id) {
        InscricaoResposta inscricaoResposta = inscricaoRespostaRepositorio.findById(Id)
                .orElseThrow(() -> new RegraNegocioException("Resposta não encontrada"));
        inscricaoRespostaRepositorio.deleteById(Id);

    }




}
