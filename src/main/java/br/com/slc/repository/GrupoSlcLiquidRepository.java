package br.com.slc.repository;

import br.com.slc.model.GrupoSlcLiquid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author João Paulo Santarém
 */
@Repository
public interface GrupoSlcLiquidRepository extends JpaRepository<GrupoSlcLiquid, Long> {
}
