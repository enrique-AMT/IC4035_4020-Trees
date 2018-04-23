package testerClasses;

import labUtils.Utils;
import treeClasses.LinkedBinaryTree;
import treeClasses.LinkedTree;
import treeInterfaces.Position;

public class ExampleTreeBuilder1 {

	public static void main(String[] args) {
		LinkedTree<Integer> t = Utils.buildExampleTreeAsLinkedTree(); 

		// display content as a tree
		Utils.displayTree("The tree is: ", t); 
	}

}
