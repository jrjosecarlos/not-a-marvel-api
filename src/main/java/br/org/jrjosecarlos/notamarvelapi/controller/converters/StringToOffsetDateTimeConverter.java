package br.org.jrjosecarlos.notamarvelapi.controller.converters;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Parses a String {@code S} to {@link OffsetDateTime}, according to these rules:
 *
 * <ul>
 * <li>If {@code S}'s length is less than or equal to 10, the parse is tried as {@link DateTimeFormatter#ISO_LOCAL_DATE}, and the offset
 * is fixed at {@link ZoneOffset#UTC};</li>
 * <li>If {@code S}'s length is less than or equal to 19, the parse is tried as {@link DateTimeFormatter#ISO_LOCAL_DATE_TIME} (with optional
 * seconds), and the offset is also fixed at {@link ZoneOffset#UTC};</li>
 * <li>If  {@code S}'s length is greater than 19, the parse is tried as {@link DateTimeFormatter#ISO_OFFSET_DATE_TIME}.</li>
 * </ul>
 *
 * @author jrjosecarlos
 */
@Component
public class StringToOffsetDateTimeConverter implements Converter<String, OffsetDateTime> {

	private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE;

	private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm[:ss]");

	@Override
	public OffsetDateTime convert(String source) {
		if (source.length() <= 10) {
			return LocalDateTime.of(LocalDate.parse(source, DATE_FORMATTER), LocalTime.MIDNIGHT)
					.atOffset(ZoneOffset.UTC);
		} else if (source.length() <= 19) {
			return LocalDateTime.parse(source, DATE_TIME_FORMATTER)
					.atOffset(ZoneOffset.UTC);
		} else {
			return OffsetDateTime.parse(source);
		}
	}

}
