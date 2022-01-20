package br.com.sissa.sissaapi.controller.dto;

import br.com.sissa.sissaapi.model.Advogado;
import br.com.sissa.sissaapi.model.Diligencia;

import java.time.LocalDateTime;

public class DetalhesDaDiligenciaDto {

    private Long id;
    private String processo;
    private String classe;
    private String tipoDeDiligencia;
    private Boolean prioridade;
    private LocalDateTime dataDeConclusao;
    private LocalDateTime dataDaDiligencia;
    private Advogado advogado;
    private String comentario;


    public DetalhesDaDiligenciaDto(Diligencia diligencia){
        this.id = diligencia.getId();
        this.processo = diligencia.getProcesso();
        this.classe = diligencia.getClasse();
        this.tipoDeDiligencia = diligencia.getTipoDeDiligencia();
        this.prioridade = diligencia.getPrioridade();
        this.dataDeConclusao = diligencia.getDataDaConclusao();
        this.advogado = diligencia.getAdvogado();
        this.dataDaDiligencia = diligencia.getDataDaDiligencia();
        this.comentario = diligencia.getComentario();
    }

    public Long getId() {
        return id;
    }

    public String getProcesso() {
        return processo;
    }

    public String getClasse() {
        return classe;
    }

    public String gettipoDeDiligencia() {
        return tipoDeDiligencia;
    }

    public Boolean getPrioridade() {
        return prioridade;
    }

    public LocalDateTime getDataDeConclusao() {
        return dataDeConclusao;
    }

    public LocalDateTime getDataDaDiligencia() {
        return dataDaDiligencia;
    }

    public Advogado getAdvogado() {
        return advogado;
    }

    public String getComentario() {
        return comentario;
    }
}
