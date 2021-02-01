package com.basis.sge.service.servico;

import com.basis.sge.service.dominio.Evento;
import com.basis.sge.service.dominio.EventoPergunta;
import com.basis.sge.service.dominio.Usuario;
import com.basis.sge.service.repositorio.EventoPerguntaRepositorio;
import com.basis.sge.service.repositorio.EventoRepositorio;
import com.basis.sge.service.repositorio.TipoEventoRepositorio;
import com.basis.sge.service.servico.Exception.RegraNegocioException;
import com.basis.sge.service.servico.dto.EventoDTO;
import com.basis.sge.service.servico.mapper.EventoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.basis.sge.service.servico.Exception.RegraNegocioException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class EventoServico {

    private final EventoRepositorio eventoRepositorio;
    private final TipoEventoRepositorio tipoEventoRepositorio;
    private final EventoMapper eventoMapper;
    private final EventoPerguntaRepositorio eventoPerguntaRepositorio;

    public List<EventoDTO> listar() {
        List<Evento> eventos = eventoRepositorio.findAll();
        return eventoMapper.toDto(eventos);
    }

    public EventoDTO obterPorId(Integer id) {
        Evento evento = eventoRepositorio.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Evento não encontrado!"));
        return eventoMapper.toDto(evento);
    }

//    private Evento obter(Integer id) {
//        return eventoRepositorio.findById(id)
//                .orElseThrow(() -> new RegraNegocioException("Evento não encontrado"));
//    }

    public EventoDTO salvar(EventoDTO eventoDTO) {
        verificaTitulo(eventoDTO.getTitulo());
        verificaTipoEvento(eventoDTO.getIdTipoEvento());
        verificaNumero(eventoDTO.getQtVagas());
        verificaNumero(eventoDTO.getValor());
        if(eventoDTO.getTipoInscricao() == null){
            throw new RegraNegocioException("Tipo de inscrição não pode ser NULO!");
        }

        Evento novoEvento = eventoMapper.toEntity(eventoDTO);
        List<EventoPergunta> perguntas = novoEvento.getPerguntas();
        novoEvento.setPerguntas(new ArrayList<>());
        eventoRepositorio.save(novoEvento);

        perguntas.forEach(pergunta -> pergunta.setEvento(novoEvento));
        eventoPerguntaRepositorio.saveAll(perguntas);

        return eventoMapper.toDto(novoEvento);
    }

    public EventoDTO editar(EventoDTO eventoDTO) {
        Evento evento = eventoRepositorio.findById(eventoDTO.getId()).orElseThrow(()
                -> new RegraNegocioException("Evento não encontrado!"));
        verificaTipoEvento(eventoDTO.getIdTipoEvento());
        Evento eventoRecebido = eventoMapper.toEntity(eventoDTO);
        eventoRecebido.setTitulo(eventoDTO.getTitulo());
        eventoRecebido.setDataInicio(eventoDTO.getDataInicio());
        eventoRecebido.setDataTermino(eventoDTO.getDataTermino());
        eventoRecebido.setDescricao(eventoDTO.getDescricao());
        eventoRecebido.setQtVagas(eventoDTO.getQtVagas());
        eventoRecebido.setValor(eventoDTO.getValor());
        eventoRecebido.setLocal(eventoDTO.getLocal());
        eventoRecebido.setTipoInscricao(eventoDTO.getTipoInscricao());
//        if (eventoRepositorio.existsByTitulo(eventoDTO.getTitulo())) {
//            throw new RegraNegocioException("Um evento com esse titulo já existe");
//        } else {
//            eventoRepositorio.save(eventoRecebido);
//        }
        eventoRepositorio.save(eventoRecebido);
        return eventoMapper.toDto(eventoRecebido);
    }

    public void remover(Integer id) {
        verificaIdEvento(id);
        eventoRepositorio.deleteById(id);
    }

    //Verifica o numero se é maior que 0
    public void verificaNumero(Number n) {
        if (n != null && n.doubleValue() < 0) {
            throw new RegraNegocioException("Passe um número maior que 0");
        }
    }

    //Verifica se o titulo do evento já existe
    public void verificaTitulo(String titulo) {
        if (eventoRepositorio.existsByTitulo(titulo)) {
            throw new RegraNegocioException("Um evento com esse titulo já existe");
        }
    }

    //verifica se o tipo de evento existe no banco
    public void verificaTipoEvento(Integer idTipoEvento) {
        if (!tipoEventoRepositorio.existsById(idTipoEvento)) {
            throw new RegraNegocioException("Esse Tipo de Evento não existe");
        }
    }

    //verifica se o evento correspondente ao id existe
    public void verificaIdEvento(Integer idEvento) {
        if (!eventoRepositorio.existsById(idEvento)) {
            throw new RegraNegocioException("Evento Não Existe");
        }
    }



}