package labUtils;

import treeClasses.LinkedBinaryTree;
import treeClasses.LinkedTree;
import treeInterfaces.Position;
import treeInterfaces.Tree;

public class Utils {
	public static <E> void displayTree(String msg, Tree<E> t) { 
		System.out.println("\n\n" + msg); 
		t.display(); 
	}

	public static <E> void displayTreeElements(String msg, Tree<E> t) {
		System.out.println("\n\n" + msg); 
		for (E element : t)
			System.out.println(element); 
		
	}
	
	public static LinkedTree<Integer> buildExampleTreeAsLinkedTree() { 
		LinkedTree<Integer> t = new LinkedTree<>(); 
	t.addRoot(4);
		
		Position<Integer> leaf1=t.addChild(t.root(), 9);
		t.addChild(leaf1, 7);
		t.addChild(leaf1, 10);
		Position<Integer> leaf2=t.addChild(t.root(), 20);
		Position<Integer> leaf3=t.addChild(leaf2, 15);
		Position<Integer> leaf4=t.addChild(leaf2, 21);
		t.addChild(leaf3, 12);
		Position<Integer> leaf5=t.addChild(leaf3, 17);
		t.addChild(leaf5, 19);
		Position<Integer> leaf6=t.addChild(leaf4, 40);
		t.addChild(leaf6, 30);
		t.addChild(leaf6, 45);
		
		
		return t; 
	}
	
	public static LinkedBinaryTree<Integer> buildExampleTreeAsLinkedBinaryTree() { 
		LinkedBinaryTree<Integer> t = new LinkedBinaryTree<>(); 
t.addRoot(4);
		
		Position<Integer> leaf1=t.addLeft(t.root(), 9);
		t.addLeft(leaf1, 7);
		t.addRight(leaf1, 10);
		Position<Integer> leaf2=t.addRight(t.root(), 20);
		Position<Integer> leaf3=t.addLeft(leaf2, 15);
		Position<Integer> leaf4=t.addRight(leaf2, 21);
		t.addLeft(leaf3, 12);
		Position<Integer> leaf5=t.addRight(leaf3, 17);
		t.addLeft(leaf5, 19);
		Position<Integer> leaf6=t.addRight(leaf4, 40);
		t.addLeft(leaf6, 30);
		t.addRight(leaf6, 45);
		
		return t; 
	}


}
