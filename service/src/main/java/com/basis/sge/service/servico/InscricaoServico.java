package com.basis.sge.service.servico;
import com.basis.sge.service.dominio.Inscricao;
import com.basis.sge.service.repositorio.InscricaoRepositorio;
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

    public List<InscricaoDTO> listar(){
        List<Inscricao> inscricoes = inscricaoRepositorio.findAll();
        return inscricaoMapper.toDto(inscricoes);
    }

    public InscricaoDTO obterPorId(Integer id){return null;}
    public InscricaoDTO salvar(InscricaoDTO inscricaoDTO){return null;}
    public InscricaoDTO editar(InscricaoDTO inscricaoDTO){return null;}
    public void remover(Integer id){}

}
