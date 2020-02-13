import abstractTree.AbstTree;
import abstractTree.AbstTreeInt;
import abstractTree.Environment;
import abstractTree.EnvironmentInt;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;

public class Main {

    public static void main(String[] args) throws Exception {
        ScannerExpr input = new ScannerExpr(new FileReader(args[0]));
        ParserExpr parser = new ParserExpr();

        // TODO: Il serait intéressant de gérer différents types d'exceptions qui pourrait être levé lors du "parsage"
        try {
            // Le "%goal" du parser doit être un objet de type AbstTreeInt
            AbstTreeInt expr = (AbstTree) parser.parse(input);

            // On doit pouvoir l'afficher
            System.out.println(expr.toString());

            //  Il doit pouvoir s'évaluer avec un ensvironnement
            EnvironmentInt environment = new Environment();
            expr.eval(environment);
            System.out.println("Résultat: " + expr.getValue());
        } catch (Exception e) {
            System.out.println("EXCEPTION ATTRAPÉE ! ");
            e.printStackTrace();
        }
    }
}
