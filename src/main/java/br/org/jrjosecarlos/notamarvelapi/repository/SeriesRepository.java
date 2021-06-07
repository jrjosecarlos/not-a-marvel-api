/**
 * 
 */
package br.org.jrjosecarlos.notamarvelapi.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.jrjosecarlos.notamarvelapi.model.Series;

/**
 * Repository interface for {@link Series} entities.
 *
 * @author jrjosecarlos
 */
public interface SeriesRepository extends JpaRepository<Series, UUID> {

}
