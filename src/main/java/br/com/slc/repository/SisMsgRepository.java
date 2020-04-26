package br.com.slc.repository;

import br.com.slc.model.SisMsg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author João Paulo Santarém
 */
@Repository
public interface SisMsgRepository extends JpaRepository<SisMsg, Long> {
}
