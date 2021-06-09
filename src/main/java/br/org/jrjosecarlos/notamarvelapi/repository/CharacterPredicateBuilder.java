package br.org.jrjosecarlos.notamarvelapi.repository;

import java.time.OffsetDateTime;

import org.springframework.data.domain.Pageable;

import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;

import br.org.jrjosecarlos.notamarvelapi.controller.filters.CharacterFilter;
import br.org.jrjosecarlos.notamarvelapi.controller.filters.PagingOptions;
import br.org.jrjosecarlos.notamarvelapi.model.Character;
import br.org.jrjosecarlos.notamarvelapi.model.QCharacter;

/**
 * A {@link Predicate} builder for {@link Character} queries.
 *
 * @author jrjosecarlos
 */
public class CharacterPredicateBuilder {

	private long offset;

	private int limit;

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

	/**
	 * Sets a new value for limit.
	 *
	 * @param limit the new value for limit.
	 * @return this object, for chained calls
	 */
	public CharacterPredicateBuilder setLimit(int limit) {
		this.limit = limit;
		return this;
	}

	/**
	 * Sets a new value for offset.
	 *
	 * @param offset the new value for offset.
	 * @return this object, for chained calls
	 */
	public CharacterPredicateBuilder setOffset(long offset) {
		this.offset = offset;
		return this;
	}

	/**
	 * Constructs a new Builder with data from {@link PagingOptions} and {@link CharacterFilter}.
	 *
	 * @param pagingOptions base for this Builder
	 * @param filter base for this Builder
	 * @return a new Builder
	 */
	public static CharacterPredicateBuilder of(PagingOptions pagingOptions, CharacterFilter filter) {
		return new CharacterPredicateBuilder()
				.setName(filter.getName())
				.setNameStartsWith(filter.getNameStartsWith())
				.setModifiedSince(filter.getModifiedSince())
				.setLimit(pagingOptions.getLimit())
				.setOffset(pagingOptions.getOffset());
	}

	/**
	 * Builds a {@link Predicate} based on this builder data.
	 *
	 * @return a new Predicate
	 */
	public Predicate buildPredicate() {
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

	/**
	 * Builds a {@link Pageable} based on this builder data.
	 *
	 * @return a new Pageable
	 */
	public Pageable buildPageable() {
		return new OffsetBasedPageable(offset, limit);
	}
}
