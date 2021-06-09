package br.org.jrjosecarlos.notamarvelapi.controller.filters;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import br.org.jrjosecarlos.notamarvelapi.model.Character;

/**
 * Filters to be used on {@link Character}-related searches.
 *
 * @author jrjosecarlos
 */
public class CharacterFilter {

	private PagingFilter pagingFilter = new PagingFilter();

	private String name;

	private String nameStartsWith;

	private OffsetDateTime modifiedSince;

	private List<CharacterSortOptions> orderBy = new ArrayList<>();

	/**
	 * Returns the current value of name.
	 *
	 * @return the current value of name.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Sets a new value for name.
	 *
	 * @param name the new value for name.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the current value of nameStartsWith.
	 *
	 * @return the current value of nameStartsWith.
	 */
	public String getNameStartsWith() {
		return this.nameStartsWith;
	}

	/**
	 * Sets a new value for nameStartsWith.
	 *
	 * @param nameStartsWith the new value for nameStartsWith.
	 */
	public void setNameStartsWith(String nameStartsWith) {
		this.nameStartsWith = nameStartsWith;
	}

	/**
	 * Returns the current value of modifiedSince.
	 *
	 * @return the current value of modifiedSince.
	 */
	public OffsetDateTime getModifiedSince() {
		return this.modifiedSince;
	}

	/**
	 * Sets a new value for modifiedSince.
	 *
	 * @param modifiedSince the new value for modifiedSince.
	 */
	public void setModifiedSince(OffsetDateTime modifiedSince) {
		this.modifiedSince = modifiedSince;
	}

	/**
	 * @return limit
	 * @see br.org.jrjosecarlos.notamarvelapi.controller.filters.PagingFilter#getLimit()
	 */
	public Integer getLimit() {
		return pagingFilter.getLimit();
	}

	/**
	 * @param limit
	 * @see br.org.jrjosecarlos.notamarvelapi.controller.filters.PagingFilter#setLimit(java.lang.Integer)
	 */
	public void setLimit(Integer limit) {
		pagingFilter.setLimit(limit);
	}

	/**
	 * @return offset
	 * @see br.org.jrjosecarlos.notamarvelapi.controller.filters.PagingFilter#getOffset()
	 */
	public Integer getOffset() {
		return pagingFilter.getOffset();
	}

	/**
	 * @param offset
	 * @see br.org.jrjosecarlos.notamarvelapi.controller.filters.PagingFilter#setOffset(java.lang.Integer)
	 */
	public void setOffset(Integer offset) {
		pagingFilter.setOffset(offset);
	}

	/**
	 * Returns the current value of orderBy.
	 *
	 * @return the current value of orderBy.
	 */
	public List<CharacterSortOptions> getOrderBy() {
		return this.orderBy;
	}

	/**
	 * Sets a new value for orderBy.
	 *
	 * @param orderBy the new value for orderBy.
	 */
	public void setOrderBy(List<CharacterSortOptions> orderBy) {
		this.orderBy = orderBy;
	}

	public static enum CharacterSortOptions {
		NAME_ASC("name"),
		MODIFIED_ASC("modified"),
		NAME_DESC("-name"),
		MODIFIED_DESC("-modified");

		private String code;

		private CharacterSortOptions(String code) {
			this.code = code;
		}

		/**
		 * Returns the current value of code.
		 *
		 * @return the current value of code.
		 */
		public String getCode() {
			return this.code;
		}

		public static CharacterSortOptions fromValue(String value) {
			return EnumSet.allOf(CharacterSortOptions.class).stream()
					.filter(e -> e.getCode().equals(value))
					.findAny()
					.orElseThrow(() -> new IllegalArgumentException(String.format("%s is not a valid %s value", value, CharacterSortOptions.class.getSimpleName())));
		}

	}

}
