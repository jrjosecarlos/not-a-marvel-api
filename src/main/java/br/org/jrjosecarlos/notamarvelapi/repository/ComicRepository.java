/**
 * 
 */
package br.org.jrjosecarlos.notamarvelapi.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.jrjosecarlos.notamarvelapi.model.Comic;

/**
 * Repository interface for {@link Comic} entities.
 *
 * @author jrjosecarlos
 */
public interface ComicRepository extends JpaRepository<Comic, UUID>{

}
