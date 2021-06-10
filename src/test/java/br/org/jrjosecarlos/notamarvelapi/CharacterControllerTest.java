package br.org.jrjosecarlos.notamarvelapi;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import br.org.jrjosecarlos.notamarvelapi.controller.CharacterController;
import br.org.jrjosecarlos.notamarvelapi.model.Character;
import br.org.jrjosecarlos.notamarvelapi.model.Story;
import br.org.jrjosecarlos.notamarvelapi.service.CharacterService;

/**
 * Test class for {@link CharacterController}.
 *
 * @author jrjosecarlos
 */
@RunWith(SpringRunner.class)
@WebMvcTest(CharacterController.class)
public class CharacterControllerTest {
	@Autowired
	private MockMvc mvc;

	@MockBean
	private CharacterService service;

	@Test
	public void testListAllCharactersNoData() throws Exception {
		Page<Character> page = Page.empty();

		when(service.findAll(any(), any()))
			.thenReturn(page);

		mvc.perform(get("/public/characters")
				.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.code", is(200)))
			.andExpect(jsonPath("$.data.total", is(0)))
			.andExpect(jsonPath("$.data.results").isArray())
			.andExpect(jsonPath("$.data.results").isEmpty());
	}

	@Test
	public void testListAllCharactersSomeData() throws Exception {
		Character character1 = new Character();
		character1.setId(UUID.randomUUID());
		character1.setName("Character 1");

		Story story1 = new Story();
		story1.setId(UUID.randomUUID());
		story1.setTitle("Story 1 for Character 1");
		story1.setType("testType");

		Character character2 = new Character();
		character2.setId(UUID.randomUUID());
		character2.setName("Character 2");

		character1.setStoryPage(new PageImpl<>(Arrays.asList(story1)));

		Page<Character> charactersPage = new PageImpl<>(Arrays.asList(character1, character2));

		when(service.findAll(any(), any()))
			.thenReturn(charactersPage);

		mvc.perform(get("/public/characters")
				.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.code", is(200)))
			.andExpect(jsonPath("$.data.total", is(2)))
			.andExpect(jsonPath("$.data.results", hasSize(2)))
			.andExpect(jsonPath("$.data.results[0].name", is("Character 1")))
			.andExpect(jsonPath("$.data.results[0].stories.available", is(1)))
			.andExpect(jsonPath("$.data.results[0].stories.items").isArray())
			.andExpect(jsonPath("$.data.results[0].stories.items", hasSize(1)))
			.andExpect(jsonPath("$.data.results[0].stories.items[0].name", is("Story 1 for Character 1")))
			.andExpect(jsonPath("$.data.results[0].stories.items[0].type", is("testType")))
			.andExpect(jsonPath("$.data.results[1].name", is("Character 2")))
			.andExpect(jsonPath("$.data.results[1].stories.available", is(0)))
			.andExpect(jsonPath("$.data.results[1].stories.items", hasSize(0)));
	}

	@Test
	public void testListAllCharactersIllegalOrderBy() throws Exception {
		mvc.perform(get("/public/characters")
				.queryParam("orderBy", "test")
				.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isConflict())
			.andExpect(jsonPath("$.code", is(409)))
			.andExpect(jsonPath("$.status", containsString("Invalid or unrecognized ordering parameter.")));

		verify(service, never()).findAll(any(), any());
	}

	@Test
	public void testListAllCharactersIllegalModified() throws Exception {
		mvc.perform(get("/public/characters")
				.queryParam("modifiedSince", "notADate")
				.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isConflict())
			.andExpect(jsonPath("$.code", is(409)))
			.andExpect(jsonPath("$.status", containsString("Invalid or unrecognized parameter.")));

		verify(service, never()).findAll(any(), any());
	}
}
