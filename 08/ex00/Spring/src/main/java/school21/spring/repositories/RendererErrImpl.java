package school21.spring.repositories;

public class RendererErrImpl implements Renderer {

    private final PreProcessor letterCase;

    public RendererErrImpl(PreProcessor letterCase) {
        this. letterCase = letterCase;
    }

    @Override
    public void chooseConsoleFd(String message) {
        System.err.println(letterCase.chooseLetterCase(message));
	}
}