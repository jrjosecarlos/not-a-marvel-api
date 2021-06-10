package br.org.jrjosecarlos.notamarvelapi.repository;

import java.time.OffsetDateTime;
import java.util.UUID;

import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.QSort;

import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;

import br.org.jrjosecarlos.notamarvelapi.controller.filters.CharacterFilter;
import br.org.jrjosecarlos.notamarvelapi.controller.filters.PagingOptions;
import br.org.jrjosecarlos.notamarvelapi.model.Character;
import br.org.jrjosecarlos.notamarvelapi.model.QCharacter;

/**
 * A Builder for params used on {@link Character}-related queries. It builds
 * namely a {@link Predicate}, for adding conditions to a query, and a {@link Pageable},
 * for paging options.
 *
 * @author jrjosecarlos
 */
public class CharacterQueryParamsBuilder {

	private static final OrderSpecifier<UUID> DEFAULT_ORDER = QCharacter.character.id.asc();

	private long offset;

	private int limit;

	private String name;

	private String nameStartsWith;

	private OffsetDateTime modifiedSince;

	protected CharacterQueryParamsBuilder() {

	}

	/**
	 * Sets a new value for name.
	 *
	 * @param name the new value for name.
	 * @return this object, for chained calls
	 */
	public CharacterQueryParamsBuilder setName(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Sets a new value for nameStartsWith.
	 *
	 * @param nameStartsWith the new value for nameStartsWith.
	 * @return this object, for chained calls
	 */
	public CharacterQueryParamsBuilder setNameStartsWith(String nameStartsWith) {
		this.nameStartsWith = nameStartsWith;
		return this;
	}

	/**
	 * Sets a new value for modifiedSince.
	 *
	 * @param modifiedSince the new value for modifiedSince.
	 * @return this object, for chained calls
	 */
	public CharacterQueryParamsBuilder setModifiedSince(OffsetDateTime modifiedSince) {
		this.modifiedSince = modifiedSince;
		return this;
	}

	/**
	 * Sets a new value for limit.
	 *
	 * @param limit the new value for limit.
	 * @return this object, for chained calls
	 */
	public CharacterQueryParamsBuilder setLimit(int limit) {
		this.limit = limit;
		return this;
	}

	/**
	 * Sets a new value for offset.
	 *
	 * @param offset the new value for offset.
	 * @return this object, for chained calls
	 */
	public CharacterQueryParamsBuilder setOffset(long offset) {
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
	public static CharacterQueryParamsBuilder of(PagingOptions pagingOptions, CharacterFilter filter) {
		return new CharacterQueryParamsBuilder()
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
		return new OffsetBasedPageable(offset, limit, new QSort(DEFAULT_ORDER));
	}
}
