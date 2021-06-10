/**
 *
 */
package br.org.jrjosecarlos.notamarvelapi.controller;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.jrjosecarlos.notamarvelapi.controller.dto.CharacterDTO;
import br.org.jrjosecarlos.notamarvelapi.controller.dto.DataWrapperDTO;
import br.org.jrjosecarlos.notamarvelapi.controller.filters.CharacterFilter;
import br.org.jrjosecarlos.notamarvelapi.controller.filters.PagingOptions;
import br.org.jrjosecarlos.notamarvelapi.model.Character;
import br.org.jrjosecarlos.notamarvelapi.service.CharacterService;

/**
 * Main controller for {@link Character}-related operations.
 *
 * @author jrjosecarlos
 */
@RestController
public class CharacterController {

	private final CharacterService service;

	CharacterController(CharacterService service) {
		this.service = service;
	}

	@GetMapping("/public/characters")
	ResponseEntity<DataWrapperDTO<CharacterDTO>> listAllCharacters(@Valid PagingOptions pagingOptions, @Valid CharacterFilter filters) {
		Page<Character> page = service.findAll(pagingOptions, filters);

		return ResponseEntity.ok(DataWrapperDTO.wrap(pagingOptions, page, CharacterDTO::of));
	}
}
