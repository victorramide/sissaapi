package br.com.sissa.sissaapi.controller.form;

import br.com.sissa.sissaapi.model.Advogado;
import br.com.sissa.sissaapi.model.Diligencia;
import br.com.sissa.sissaapi.repository.AdvogadoRepository;
import com.sun.istack.NotNull;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.Optional;

public class DiligenciaForm {

    @NotNull @NotEmpty
    private String processo;
    private String classe;
    @NotNull @NotEmpty
    private String tipoDeDiligencia;
    private Boolean prioridade;
    private LocalDate dataDeConclusao;
    @NotNull @NotEmpty
    private String emailAdvogado;
    private String comentario;


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

    public LocalDate getDataDeConclusao() {
        return dataDeConclusao;
    }

    public void setDataDeConclusao(LocalDate dataDeConclusao) {
        this.dataDeConclusao = dataDeConclusao;
    }

    public String getEmailAdvogado() {
        return emailAdvogado;
    }

    public void setEmailAdvogado(String emailAdvogado) {
        this.emailAdvogado = emailAdvogado;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Diligencia converter(AdvogadoRepository advogadoRepository){
        Optional<Advogado> advogado = advogadoRepository.findByEmail(emailAdvogado);
        if(advogado.isPresent()) {
            return new Diligencia(processo, classe, tipoDeDiligencia, comentario, prioridade, dataDeConclusao, advogado.get());
        }
        return null;
    }
}
