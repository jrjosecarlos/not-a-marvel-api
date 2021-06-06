/**
 *
 */
package br.org.jrjosecarlos.notamarvelapi.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.jrjosecarlos.notamarvelapi.model.Event;

/**
 * Repository interface for {@link Event} entities.
 *
 * @author jrjosecarlos
 */
public interface EventRepository extends JpaRepository<Event, UUID>{

}
