package br.org.jrjosecarlos.notamarvelapi.repository;

import java.time.OffsetDateTime;

import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;

import br.org.jrjosecarlos.notamarvelapi.controller.filters.CharacterFilter;
import br.org.jrjosecarlos.notamarvelapi.model.Character;
import br.org.jrjosecarlos.notamarvelapi.model.QCharacter;

/**
 * A {@link Predicate} builder for {@link Character} queries.
 *
 * @author jrjosecarlos
 */
public class CharacterPredicateBuilder {

	private String name;

	private String nameStartsWith;

	private OffsetDateTime modifiedSince;

	protected CharacterPredicateBuilder() {

	}

	/**
	 * Sets a new value for name.
	 *
	 * @param name the new value for name.
	 * @return this object, for chained calls
	 */
	public CharacterPredicateBuilder setName(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Sets a new value for nameStartsWith.
	 *
	 * @param nameStartsWith the new value for nameStartsWith.
	 * @return this object, for chained calls
	 */
	public CharacterPredicateBuilder setNameStartsWith(String nameStartsWith) {
		this.nameStartsWith = nameStartsWith;
		return this;
	}

	/**
	 * Sets a new value for modifiedSince.
	 *
	 * @param modifiedSince the new value for modifiedSince.
	 * @return this object, for chained calls
	 */
	public CharacterPredicateBuilder setModifiedSince(OffsetDateTime modifiedSince) {
		this.modifiedSince = modifiedSince;
		return this;
	}

	public static CharacterPredicateBuilder of(CharacterFilter filter) {
		return new CharacterPredicateBuilder()
				.setName(filter.getName())
				.setNameStartsWith(filter.getNameStartsWith())
				.setModifiedSince(filter.getModifiedSince());
	}

	/**
	 * Builds a predicate based on this builder data.
	 *
	 * @return a new Predicate
	 */
	public Predicate build() {
		BooleanExpression resultado = Expressions.asBoolean(true).isTrue();

		if (name != null) {
			resultado = resultado.and(QCharacter.character.name.equalsIgnoreCase(name));
		}

		if (nameStartsWith != null) {
			resultado = resultado.and(QCharacter.character.name.startsWithIgnoreCase(nameStartsWith));
		}

		if (modifiedSince != null) {
			resultado = resultado.and(QCharacter.character.modified.goe(modifiedSince));
		}

		return resultado;
	}
}
