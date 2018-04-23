package testerClasses;

import labUtils.Utils;
import treeClasses.LinkedTree;
import treeInterfaces.Position;

public class TreeTester2 {

	public static void main(String[] args) throws CloneNotSupportedException {
		LinkedTree<String> t = new LinkedTree<>(), 
				              t1 = new LinkedTree<>(); 
		
		// add nodes and data to the tree
		Position<String> p = t.addRoot("ROOT"); 	
		t.addChild(p, "Rosa"); 
		p = t.addChild(p, "Maria"); 
		Position<String> ptd = p;     // saved for future test of remove
		Position<String> p1 = t.addChild(p, "Juana"); 
		p1 = t.addChild(p1, "Lola"); 
		t.addChild(p1, "Pepote"); 
		p1 = t.addChild(p1, "Manolo"); 
		p1=t.addChild(p1, "Eligio"); 
		t.addChild(p1, "Eda"); 
		t.addChild(p1, "Deborah"); 
		p1 = t.addChild(p, "Pergamino"); 
		t.addChild(p, "Bienvenido");
		t.addChild(p1, "Manolin"); 
		t.addChild(p1, "Juaniquillo"); 
		t.addChild(p1, "Andres"); 
		p1 = t.addChild(t.root(), "Mariola");
		p = p1; 
		p1 = t.addChild(p1, "Leslo"); 
		p1 = t.addChild(p1, "Papin"); 
		p1 = t.addChild(p1, "Ana"); 
		t.addChild(p, "Elegancia"); 
		
		Utils.displayTree("Original t", t); 
		
		// make a clone of t
		t1 = t.clone(); 
		Utils.displayTree("Clone of t", t1); 
		
		String removedElement = t.remove(ptd);
		Utils.displayTree("Tree t after removing " + removedElement, t);
		Utils.displayTree("Clone of t", t1); 

	}

}
