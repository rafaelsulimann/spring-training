package br.com.sulimann.adapters;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import lombok.Builder;

@Builder
public class LocalDateTimeAdapter extends TypeAdapter<LocalDateTime> {

	public static final String YYYY_MM_DD_T_HH_MM_SS = "yyyy-MM-dd'T'HH:mm:ss";

	public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

	private String formato;

	@Override
	public LocalDateTime read(final JsonReader jsonReader) throws IOException {
		if (jsonReader.peek() == JsonToken.NULL) {
			jsonReader.nextNull();
			return null;
		}

		return LocalDateTime.parse(jsonReader.nextString(), DateTimeFormatter.ofPattern(this.formato));
	}

	@Override
	public void write(final JsonWriter jsonWriter, final LocalDateTime localDate) throws IOException {
	}

}
