package school21.spring.repositories;

public class PrinterWithPrefixImpl implements Printer {
	private final Renderer fd;
	private String prefix = "Prefix";

	public PrinterWithPrefixImpl(Renderer fd) {
		this.fd = fd;
	}

	@Override
	public void print(String message) {
		fd.chooseConsoleFd(prefix + " " + message);
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
}