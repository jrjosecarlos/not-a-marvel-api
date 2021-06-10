package br.org.jrjosecarlos.notamarvelapi.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.QSort;

import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;

import br.org.jrjosecarlos.notamarvelapi.model.Character;
import br.org.jrjosecarlos.notamarvelapi.model.QStory;

/**
 *
 * @author jrjosecarlos
 */
public class StoryQueryParamsBuilder {
	private static final OrderSpecifier<String> DEFAULT_ORDER = QStory.story.title.asc();

	private long offset = 0;

	private int limit = 20;

	private Character character;

	protected StoryQueryParamsBuilder() {

	}

	/**
	 * Sets a new value for offset.
	 *
	 * @param offset the new value for offset.
	 * @return this object, for chained calls
	 */
	public StoryQueryParamsBuilder setOffset(long offset) {
		this.offset = offset;
		return this;
	}

	/**
	 * Sets a new value for limit.
	 *
	 * @param limit the new value for limit.
	 * @return this object, for chained calls
	 */
	public StoryQueryParamsBuilder setLimit(int limit) {
		this.limit = limit;
		return this;
	}

	/**
	 * Sets a new value for character.
	 *
	 * @param character the new value for character.
	 * @return this object, for chained calls
	 */
	public StoryQueryParamsBuilder setCharacter(Character character) {
		this.character = character;
		return this;
	}

	public static StoryQueryParamsBuilder getInstance() {
		return new StoryQueryParamsBuilder();
	}

	public Predicate buildPredicate() {
		BooleanExpression expression = Expressions.asBoolean(true).isTrue();

		if (character != null) {
			expression = expression.and(QStory.story.characters.contains(character));
		}

		return expression;
	}

	public Pageable buildPageable() {
		return new OffsetBasedPageable(offset, limit, new QSort(DEFAULT_ORDER));
	}


}
