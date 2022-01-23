package br.com.sissa.sissaapi.repository;

import br.com.sissa.sissaapi.model.Diligencia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DiligenciaRepository extends JpaRepository<Diligencia, Long> {

    List<Diligencia> findByAdvogado_Id(Long id);

}
