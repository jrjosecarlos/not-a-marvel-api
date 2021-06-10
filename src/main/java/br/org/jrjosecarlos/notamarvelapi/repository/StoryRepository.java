/**
 *
 */
package br.org.jrjosecarlos.notamarvelapi.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import br.org.jrjosecarlos.notamarvelapi.model.Story;

/**
 * Repository interface for {@link Story} entities.
 *
 * @author jrjosecarlos
 */
public interface StoryRepository extends JpaRepository<Story, UUID>, QuerydslPredicateExecutor<Story> {

}
