import java.io.*;

import beaver.Scanner;
import beaver.Parser;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new ScannerExpr(new FileReader("data/input"));
		Parser parser = new ParserExpr();
		parser.parse(input);
	}
}
