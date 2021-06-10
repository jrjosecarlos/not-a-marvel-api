package br.org.jrjosecarlos.notamarvelapi.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.querydsl.core.types.Predicate;

import br.org.jrjosecarlos.notamarvelapi.controller.filters.CharacterFilter;
import br.org.jrjosecarlos.notamarvelapi.controller.filters.PagingOptions;
import br.org.jrjosecarlos.notamarvelapi.model.Character;
import br.org.jrjosecarlos.notamarvelapi.repository.CharacterQueryParamsBuilder;
import br.org.jrjosecarlos.notamarvelapi.repository.CharacterRepository;
import br.org.jrjosecarlos.notamarvelapi.service.CharacterService;
import br.org.jrjosecarlos.notamarvelapi.service.StoryService;

/**
 * Implementation of {@link CharacterService}.
 *
 * @author jrjosecarlos
 */
@Service
@Transactional(readOnly = true)
public class CharacterServiceImpl implements CharacterService {

	private final CharacterRepository repository;

	private final StoryService storyService;

	CharacterServiceImpl(CharacterRepository repository, StoryService storyService) {
		this.repository = repository;
		this.storyService = storyService;
	}

	@Override
	public Page<Character> findAll(PagingOptions pagingOptions, CharacterFilter filter) {
		CharacterQueryParamsBuilder builder = CharacterQueryParamsBuilder.of(pagingOptions, filter);
		Predicate predicate = builder.buildPredicate();
		Pageable pageable = builder.buildPageable();

		Page<Character> page = repository.findAll(predicate, pageable);
		page.forEach(c -> c.setStoryPage(storyService.findByCharacter(c)));
		return page;
	}

}
