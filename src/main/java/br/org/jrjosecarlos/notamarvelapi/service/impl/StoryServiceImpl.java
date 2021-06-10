package br.org.jrjosecarlos.notamarvelapi.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.org.jrjosecarlos.notamarvelapi.model.Character;
import br.org.jrjosecarlos.notamarvelapi.model.Story;
import br.org.jrjosecarlos.notamarvelapi.repository.StoryQueryParamsBuilder;
import br.org.jrjosecarlos.notamarvelapi.repository.StoryRepository;
import br.org.jrjosecarlos.notamarvelapi.service.StoryService;

/**
 * Implementation of {@link StoryService}.
 *
 * @author jrjosecarlos
 */
@Service
@Transactional(readOnly = true)
public class StoryServiceImpl implements StoryService {

	private final StoryRepository repository;

	StoryServiceImpl(StoryRepository repository) {
		this.repository = repository;
	}

	@Override
	public Page<Story> findByCharacter(Character character) {
		StoryQueryParamsBuilder builder = StoryQueryParamsBuilder.getInstance()
				.setCharacter(character);


		return repository.findAll(builder.buildPredicate(), builder.buildPageable());
	}

}
