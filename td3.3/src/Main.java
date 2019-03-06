import java.io.*;

import beaver.Scanner;
import beaver.Parser;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new ScannerAb(new FileReader("data/input"));
		Parser parser = new ParserAb();
		parser.parse(input);
	}
}