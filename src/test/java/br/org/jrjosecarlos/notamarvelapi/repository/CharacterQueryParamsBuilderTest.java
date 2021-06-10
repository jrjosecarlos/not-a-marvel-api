package br.org.jrjosecarlos.notamarvelapi.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.Expressions;

import br.org.jrjosecarlos.notamarvelapi.controller.filters.CharacterFilter;
import br.org.jrjosecarlos.notamarvelapi.controller.filters.CharacterFilter.CharacterSortOptions;
import br.org.jrjosecarlos.notamarvelapi.controller.filters.PagingOptions;
import br.org.jrjosecarlos.notamarvelapi.model.QCharacter;

/**
 * Test class for {@link CharacterQueryParamsBuilder}.
 *
 * @author jrjosecarlos
 */
public class CharacterQueryParamsBuilderTest {

	@Test
	public void testCharacterQueryParamsBuilderOfNullPagingOptions() {
		assertThatExceptionOfType(NullPointerException.class)
			.isThrownBy(() -> CharacterQueryParamsBuilder.of(null, new CharacterFilter()));
	}

	@Test
	public void testCharacterQueryParamsBuilderOfNullCharacterFilter() {
		assertThatExceptionOfType(NullPointerException.class)
			.isThrownBy(() -> CharacterQueryParamsBuilder.of(null, new CharacterFilter()));
	}

	@Test
	public void testBuildWithDefaultParams() {
		PagingOptions pagingOptions = new PagingOptions();
		CharacterFilter filter = new CharacterFilter();

		CharacterQueryParamsBuilder builder = CharacterQueryParamsBuilder.of(pagingOptions, filter);

		Pageable pageable = builder.buildPageable();

		assertThat(pageable.getOffset())
			.isEqualTo(0L);
		assertThat(pageable.getPageSize())
			.isEqualTo(20);
		assertThat(pageable.getSort())
			.isEqualTo(Sort.by(Order.asc("id")));

		Predicate predicate = builder.buildPredicate();

		assertThat(predicate)
			.isEqualTo(Expressions.asBoolean(true).isTrue());
	}

	@Test
	public void testBuildWithParamsSet() {
		PagingOptions pagingOptions = new PagingOptions();
		pagingOptions.setOffset(3L);
		pagingOptions.setLimit(15);

		CharacterFilter filter = new CharacterFilter();
		filter.setName("name");
		filter.setNameStartsWith("starts");
		filter.setModifiedSince(OffsetDateTime.of(2021, 01, 01, 3, 15, 14, 0, ZoneOffset.UTC));
		filter.setOrderBy(Arrays.asList(CharacterSortOptions.NAME_ASC, CharacterSortOptions.MODIFIED_DESC));

		CharacterQueryParamsBuilder builder = CharacterQueryParamsBuilder.of(pagingOptions, filter);

		Pageable pageable = builder.buildPageable();

		assertThat(pageable.getOffset())
			.isEqualTo(3L);
		assertThat(pageable.getPageSize())
			.isEqualTo(15);
		assertThat(pageable.getSort())
			.isEqualTo(Sort.by(Order.asc("name"), Order.desc("modified")));

		Predicate predicate = builder.buildPredicate();

		assertThat(predicate)
			.isEqualTo(Expressions.asBoolean(true).isTrue()
					.and(QCharacter.character.name.equalsIgnoreCase("name"))
					.and(QCharacter.character.name.startsWithIgnoreCase("starts"))
					.and(QCharacter.character.modified.goe(OffsetDateTime.of(2021, 01, 01, 3, 15, 14, 0, ZoneOffset.UTC)))
			);
	}

	@Test
	public void testBuildNullOrderByFilter() {
		PagingOptions pagingOptions = new PagingOptions();
		CharacterFilter filter = new CharacterFilter();
		filter.setOrderBy(null);

		CharacterQueryParamsBuilder builder = CharacterQueryParamsBuilder.of(pagingOptions, filter);

		Pageable pageable = builder.buildPageable();

		assertThat(pageable.getSort())
			.isEqualTo(Sort.by(Order.asc("id")));
	}
}
