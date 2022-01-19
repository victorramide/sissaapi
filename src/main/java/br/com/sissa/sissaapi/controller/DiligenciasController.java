package br.com.sissa.sissaapi.controller;

import br.com.sissa.sissaapi.controller.dto.DiligenciaDto;
import br.com.sissa.sissaapi.model.Diligencia;
import br.com.sissa.sissaapi.repository.AdvogadoRepository;
import br.com.sissa.sissaapi.repository.DiligenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/diligencias")
public class DiligenciasController {

    @Autowired
    private AdvogadoRepository advogadoRepository;
    @Autowired
    private DiligenciaRepository diligenciaRepository;

    @GetMapping
    public List<DiligenciaDto> listar(){
        List<Diligencia> diligencias = diligenciaRepository.findAll();
        return DiligenciaDto.converter(diligencias);
    }


}
