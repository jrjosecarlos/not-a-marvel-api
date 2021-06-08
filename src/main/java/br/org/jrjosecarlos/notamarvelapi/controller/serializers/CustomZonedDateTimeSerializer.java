package br.org.jrjosecarlos.notamarvelapi.controller.serializers;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

/**
 * Custom serializer for {@link ZonedDateTime} instances.
 *
 * @author jrjosecarlos
 */
public class CustomZonedDateTimeSerializer extends StdSerializer<ZonedDateTime> {

	/**
	 * Serial version UID for this class
	 */
	private static final long serialVersionUID = 2482965855226081825L;

	/**
	 * Default format
	 */
	private static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssxx");

	/**
	 * Default constructor
	 */
	public CustomZonedDateTimeSerializer() {
		this(null);
	}

	public CustomZonedDateTimeSerializer(Class<ZonedDateTime> t) {
        super(t);
    }

	@Override
	public void serialize(ZonedDateTime value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		gen.writeString(FORMAT.format(value));
	}
}
