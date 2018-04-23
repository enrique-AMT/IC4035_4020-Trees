package testerClasses;

import labUtils.Utils;
import treeClasses.LinkedBinaryTree;
import treeClasses.LinkedTree;
import treeInterfaces.Position;

public class TreeTester8 {

	public static void main(String[] args) throws CloneNotSupportedException { 
		LinkedBinaryTree<Integer> t = Utils.buildExampleTreeAsLinkedBinaryTree(); 

		// display content as a tree
		Utils.displayTree("Tree t: ", t);
		
		LinkedBinaryTree<Integer> t2 = t.clone();
		// display elements as a list
		Utils.displayTree("clone of t: ", t2);
	}

}
