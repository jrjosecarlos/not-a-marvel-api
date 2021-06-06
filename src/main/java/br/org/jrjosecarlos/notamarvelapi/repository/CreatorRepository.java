/**
 * 
 */
package br.org.jrjosecarlos.notamarvelapi.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.jrjosecarlos.notamarvelapi.model.Creator;

/**
 * Repository interface for {@link Creator} entities.
 *
 * @author jrjosecarlos
 */
public interface CreatorRepository extends JpaRepository<Creator, UUID>{

}
