package ubordeaux.deptinfo.compilation.project.environment;

import java.util.HashMap;

import ubordeaux.deptinfo.compilation.project.node.Node;

public interface IntEnvironment {

	public void put(String variable, Node node);

	public Node get(String variable);



}
