package br.com.sissa.sissaapi.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Diligencia {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String processo;
    private String classe;
    private String tipoDeDiligencia;
    private String comentario;
    private Boolean prioridade;
    private LocalDate dataDaDiligencia = LocalDate.now();
    private LocalDate dataDaConclusao;
    @ManyToOne
    private Advogado advogado;

    public Diligencia() {
    }

    public Diligencia(String processo, String classe, String tipoDeDiligencia, String comentario, Boolean prioridade, LocalDate dataDaConclusao, Advogado advogado) {
        this.processo = processo;
        this.classe = classe;
        this.tipoDeDiligencia = tipoDeDiligencia;
        this.comentario = comentario;
        this.prioridade = prioridade;
        this.dataDaConclusao = dataDaConclusao;
        this.advogado = advogado;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Diligencia other = (Diligencia) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProcesso() {
        return processo;
    }

    public void setProcesso(String processo) {
        this.processo = processo;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getTipoDeDiligencia() {
        return tipoDeDiligencia;
    }

    public void setTipoDeDiligencia(String tipoDeDiligencia) {
        this.tipoDeDiligencia = tipoDeDiligencia;
    }

    public Boolean getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Boolean prioridade) {
        this.prioridade = prioridade;
    }

    public LocalDate getDataDaDiligencia() {
        return dataDaDiligencia;
    }

    public void setDataDaDiligencia(LocalDate dataDaDiligencia) {
        this.dataDaDiligencia = dataDaDiligencia;
    }

    public LocalDate getDataDaConclusao() {
        return dataDaConclusao;
    }

    public void setDataDaConclusao(LocalDate dataDaConclusao) {
        this.dataDaConclusao = dataDaConclusao;
    }

    public Advogado getAdvogado() {
        return advogado;
    }

    public void setAdvogado(Advogado advogado) {
        this.advogado = advogado;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
