package uk.ac.cardiff.model.event.jpa;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Convert any and all {@link List} of {@link String}s of any registered entity
 * to a single pipe ('|') Delimited string.
 * 
 * @author philsmart
 *
 */
@Converter(autoApply = true)
public class StringListToStringConverter implements AttributeConverter<List<String>, String> {

	public String convertToDatabaseColumn(final List<String> attribute) {
		if (attribute == null || attribute.isEmpty()) {
			return null;
		}
		return attribute.stream().collect(Collectors.joining("|"));
	}

	public List<String> convertToEntityAttribute(final String dbData) {
		if (dbData == null) {
			return null;
		}
		final String[] split = dbData.split("\\|");
		return Arrays.asList(split);
	}

}
