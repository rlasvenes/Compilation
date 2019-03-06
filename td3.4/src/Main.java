import java.io.*;

import beaver.Scanner;
import beaver.Parser;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new ScannerLogicProp(new FileReader("data/input"));
		Parser parser = new ParserLogic();
		parser.parse(input);
	}
}
