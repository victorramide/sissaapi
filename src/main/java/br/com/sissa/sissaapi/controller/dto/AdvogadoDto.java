package br.com.sissa.sissaapi.controller.dto;

import br.com.sissa.sissaapi.model.Advogado;
import br.com.sissa.sissaapi.model.Uf;
import br.com.sissa.sissaapi.repository.DiligenciaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Collectors;

public class AdvogadoDto {

    private Long id;
    private String primeiroNome;
    private String ultimoNome;
    private String email;
    private String oab;
    private Uf uf;
    private Page<DiligenciaDto> diligencias;

    public AdvogadoDto(Advogado advogado) {
        this.id = advogado.getId();
        this.primeiroNome = advogado.getPrimeiroNome();
        this.ultimoNome = advogado.getUltimoNome();
        this.email = advogado.getEmail();
        this.oab = advogado.getOab();
        this.uf = advogado.getUf();
    }

    public static Page<AdvogadoDto> converter(Page<Advogado> advogados) {
        return advogados.map(AdvogadoDto::new);
    }

    public Long getId() {
        return id;
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public String getUltimoNome() {
        return ultimoNome;
    }

    public String getEmail() {
        return email;
    }

    public String getOab() {
        return oab;
    }

    public Uf getUf() {
        return uf;
    }

    public void setDiligencias(Page<DiligenciaDto> diligencias) {
        this.diligencias = diligencias;
    }

    public Page<DiligenciaDto> getDiligencias() {
        return diligencias;
    }

    public void adicionaDiligencias(DiligenciaRepository diligenciaRepository, Pageable paginacao){
        Page<DiligenciaDto> diligencias = DiligenciaDto.converter(diligenciaRepository.findByAdvogado_Id(this.id, paginacao));
        this.setDiligencias(diligencias);
    }
}
