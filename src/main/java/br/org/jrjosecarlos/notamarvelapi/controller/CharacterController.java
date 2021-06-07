/**
 *
 */
package br.org.jrjosecarlos.notamarvelapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.jrjosecarlos.notamarvelapi.model.Character;
import br.org.jrjosecarlos.notamarvelapi.model.Comic;
import br.org.jrjosecarlos.notamarvelapi.model.Creator;
import br.org.jrjosecarlos.notamarvelapi.model.Event;
import br.org.jrjosecarlos.notamarvelapi.model.Series;
import br.org.jrjosecarlos.notamarvelapi.model.Story;
import br.org.jrjosecarlos.notamarvelapi.repository.CharacterRepository;
import br.org.jrjosecarlos.notamarvelapi.repository.ComicRepository;
import br.org.jrjosecarlos.notamarvelapi.repository.CreatorRepository;
import br.org.jrjosecarlos.notamarvelapi.repository.EventRepository;
import br.org.jrjosecarlos.notamarvelapi.repository.SeriesRepository;
import br.org.jrjosecarlos.notamarvelapi.repository.StoryRepository;

/**
 * Main controller for {@link Character}-related operations.
 *
 * @author jrjosecarlos
 */
@RestController
public class CharacterController {

	private final CharacterRepository repository;

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

	CharacterController(CharacterRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/characters")
	ResponseEntity<List<Character>> listAllCharacters() {
		return ResponseEntity.ok(repository.findAll());
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
