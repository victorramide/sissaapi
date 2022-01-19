package br.com.sissa.sissaapi.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Diligencia {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String processo;
    @Enumerated(EnumType.STRING)
    private ClasseProcessual classe;
    @Enumerated(EnumType.STRING)
    private TipoDeDiligencia tipoDeDiligencia;
    private Boolean prioridade;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime dataDaDiligencia = LocalDateTime.now();
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime dataDaConclusao;
    @ManyToOne
    private Advogado advogado;

    public Diligencia() {
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

    public ClasseProcessual getClasse() {
        return classe;
    }

    public void setClasse(ClasseProcessual classe) {
        this.classe = classe;
    }

    public TipoDeDiligencia getTipoDeDiligencia() {
        return tipoDeDiligencia;
    }

    public void setTipoDeDiligencia(TipoDeDiligencia tipoDeDiligencia) {
        this.tipoDeDiligencia = tipoDeDiligencia;
    }

    public Boolean getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Boolean prioridade) {
        this.prioridade = prioridade;
    }

    public LocalDateTime getDataDaDiligencia() {
        return dataDaDiligencia;
    }

    public void setDataDaDiligencia(LocalDateTime dataDaDiligencia) {
        this.dataDaDiligencia = dataDaDiligencia;
    }

    public LocalDateTime getDataDaConclusao() {
        return dataDaConclusao;
    }

    public void setDataDaConclusao(LocalDateTime dataDaConclusao) {
        this.dataDaConclusao = dataDaConclusao;
    }

    public Advogado getAdvogado() {
        return advogado;
    }

    public void setAdvogado(Advogado advogado) {
        this.advogado = advogado;
    }
}
