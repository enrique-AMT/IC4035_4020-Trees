package testerClasses;

import java.util.ArrayList;

import labUtils.Utils;
import treeClasses.LinkedTree;
import treeInterfaces.Position;

/**
 * Tester class for the MyTree implementation of the Tree
 * @author pedroirivera-vega
 *
 */
public class TreeTester1 {
	public static void main(String[] args) { 
		LinkedTree<String> t = new LinkedTree<>(); 
		
		// add nodes and data to the tree
		Position<String> p = t.addRoot("ROOT"); 	
		t.addChild(p, "Rosa"); 
		p = t.addChild(p, "Maria"); 
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
		
		Utils.displayTree("The tree is: ", t);
		
	}
	
}
