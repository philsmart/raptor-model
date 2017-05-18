package uk.ac.cardiff.model.event.jpa;

import java.util.Arrays;
import java.util.stream.Collectors;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Convert any and all List<String> of any registered entity to a single pipe
 * Delimited string.
 * 
 * @author philsmart
 *
 */
@Converter(autoApply = true)
public class StringArrayToStringConverter implements AttributeConverter<String[], String> {

	public String convertToDatabaseColumn(final String[] attribute) {
		if (attribute == null || attribute.length == 0) {
			return null;
		}
		return Arrays.asList(attribute).stream().collect(Collectors.joining("|"));
	}

	public String[] convertToEntityAttribute(final String dbData) {
		if (dbData == null) {
			return null;
		}
		final String[] split = dbData.split("\\|");
		return split;
	}

}
