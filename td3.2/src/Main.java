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

/*
Question 1.a)
	Si il y a un chemin de longueur supérieur à n, alors il y a présence d'une boucle dans
	l'automate, et si il y a une boucle on va forcément passer au moins 2 fois par le même état.
	On ne peut pas construire d'automate fini pour {a^n b^n}.

Question 1.b)
	Supposons que L soit un langage rationnel pour a^n b^n,on peut donc l'utiliser pour a^n+1 b^n+1
	Mais vu qu'il s'agit d'un automate à n états, alors avec n+1 on va forcément boucler quelque part
	ce qui ne nous empêche de déterminer si il y a autant de a que de b --> donc on ne reconnait pas les mots
	de l'automate.

	On sait que y appartient à {a + b}+ et donc que ça ne peut être le mot vide,
	on sait aussi que pour tout entier i > 0,

	Contradiction = autant de a que de b, mais un mot de longueur impair.
*/
