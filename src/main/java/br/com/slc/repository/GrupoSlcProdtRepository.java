package br.com.slc.repository;

import br.com.slc.model.GrupoSlcProdt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author João Paulo Santarém
 */
@Repository
public interface GrupoSlcProdtRepository extends JpaRepository<GrupoSlcProdt, Long> {

  Optional<GrupoSlcProdt> findByCodProdtIgnoreCase(String codProdt);

}
