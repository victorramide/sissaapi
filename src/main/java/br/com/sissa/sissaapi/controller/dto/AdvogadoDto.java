package br.com.sissa.sissaapi.controller.dto;

import br.com.sissa.sissaapi.model.Advogado;
import br.com.sissa.sissaapi.model.Uf;
import br.com.sissa.sissaapi.repository.DiligenciaRepository;

import java.util.List;
import java.util.stream.Collectors;

public class AdvogadoDto {

    private Long id;
    private String primeiroNome;
    private String ultimoNome;
    private String email;
    private String oab;
    private Uf uf;
    private List<DiligenciaDto> diligencias;

    public AdvogadoDto(Advogado advogado) {
        this.id = advogado.getId();
        this.primeiroNome = advogado.getPrimeiroNome();
        this.ultimoNome = advogado.getUltimoNome();
        this.email = advogado.getEmail();
        this.oab = advogado.getOab();
        this.uf = advogado.getUf();
    }

    public static List<AdvogadoDto> converter(List<Advogado> advogados) {
        return advogados.stream().map(AdvogadoDto::new).collect(Collectors.toList());
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

    public void setDiligencias(List<DiligenciaDto> diligencias) {
        this.diligencias = diligencias;
    }

    public List<DiligenciaDto> getDiligencias() {
        return diligencias;
    }

    public void adicionaDiligencias(DiligenciaRepository diligenciaRepository){
        List<DiligenciaDto> diligencias = DiligenciaDto.converter(diligenciaRepository.findByAdvogado_Id(this.id));
        this.setDiligencias(diligencias);
    }
}
