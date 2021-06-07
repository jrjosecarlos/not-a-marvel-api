/**
 * 
 */
package br.org.jrjosecarlos.notamarvelapi.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.jrjosecarlos.notamarvelapi.model.Character;


/**
 * Repository interface for {@link Character} entities.
 *
 * @author jrjosecarlos
 */
public interface CharacterRepository extends JpaRepository<Character, UUID>{

}
