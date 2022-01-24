package br.com.sissa.sissaapi.controller.form;

import br.com.sissa.sissaapi.model.Advogado;
import br.com.sissa.sissaapi.model.Uf;
import br.com.sissa.sissaapi.repository.AdvogadoRepository;
import com.sun.istack.NotNull;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;

public class AtualizacaoAdvogadoForm {

    @NotNull @NotEmpty
    private String primeiroNome;
    private String ultimoNome;
    @NotNull @NotEmpty
    private String email;
    @NotNull @NotEmpty
    private String oab;
    @Enumerated(EnumType.STRING)
    private Uf uf;

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

    public Advogado atualizar(Long id, AdvogadoRepository advogadoRepository){
        Advogado advogado = advogadoRepository.getById(id);
        advogado.setPrimeiroNome(this.primeiroNome);
        advogado.setUltimoNome(this.ultimoNome);
        advogado.setEmail(this.email);
        advogado.setOab(this.oab);
        advogado.setUf(this.uf);
        return advogado;
    }
}
