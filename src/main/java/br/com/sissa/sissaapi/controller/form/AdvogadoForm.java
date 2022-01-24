package br.com.sissa.sissaapi.controller.form;

import br.com.sissa.sissaapi.model.Advogado;
import br.com.sissa.sissaapi.model.Diligencia;
import br.com.sissa.sissaapi.model.Uf;
import br.com.sissa.sissaapi.repository.AdvogadoRepository;
import com.sun.istack.NotNull;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

public class AdvogadoForm {

    @NotNull @NotEmpty
    private String primeiroNome;
    private String ultimoNome;
    @NotNull @NotEmpty
    private String email;
    @NotNull @NotEmpty
    private String oab;
    @Enumerated(EnumType.STRING)
    private Uf uf;
    private List<Diligencia> diligencias = new ArrayList<>();

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getUltimoNome() {
        return ultimoNome;
    }

    public void setUltimoNome(String ultimoNome) {
        this.ultimoNome = ultimoNome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOab() {
        return oab;
    }

    public void setOab(String oab) {
        this.oab = oab;
    }

    public Uf getUf() {
        return uf;
    }

    public void setUf(Uf uf) {
        this.uf = uf;
    }

    public List<Diligencia> getDiligencias() {
        return diligencias;
    }

    public void setDiligencias(List<Diligencia> diligencias) {
        this.diligencias = diligencias;
    }

    public Advogado converter(){

        return new Advogado(this.primeiroNome, this.ultimoNome, this.oab, this.uf, this.email, this.diligencias);
    }

}
