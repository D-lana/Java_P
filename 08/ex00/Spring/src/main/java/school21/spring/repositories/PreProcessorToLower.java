package school21.spring.repositories;

import java.util.Locale;

public class PreProcessorToLower implements PreProcessor {
	
	@Override
	public String chooseLetterCase(String message) {
		message = message.toLowerCase(Locale.ROOT);
		return (message);
	}
}