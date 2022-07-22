package school21.spring.repositories;

import java.time.LocalDateTime;

public class PrinterWithDateTimeImpl implements Printer {
	private final Renderer fd;

	public PrinterWithDateTimeImpl(Renderer fd) {
		this.fd = fd;
	}

	@Override
	public void print(String message) {
		LocalDateTime dataTime = LocalDateTime.now();
		fd.chooseConsoleFd(message + " " + dataTime);
	}
}