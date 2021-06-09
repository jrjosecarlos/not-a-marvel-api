/**
 *
 */
package br.org.jrjosecarlos.notamarvelapi.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.jrjosecarlos.notamarvelapi.controller.dto.CharacterDTO;
import br.org.jrjosecarlos.notamarvelapi.controller.filters.CharacterFilter;
import br.org.jrjosecarlos.notamarvelapi.controller.filters.PagingOptions;
import br.org.jrjosecarlos.notamarvelapi.model.Character;
import br.org.jrjosecarlos.notamarvelapi.model.Comic;
import br.org.jrjosecarlos.notamarvelapi.model.Creator;
import br.org.jrjosecarlos.notamarvelapi.model.Event;
import br.org.jrjosecarlos.notamarvelapi.model.Series;
import br.org.jrjosecarlos.notamarvelapi.model.Story;
import br.org.jrjosecarlos.notamarvelapi.repository.ComicRepository;
import br.org.jrjosecarlos.notamarvelapi.repository.CreatorRepository;
import br.org.jrjosecarlos.notamarvelapi.repository.EventRepository;
import br.org.jrjosecarlos.notamarvelapi.repository.SeriesRepository;
import br.org.jrjosecarlos.notamarvelapi.repository.StoryRepository;
import br.org.jrjosecarlos.notamarvelapi.service.CharacterService;

/**
 * Main controller for {@link Character}-related operations.
 *
 * @author jrjosecarlos
 */
@RestController
public class CharacterController {

	private final CharacterService service;

	@Autowired
	private CreatorRepository creatorRepository;

	@Autowired
	private StoryRepository storyRepository;

	@Autowired
	private SeriesRepository seriesRepository;

	@Autowired
	private ComicRepository comicRepository;

	@Autowired
	private EventRepository eventRepository;

	CharacterController(CharacterService service) {
		this.service = service;
	}

	@GetMapping("/public/characters")
	ResponseEntity<List<CharacterDTO>> listAllCharacters(@Valid PagingOptions paging, @Valid CharacterFilter filters) {
		return ResponseEntity.ok(StreamSupport.stream(service.findAll(filters).spliterator(), false)
				.map(CharacterDTO::of)
				.collect(Collectors.toList())
			);
	}

	@GetMapping("/creators")
	ResponseEntity<List<Creator>> listAllCreators() {
		return ResponseEntity.ok(creatorRepository.findAll());
	}

	@GetMapping("/stories")
	ResponseEntity<List<Story>> listAllStories() {
		return ResponseEntity.ok(storyRepository.findAll());
	}

	@GetMapping("/series")
	ResponseEntity<List<Series>> listAllSeries() {
		return ResponseEntity.ok(seriesRepository.findAll());
	}

	@GetMapping("/comics")
	ResponseEntity<List<Comic>> listAllComics() {
		return ResponseEntity.ok(comicRepository.findAll());
	}

	@GetMapping("/events")
	ResponseEntity<List<Event>> listAllEvents() {
		return ResponseEntity.ok(eventRepository.findAll());
	}
}
