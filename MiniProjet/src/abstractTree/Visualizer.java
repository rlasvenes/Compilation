package abstractTree;

import abstractTree.AbstTree;
import java.io.FileWriter;
import java.io.File;

public class Visualizer {
    public Visualizer() {

    }

    public static void toDOT(String filename, AbstTree expr) {
        try {
            String str = getDotFile(expr);
            FileWriter fw = new FileWriter(new File(filename));
            fw.write(str);
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getDotFile(AbstTree tree) {
        StringBuilder sb = new StringBuilder();
        sb.append("digraph G {\n");
        sb.append("nodesep=0.3;\n");
        sb.append("ranksep=0.2;\n");
        sb.append("margin=0.1;\n");
        sb.append("node [shape=circle];\n");
        sb.append("edge [arrowsize=0.8];\n");

        StringBuilder treeContent = toDOT(tree, new StringBuilder(), 1);
        sb.append(treeContent);
        sb.append("}");

        return sb.toString();
    }

    public static StringBuilder toDOT(AbstTree node, StringBuilder acc, int i) {
        acc.append(String.format("node%d [label=\"%s\"];\n", i, node.token));
        int lChild = 2*i;
        int rChild = 2*i+1;

        if (node.getLeft()  != null) {
            acc.append(String.format("node%d -> node%d;\n", i, lChild));
            toDOT(node.getLeft(), acc, lChild);
        }

        if (node.getRight() != null) {
            acc.append(String.format("node%d -> node%d;\n", i, rChild));
            toDOT(node.getRight(), acc, rChild);
        }

        return acc;
    }
}
