package br.com.sissa.sissaapi.controller;


import br.com.sissa.sissaapi.controller.dto.AdvogadoDto;
import br.com.sissa.sissaapi.controller.form.AdvogadoForm;
import br.com.sissa.sissaapi.controller.form.AtualizacaoAdvogadoForm;
import br.com.sissa.sissaapi.model.Advogado;
import br.com.sissa.sissaapi.model.Diligencia;
import br.com.sissa.sissaapi.repository.AdvogadoRepository;
import br.com.sissa.sissaapi.repository.DiligenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/advogados")
public class AdvogadosController {

    @Autowired
    private AdvogadoRepository advogadoRepository;
    @Autowired
    private DiligenciaRepository diligenciaRepository;

    @GetMapping
    public Page<AdvogadoDto> listarAdvogados(@PageableDefault(sort = "id", direction = Sort.Direction.ASC, page = 0,
            size = 10) Pageable paginacao){
        Page<Advogado> advogados = advogadoRepository.findAll(paginacao);
        Page<AdvogadoDto> advogadoDtos = AdvogadoDto.converter(advogados);
        advogadoDtos.forEach(advogadoDto -> advogadoDto.adicionaDiligencias(diligenciaRepository, paginacao));
        return advogadoDtos;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<AdvogadoDto> cadastrarAdvogado(@RequestBody @Valid AdvogadoForm form, UriComponentsBuilder uriBuilder){
        Advogado advogado = form.converter();
        advogadoRepository.save(advogado);
        URI uri = uriBuilder.path("/advogados/{id}").buildAndExpand(advogado.getId()).toUri();
        return ResponseEntity.created(uri).body(new AdvogadoDto(advogado));
    }

    @PatchMapping("/{id}")
    @Transactional
    public ResponseEntity<AdvogadoDto> atualizarAdvogado(@RequestBody @Valid AtualizacaoAdvogadoForm form,@PathVariable Long id){

        Optional<Advogado> optional = advogadoRepository.findById(id);
        if(optional.isPresent()){
            Advogado advogado = form.atualizar(id, advogadoRepository);
            return ResponseEntity.ok(new AdvogadoDto(advogado));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> removerAdvogado(@PathVariable Long id){
        Optional<Advogado> optional = advogadoRepository.findById(id);
        if(optional.isPresent()){
            advogadoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
