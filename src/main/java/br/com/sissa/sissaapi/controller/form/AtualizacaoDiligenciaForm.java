package br.com.sissa.sissaapi.controller.form;

import br.com.sissa.sissaapi.model.Diligencia;
import br.com.sissa.sissaapi.repository.DiligenciaRepository;
import com.sun.istack.NotNull;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

public class AtualizacaoDiligenciaForm {

    @NotNull @NotEmpty
    private String processo;
    @NotNull
    private LocalDate dataDaConclusao;
    private String comentario;



    public String getProcesso() {
        return processo;
    }

    public void setProcesso(String processo) {
        this.processo = processo;
    }

    public LocalDate getDataDaConclusao() {
        return dataDaConclusao;
    }

    public void setDataDaConclusao(LocalDate dataDaConclusao) {
        this.dataDaConclusao = dataDaConclusao;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Diligencia atualizar(Long id, DiligenciaRepository diligenciaRepository){
        Diligencia diligencia = diligenciaRepository.getById(id);
        diligencia.setProcesso(this.processo);
        diligencia.setDataDaConclusao(this.dataDaConclusao);
        diligencia.setComentario(this.comentario);
        return diligencia;
    }
}
