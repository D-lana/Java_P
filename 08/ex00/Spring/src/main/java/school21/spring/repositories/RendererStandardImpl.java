package school21.spring.repositories;

public class RendererStandardImpl implements Renderer {

	private final PreProcessor letterCase;

	public RendererStandardImpl(PreProcessor letterCase) {
		this. letterCase = letterCase;
	}

	@Override
	public void chooseConsoleFd(String message) {
		System.out.println(letterCase.chooseLetterCase(message));
	}
}