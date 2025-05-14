package br.com.sulimann.adapters;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LocalDateAdapter extends TypeAdapter<LocalDate> {

	public static final String YYYY_MM_DD = "yyyy-MM-dd";

	private String formato;

	@Override
	public LocalDate read(final JsonReader jsonReader) throws IOException {
		if (jsonReader.peek() == JsonToken.NULL) {
			jsonReader.nextNull();
			return null;
		}

		if (this.formato != null) {
			return LocalDate.parse(jsonReader.nextString(), DateTimeFormatter.ofPattern(this.formato));
		}

		return LocalDate.parse(jsonReader.nextString());
	}

	@Override
	public void write(final JsonWriter jsonWriter, final LocalDate localDate) throws IOException {
	}

}
