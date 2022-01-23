package br.com.sissa.sissaapi.controller;


import br.com.sissa.sissaapi.controller.dto.AdvogadoDto;
import br.com.sissa.sissaapi.model.Advogado;
import br.com.sissa.sissaapi.repository.AdvogadoRepository;
import br.com.sissa.sissaapi.repository.DiligenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/advogados")
public class AdvogadosController {

    @Autowired
    private AdvogadoRepository advogadoRepository;
    @Autowired
    private DiligenciaRepository diligenciaRepository;

    @GetMapping
    public List<AdvogadoDto> listarAdvogados(){
        List<Advogado> advogados = advogadoRepository.findAll();
        List<AdvogadoDto> advogadoDtos = AdvogadoDto.converter(advogados);
        advogadoDtos.forEach(advogadoDto -> advogadoDto.adicionaDiligencias(diligenciaRepository));
        return advogadoDtos;
    }


}
