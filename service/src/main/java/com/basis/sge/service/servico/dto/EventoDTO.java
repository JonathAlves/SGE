package com.basis.sge.service.servico.dto;

<<<<<<< HEAD
import lombok.Getter;
import lombok.Setter;

=======
>>>>>>> 51bef42067148ae8ea03b4ee204ef80a18f8fbf9
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EventoDTO implements Serializable {
    private Integer id;

    private String titulo;

    private LocalDateTime dataInicio;

    private LocalDateTime dataTermino;

    private String descricao;

    private Integer qtVagas;

    private Double valor;

    private String local;

    private Boolean tipoInscricao;

    private Integer idTipoEvento;

    private List<EventoPerguntaDTO> perguntas;

}
