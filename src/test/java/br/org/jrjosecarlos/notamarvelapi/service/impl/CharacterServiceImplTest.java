package br.org.jrjosecarlos.notamarvelapi.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collections;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import com.querydsl.core.types.Predicate;

import br.org.jrjosecarlos.notamarvelapi.controller.filters.CharacterFilter;
import br.org.jrjosecarlos.notamarvelapi.controller.filters.PagingOptions;
import br.org.jrjosecarlos.notamarvelapi.model.Character;
import br.org.jrjosecarlos.notamarvelapi.model.Story;
import br.org.jrjosecarlos.notamarvelapi.repository.CharacterRepository;
import br.org.jrjosecarlos.notamarvelapi.service.CharacterService;
import br.org.jrjosecarlos.notamarvelapi.service.StoryService;

/**
 * Test class for {@link CharacterServiceImpl}.
 *
 * @author jrjosecarlos
 */
@RunWith(SpringRunner.class)
public class CharacterServiceImplTest {
	@Autowired
	private CharacterService service;

	@MockBean
	private CharacterRepository repository;

	@MockBean
	private StoryService storyService;

	@TestConfiguration
	static class CharacterServiceImplTestContextConfiguration {
		@Bean
		public CharacterService characterService() {
			return new CharacterServiceImpl();
		}
	}

	@Test
	public void testFindAllNoData() {
		Page<Character> page = new PageImpl<Character>(Collections.emptyList());

		when(repository.findAll(any(Predicate.class), any(Pageable.class)))
			.thenReturn(page);
		when(storyService.findByCharacter(any(Character.class)))
			.thenReturn(Page.empty());

		Page<Character> returnedPage = service.findAll(new PagingOptions(), new CharacterFilter());

		assertThat(returnedPage)
			.isEqualTo(page);
	}

	@Test
	public void findAllWithCharacterAndStory() {
		Character character = new Character();
		character.setId(UUID.randomUUID());

		Story story = new Story();
		story.setId(UUID.randomUUID());

		Page<Character> characterPage = new PageImpl<>(Arrays.asList(character));
		Page<Story> storyPage = new PageImpl<>(Arrays.asList(story));

		when(repository.findAll(any(Predicate.class), any(Pageable.class)))
			.thenReturn(characterPage);
		when(storyService.findByCharacter(any(Character.class)))
			.thenReturn(storyPage);

		Page<Character> returnedPage = service.findAll(new PagingOptions(), new CharacterFilter());

		assertThat(returnedPage.getContent())
			.hasSize(1)
			.containsOnly(character);

		Character returnedCharacter = returnedPage.getContent().get(0);

		assertThat(returnedCharacter.getStoryPage())
			.isEqualTo(storyPage);
	}
}
