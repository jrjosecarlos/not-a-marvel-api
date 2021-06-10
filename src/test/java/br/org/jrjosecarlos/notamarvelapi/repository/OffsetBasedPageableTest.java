package br.org.jrjosecarlos.notamarvelapi.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.Objects;
import java.util.Random;

import org.junit.Test;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

/**
 * Test class for {@link OffsetBasedPageable}.
 *
 * @author jrjosecarlos
 */
public class OffsetBasedPageableTest {

	@Test
	public void testOffsetBasedPageableOffsetLimitConstructor() {
		OffsetBasedPageable pageable = new OffsetBasedPageable(0, 1);

		assertThat(pageable.getOffset())
			.isEqualTo(0);
		assertThat(pageable.getPageSize())
			.isEqualTo(1);
		assertThat(pageable.getSort())
			.isEqualTo(Sort.unsorted());
	}

	@Test
	public void testOffsetBasedPageableOffsetLimitSortConstructor() {
		OffsetBasedPageable pageable = new OffsetBasedPageable(0, 1, Sort.by(Order.asc("id")));

		assertThat(pageable.getOffset())
			.isEqualTo(0);
		assertThat(pageable.getPageSize())
			.isEqualTo(1);
		assertThat(pageable.getSort())
			.isEqualTo(Sort.by(Order.asc("id")));
	}

	@Test
	public void testOffsetBasedPageableOffsetLimitSortConstructorInvalidOffset() {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> new OffsetBasedPageable(-3, 1, Sort.by(Order.asc("id"))))
			.withMessageContaining("must not be less than zero");
	}

	@Test
	public void testOffsetBasedPageableOffsetLimitSortConstructorInvalidLimit() {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> new OffsetBasedPageable(0, -5, Sort.by(Order.asc("id"))))
			.withMessageContaining("must not be less than one");
	}

	@Test
	public void testGetPageNumber() {
		Random random = new Random(System.currentTimeMillis());

		for (int i = 0; i < Math.abs(random.nextInt(1000)); i++) {
			int offset = Math.abs(random.nextInt());
			int limit = Math.abs(random.nextInt()) + 1;
			OffsetBasedPageable pageable = new OffsetBasedPageable(offset, limit);

			assertThat(pageable.getPageNumber())
				.isEqualTo((int) offset / limit);
		}
	}

	@Test
	public void testNext() {
		OffsetBasedPageable current = new OffsetBasedPageable(1, 5, Sort.by("id"));

		Pageable next = current.next();

		assertThat(next.getOffset())
			.isEqualTo(6);
		assertThat(next.getPageSize())
			.isEqualTo(current.getPageSize());
		assertThat(next.getPageNumber())
			.isEqualTo(current.getPageNumber() + 1);
		assertThat(next.previousOrFirst())
			.isEqualTo(current);
		assertThat(next.getSort())
			.isEqualTo(Sort.by("id"));
	}

	@Test
	public void testPreviousHasPrevious() {
		OffsetBasedPageable current = new OffsetBasedPageable(7, 3);

		OffsetBasedPageable previous = current.previous();

		assertThat(current.hasPrevious())
			.isTrue();
		assertThat(current.previousOrFirst())
			.isEqualTo(previous);
		assertThat(previous.getOffset())
			.isEqualTo(4);
		assertThat(previous.getPageNumber())
			.isEqualTo(current.getPageNumber() - 1);
		assertThat(previous.getSort())
			.isEqualTo(current.getSort());
	}

	@Test
	public void testPreviousDoesntHavePrevious() {
		OffsetBasedPageable current = new OffsetBasedPageable(1, 3);

		OffsetBasedPageable previous = current.previous();

		assertThat(current.hasPrevious())
			.isFalse();
		assertThat(previous)
			.isEqualTo(current);
		assertThat(current.previousOrFirst())
			.isEqualTo(current);
	}

	@Test
	public void testPreviousOrFirstHasPrevious() {
		OffsetBasedPageable current = new OffsetBasedPageable(7, 3);

		Pageable previous = current.previousOrFirst();

		assertThat(current.hasPrevious())
			.isTrue();
		assertThat(current.previous())
			.isEqualTo(previous);
		assertThat(previous.getOffset())
			.isEqualTo(4);
		assertThat(previous.getPageNumber())
			.isEqualTo(current.getPageNumber() - 1);
		assertThat(previous.getSort())
			.isEqualTo(current.getSort());
	}

	@Test
	public void testPreviousOrFirstDoesntHavePrevious() {
		OffsetBasedPageable current = new OffsetBasedPageable(1, 3);

		Pageable previous = current.previousOrFirst();

		assertThat(current.hasPrevious())
			.isFalse();
		assertThat(previous)
			.isEqualTo(current);
		assertThat(current.previous())
			.isEqualTo(current);
	}

	@Test
	public void testFirst() {
		OffsetBasedPageable current = new OffsetBasedPageable(7, 3);

		Pageable first = current.first();

		assertThat(first.getOffset())
			.isEqualTo(1);
		assertThat(first.getPageNumber())
			.isEqualTo(0);
		assertThat(first.getSort())
			.isEqualTo(current.getSort());
	}

	@Test
	public void testHasPreviousTrue() {
		OffsetBasedPageable pageable = new OffsetBasedPageable(8, 3);

		assertThat(pageable.hasPrevious())
			.isTrue();
	}

	@Test
	public void testHasPreviousFalse() {
		OffsetBasedPageable pageable = new OffsetBasedPageable(2, 3);

		assertThat(pageable.hasPrevious())
			.isFalse();
	}

	@Test
	public void testWithPage() {
		OffsetBasedPageable pageable = new OffsetBasedPageable(2, 3);

		Pageable page2 = pageable.withPage(2);

		assertThat(page2.getOffset())
			.isEqualTo(8);
		assertThat(page2.getPageNumber())
			.isEqualTo(2);
	}

	@Test
	public void testEqualsSameObject() {
		OffsetBasedPageable pageable = new OffsetBasedPageable(0, 1);

		assertThat(pageable.equals(pageable)).isTrue();
	}

	@Test
	public void testEqualsNull() {
		OffsetBasedPageable pageable = new OffsetBasedPageable(0, 1);

		assertThat(pageable.equals(null)).isFalse();
	}

	@Test
	public void testEqualsDifferentClass() {
		OffsetBasedPageable pageable = new OffsetBasedPageable(0, 1);

		assertThat(pageable.equals(new Object())).isFalse();
	}

	@Test
	public void testEqualsDifferentLimit() {
		OffsetBasedPageable pageable = new OffsetBasedPageable(0, 1);
		OffsetBasedPageable other = new OffsetBasedPageable(0, 2);

		assertThat(pageable.equals(other)).isFalse();
	}

	@Test
	public void testEqualsDifferentOffset() {
		OffsetBasedPageable pageable = new OffsetBasedPageable(0, 5);
		OffsetBasedPageable other = new OffsetBasedPageable(1, 5);

		assertThat(pageable.equals(other)).isFalse();
	}

	@Test
	public void testEqualsDifferentSort() {
		OffsetBasedPageable pageable = new OffsetBasedPageable(0, 5, Sort.by("id"));
		OffsetBasedPageable other = new OffsetBasedPageable(0, 5, Sort.by("name"));

		assertThat(pageable.equals(other)).isFalse();
	}

	@Test
	public void testHashCode() {
		OffsetBasedPageable pageable = new OffsetBasedPageable(0L, 5, Sort.by("id"));

		assertThat(pageable.hashCode())
			.isEqualTo(Objects.hash(0L, 5, Sort.by("id")));
	}
}
