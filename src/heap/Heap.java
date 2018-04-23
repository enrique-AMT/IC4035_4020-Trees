package heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

import treeClasses.AbstractBinaryTree;
import treeClasses.LinkedBinaryTree;
import treeInterfaces.Position;

/**
 * Heap data structure implemented as a subclass of AbstractBinaryTree
 * and using an ArrayList<Position<E>> to store its elements or positions. 
 * 
 * @author pedroirivera-vega
 *
 * @param <E>
 */
public class Heap<E> extends LinkedBinaryTree<E> {

	private ArrayList<HeapPosition<E>> list; 
	private Comparator<E> cmp; 
	
	public Heap(Comparator<E> cmp) { 
		this.cmp = cmp; 
		list = new ArrayList<>(); 
	}
	
	private HeapPosition<E> validate(Position<E> p) throws IllegalArgumentException { 
		if (!(p instanceof HeapPosition<?>))
			throw new IllegalArgumentException("Invalid position - not of type HeapPosition."); 
		HeapPosition<E> hp = (HeapPosition<E>) p; 
		if (hp.getIndex() < 0 || hp.getIndex() >= list.size())
			throw new IllegalArgumentException("Position does not belong to this heap."); 
		return hp; 	
	}
	
	// The following three methods are used to determine the index of the 
	// left child, the right child, and the parent of a node whose index is
	// given (parameter i). Notice that the names of each of these methods
	// are overloaded....... with corresponding methods having parameter of
	// type Position<>.
	private int left(int i) { 
		return 2*i+1; 
	}
	
	private int right(int i) { 
		return 2*i+2; 
	}
	
	private int parent(int i) { 
		return ((i-1)/2);
	}
	///////////////////////////////////////////////////////////////////////
	
	@Override
	public Position<E> left(Position<E> p) throws IllegalArgumentException {
		HeapPosition<E> hp = validate(p); 
		
		int leftIndex = left(hp.getIndex()); 
		
		if (leftIndex < list.size())
			return list.get(leftIndex); 
		
		return null;
	}

	@Override
	public Position<E> right(Position<E> p) throws IllegalArgumentException {
		HeapPosition<E> hp = validate(p); 
		
		int rightIndex = right(hp.getIndex()); 
		
		if (rightIndex < list.size())
			return list.get(rightIndex); 
		
		return null;
	}

	@Override
	public Position<E> root() {
		if (list.isEmpty()) 
			return null; 
		return list.get(0); 
	}

	@Override
	public Position<E> parent(Position<E> p) throws IllegalArgumentException {
		HeapPosition<E> hp = validate(p); 
		
		if (hp.getIndex() == 0) 
			return null;
		
		return list.get(parent(hp.getIndex())); 	
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public Iterator<E> iterator() {
		// this is really a bfs iterator
		ArrayList<E> iterList = new ArrayList<>(); 
		for (Position<E> p : list) 
			iterList.add(p.getElement()); 
		
		return iterList.iterator();

	}

	@Override
	public Iterable<Position<E>> positions() {
		// TODO Auto-generated method stub
		ArrayList<Position<E>> iterList = new ArrayList<>(); 
		for (Position<E> p : list) 
			iterList.add(p); 
		
		return iterList;
	}
	
	public void add(E element) {
		HeapPosition<E> hp = new HeapPosition<>(element, list.size()); 
		list.add(hp); 
		upHeap(hp);
	}
	
	public E getMin() { 
		if (list.isEmpty())
			return null; 
		return list.get(0).getElement(); 
	}
	
	public E removeMin() { 
		if (list.isEmpty())
			return null; 
		
		HeapPosition<E> ptr = list.get(0);
		
		if (list.size() > 1) {
		   list.set(0, list.remove(list.size()-1)); 
		   list.get(0).setIndex(0);
		   downHeap(list.get(0)); 
		}
		else 
			list.remove(0);
		
		return ptr.getElement(); 
	}
	
	
	private void downHeap(HeapPosition<E> r) { 
		if (this.hasLeft(r)) { 
			HeapPosition<E> minChild = (HeapPosition<E>) this.left(r); 
			if (this.hasRight(r)) {
				HeapPosition<E> rChild = (HeapPosition<E>) this.right(r); 
				if (cmp.compare(minChild.getElement(), this.right(r).getElement()) > 0)
					minChild = rChild; 
			}
			if (cmp.compare(minChild.getElement(), r.getElement()) < 0) { 
				swapPositionsInList(r, minChild);   // r is now son of minChild....
				downHeap(r); 
			}
		}
	}

	private void upHeap(HeapPosition<E> p) { 
		if (!this.isRoot(p)) { 
			HeapPosition<E> parent = (HeapPosition<E>) this.parent(p); 
			if (cmp.compare(p.getElement(), parent.getElement()) < 0) { 
				swapPositionsInList(p, parent);    // p is now parent of parent....
				upHeap(p); 
			}
		}
	}
	
	private void swapPositionsInList(HeapPosition<E> r, HeapPosition<E> c) {
		int ir = r.getIndex(); 
		int ic = c.getIndex(); 
		r.setIndex(ic);
		c.setIndex(ir);
		list.set(ir, list.set(ic, r));   // swaps elements at positions ir and ic in list
	}

	// Private class implementing the type of positions being used in this 
	// implementation. 
	private static class HeapPosition<E> implements Position<E> {

		private E element; 
		private int index;   // its position in the array list 
		
		public HeapPosition(E element, int index) { 
			this.element = element; 
			this.index = index; 
		}
		
		@Override
		public E getElement() {
			return element; 
		}

		public int getIndex() {
			return index;
		}

		public void setIndex(int index) {
			this.index = index;
		}

		public void setElement(E element) {
			this.element = element;
		} 
		
	}
}
