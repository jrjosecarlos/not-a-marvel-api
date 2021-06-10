package br.org.jrjosecarlos.notamarvelapi.controller.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.org.jrjosecarlos.notamarvelapi.controller.exception.IllegalOrderingParameterException;
import br.org.jrjosecarlos.notamarvelapi.controller.filters.CharacterFilter.CharacterSortOptions;

/**
 * Converts Strings to {@link CharacterSortOptions} enum elements.
 *
 * @author jrjosecarlos
 */
@Component
public class StringToCharacterSortOptionsConverter implements Converter<String, CharacterSortOptions>{

	@Override
	public CharacterSortOptions convert(String source) {
		try {
			return CharacterSortOptions.fromValue(source);
		} catch (IllegalArgumentException e) {
			throw new IllegalOrderingParameterException();
		}
	}

}
