package br.org.jrjosecarlos.notamarvelapi.service.impl;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.querydsl.core.types.Predicate;

import br.org.jrjosecarlos.notamarvelapi.controller.filters.CharacterFilter;
import br.org.jrjosecarlos.notamarvelapi.controller.filters.PagingOptions;
import br.org.jrjosecarlos.notamarvelapi.model.Character;
import br.org.jrjosecarlos.notamarvelapi.repository.CharacterPredicateBuilder;
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
	public Iterable<Character> findAll(PagingOptions pagingOptions, CharacterFilter filter) {
		CharacterPredicateBuilder builder = CharacterPredicateBuilder.of(pagingOptions, filter);
		Predicate predicate = builder.buildPredicate();
		Pageable pageable = builder.buildPageable();

		return repository.findAll(predicate, pageable);
	}

}
