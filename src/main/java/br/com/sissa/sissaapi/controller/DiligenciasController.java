package br.com.sissa.sissaapi.controller;

import br.com.sissa.sissaapi.controller.dto.DetalhesDaDiligenciaDto;
import br.com.sissa.sissaapi.controller.dto.DiligenciaDto;
import br.com.sissa.sissaapi.controller.form.AtualizacaoDiligenciaForm;
import br.com.sissa.sissaapi.controller.form.DiligenciaForm;
import br.com.sissa.sissaapi.model.Diligencia;
import br.com.sissa.sissaapi.repository.AdvogadoRepository;
import br.com.sissa.sissaapi.repository.DiligenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{id}")
    public ResponseEntity<DetalhesDaDiligenciaDto> detalharDiligencia(@PathVariable Long id){

        Optional<Diligencia> diligencia = diligenciaRepository.findById(id);
        if(diligencia.isPresent()){
            return ResponseEntity.ok(new DetalhesDaDiligenciaDto(diligencia.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DiligenciaDto> cadastrarDiligencia(@RequestBody @Valid DiligenciaForm form, UriComponentsBuilder uriBuilder){
        Diligencia diligencia = form.converter(advogadoRepository);
        diligenciaRepository.save(diligencia);
        URI uri = uriBuilder.path("/diligencias/{id}").buildAndExpand(diligencia.getId()).toUri();
        return ResponseEntity.created(uri).body(new DiligenciaDto(diligencia));
    }

    @PatchMapping("/{id}")
    @Transactional
    public ResponseEntity<DiligenciaDto> atualizarDiligencia(@PathVariable Long id,@RequestBody @Valid AtualizacaoDiligenciaForm form){
        Optional<Diligencia> optional = diligenciaRepository.findById(id);
        if(optional.isPresent()){
            Diligencia diligencia = form.atualizar(id, diligenciaRepository);
            return ResponseEntity.ok(new DiligenciaDto(diligencia));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> removerDiligencia(@PathVariable Long id){
        Optional<Diligencia> optional = diligenciaRepository.findById(id);
        if(optional.isPresent()){
            diligenciaRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
