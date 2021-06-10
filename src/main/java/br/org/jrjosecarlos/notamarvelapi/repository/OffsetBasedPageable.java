package br.org.jrjosecarlos.notamarvelapi.repository;
import java.io.Serializable;
import java.util.Objects;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * Offset-based {@link Pageable} implementation.
 * This implementation is based on the original available on
 * <a href="https://stackoverflow.com/a/36365522">https://stackoverflow.com/a/36365522</a>.
 *
 * @author Ergin
 * @author jrjosecarlos
 */
public class OffsetBasedPageable implements Pageable, Serializable {

	private static final long serialVersionUID = -25822477129613575L;

	private int limit;
	private long offset;
	private final Sort sort;

	/**
	 * Creates a new {@link OffsetBasedPageable} with sort parameters applied.
	 *
	 * @param offset zero-based offset.
	 * @param limit  the size of the elements to be returned.
	 * @param sort   can be {@literal null}.
	 */
	public OffsetBasedPageable(long offset, int limit, Sort sort) {
		if (offset < 0) {
			throw new IllegalArgumentException("Offset index must not be less than zero!");
		}

		if (limit < 1) {
			throw new IllegalArgumentException("Limit must not be less than one!");
		}
		this.limit = limit;
		this.offset = offset;
		this.sort = sort;
	}

	/**
	 * Creates a new {@link OffsetBasedPageable} with sort parameters applied.
	 *
	 * @param offset     zero-based offset.
	 * @param limit      the size of the elements to be returned.
	 * @param direction  the direction of the {@link Sort} to be specified, can be {@literal null}.
	 * @param properties the properties to sort by, must not be {@literal null} or empty.
	 */
	public OffsetBasedPageable(long offset, int limit, Sort.Direction direction, String... properties) {
		this(offset, limit, Sort.by(direction, properties));
	}

	/**
	 * Creates a new {@link OffsetBasedPageable} with sort parameters applied.
	 *
	 * @param offset zero-based offset.
	 * @param limit  the size of the elements to be returned.
	 */
	public OffsetBasedPageable(long offset, int limit) {
		this(offset, limit, Sort.unsorted());
	}

	@Override
	public int getPageNumber() {
		return (int) (offset / limit);
	}

	@Override
	public int getPageSize() {
		return limit;
	}

	@Override
	public long getOffset() {
		return offset;
	}

	@Override
	public Sort getSort() {
		return sort;
	}

	@Override
	public Pageable next() {
		return new OffsetBasedPageable(getOffset() + getPageSize(), getPageSize(), getSort());
	}

	public OffsetBasedPageable previous() {
		return hasPrevious() ? new OffsetBasedPageable(getOffset() - getPageSize(), getPageSize(), getSort()) : this;
	}


	@Override
	public Pageable previousOrFirst() {
		return hasPrevious() ? previous() : this;
	}

	@Override
	public Pageable first() {
		return this.withPage(0);
	}

	@Override
	public boolean hasPrevious() {
		return offset > limit;
	}

	@Override
	public Pageable withPage(int pageNumber) {
		return new OffsetBasedPageable(getFirstOffset(getOffset(), getPageSize()) + (pageNumber * getPageSize()), getPageSize(), getSort());
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;

		if (!(o instanceof OffsetBasedPageable)) return false;

		OffsetBasedPageable that = (OffsetBasedPageable) o;

		return (this.limit == that.limit) && (this.offset == that.offset) &&
				Objects.equals(this.sort, that.sort);
	}

	@Override
	public int hashCode() {
		return Objects.hash(offset, limit, sort);
	}

	/**
	 * Gets the offset for the first page, based on the current offset
	 * and the page size.
	 *
	 * @param currentOffset current offset
	 * @param limit page size
	 * @return offset for the first page
	 */
	private static long getFirstOffset(long currentOffset, int limit) {
		long firstOffset = currentOffset;

		while(firstOffset > limit) {
			firstOffset -= limit;
		}

		return firstOffset;
	}

}