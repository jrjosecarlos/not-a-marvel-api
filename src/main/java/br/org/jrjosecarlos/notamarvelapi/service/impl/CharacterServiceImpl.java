package br.org.jrjosecarlos.notamarvelapi.service.impl;

import org.springframework.stereotype.Service;

import com.querydsl.core.types.Predicate;

import br.org.jrjosecarlos.notamarvelapi.controller.filters.CharacterFilter;
import br.org.jrjosecarlos.notamarvelapi.controller.filters.PagingOptions;
import br.org.jrjosecarlos.notamarvelapi.model.Character;
import br.org.jrjosecarlos.notamarvelapi.repository.CharacterPredicateBuilder;
import br.org.jrjosecarlos.notamarvelapi.repository.CharacterRepository;
import br.org.jrjosecarlos.notamarvelapi.repository.OffsetBasedPageRequest;
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
	public Iterable<Character> findAll(PagingOptions paging, CharacterFilter filter) {
		CharacterPredicateBuilder builder = CharacterPredicateBuilder.of(filter);
		Predicate predicate = builder.build();
		OffsetBasedPageRequest pageRequest = new OffsetBasedPageRequest(paging.getOffset(), paging.getLimit());

		return repository.findAll(predicate, pageRequest);
	}

}
