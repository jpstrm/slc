package br.com.slc.repository;

import br.com.slc.model.Slc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author João Paulo Santarém
 */
@Repository
public interface SlcRepository extends JpaRepository<Slc, Long> {
}
