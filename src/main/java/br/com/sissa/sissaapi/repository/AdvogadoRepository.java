package br.com.sissa.sissaapi.repository;


import br.com.sissa.sissaapi.model.Advogado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvogadoRepository extends JpaRepository<Advogado, Long> {

  Advogado findByEmail(String email);

}
