package ubordeaux.deptinfo.compilation.project.main;

import java.io.FileReader;
import beaver.Scanner;

import ubordeaux.deptinfo.compilation.project.node.Node;

public class Main {
	private static boolean checksType;

	public static void main(String[] args) throws Exception {
		Node n;
		for (String arg : args) {
			if (arg.charAt(0) == '-') {
				if (arg.equals("-checkType"))
					checksType = true;
			} else {
				Scanner input = new ScannerExpr(new FileReader(arg));
				Parser parser = new Parser();
				try {
					System.err.println("*** Fichier " + arg);
					Node result = (Node) parser.parse(input);

					// permet de transformer une chaine de la forme:
					// chemin/vers/le/fichier.lea
					// en :
					// fichier.dot
					result.toDot(arg.substring(arg.lastIndexOf('/') + 1).replaceAll(".lea", ".dot"));

					System.err.println("*** Analyse syntaxique ok");
					if (checksType) {
						if (!result.checksType())
							System.err.println("*** Erreur de typage");
						else
							System.err.println("*** Typage correct");
					}
				} catch (beaver.Parser.Exception e) {
					System.err.println("*** Erreur de syntaxe: " + arg + ":" + e.getMessage());
				}
			}

		}
	}
}
