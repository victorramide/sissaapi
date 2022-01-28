package br.com.sissa.sissaapi.repository;


import br.com.sissa.sissaapi.model.Advogado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdvogadoRepository extends JpaRepository<Advogado, Long> {

  Optional<Advogado> findByEmail(String email);

}
