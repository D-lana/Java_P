package school21.spring.repositories;

import java.util.Locale;

public class PreProcessorToUpperImpl implements PreProcessor {

	@Override
	public String chooseLetterCase(String message) {
		message = message.toUpperCase(Locale.ROOT);
		return (message);
	}
}