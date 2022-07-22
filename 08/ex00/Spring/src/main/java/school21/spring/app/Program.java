package school21.spring.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import school21.spring.repositories.*;

public class Program {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");

		Printer printer = context.getBean("printPrefixErrUp", Printer.class);
		printer.print("Hello!");
		Printer printer1 = context.getBean("printDataStandardUp", Printer.class);
		printer1.print("Time is");
		Printer printer2 = context.getBean("printPrefixStandardLow", Printer.class);
		printer2.print("tra ta ta!");
		Printer printer3 = context.getBean("printDataErrLow", Printer.class);
		printer3.print("Time is");
	}
}