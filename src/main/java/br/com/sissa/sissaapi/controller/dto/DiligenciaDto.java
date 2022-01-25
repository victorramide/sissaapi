package br.com.sissa.sissaapi.controller.dto;

import br.com.sissa.sissaapi.model.Diligencia;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class DiligenciaDto {

    private Long id;
    private String processo;
    private String classe;
    private String diligencia;
    private Boolean prioridade;
    private LocalDate dataDaConclusao;
    private String advogado;

    public DiligenciaDto(Diligencia diligencia){
        this.id = diligencia.getId();
        this.processo = diligencia.getProcesso();
        this.classe = diligencia.getClasse();
        this.diligencia = diligencia.getTipoDeDiligencia();
        this.prioridade = diligencia.getPrioridade();
        this.dataDaConclusao = diligencia.getDataDaConclusao();
        this.advogado = diligencia.getAdvogado().getOab()+"/"+diligencia.getAdvogado().getUf();
    }

    public static Page<DiligenciaDto> converter(Page<Diligencia> diligencias){
        return diligencias.map(DiligenciaDto::new);
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

    public String getDiligencia() {
        return diligencia;
    }

    public Boolean getPrioridade() {
        return prioridade;
    }

    public LocalDate getDataDaConclusao() {
        return dataDaConclusao;
    }

    public String getAdvogado() {
        return advogado;
    }
}
