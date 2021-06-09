package br.org.jrjosecarlos.notamarvelapi.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.org.jrjosecarlos.notamarvelapi.controller.filters.CharacterFilter;
import br.org.jrjosecarlos.notamarvelapi.model.Character;
import br.org.jrjosecarlos.notamarvelapi.repository.CharacterRepository;
import br.org.jrjosecarlos.notamarvelapi.service.CharacterService;

/**
 * Implementation of {@link CharacterService}.
 *
 * @author jrjosecarlos
 */
@Service
public class CharacterServiceImpl implements CharacterService {

	private final CharacterRepository repository;

	CharacterServiceImpl(CharacterRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Character> findAll(CharacterFilter filter) {
		return repository.findAll();
	}

}
