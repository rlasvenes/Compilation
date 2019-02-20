import java.io.*;

import beaver.Scanner;
import beaver.Parser;

public class MySymbol extends beaver.Symbol {
    private double attr;
    private Integer lineno;
    private Integer columnno;

	public MySymbol(double attr) {
        this.attr = attr;
    }
}
