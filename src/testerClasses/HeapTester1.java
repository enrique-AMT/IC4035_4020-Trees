package testerClasses;

import heap.Heap;

public class HeapTester1 {

	public static void main(String[] args) {

		Heap<Integer> h = new Heap<>(new IntegerComparator1()); 
		add(h, 20);
		removeMin(h); 
		add(h, 10);
		add(h, 22);
		add(h, 7);
		add(h, 13);
		add(h, 23);
		add(h, 100);
		add(h, 9); 
		add(h, 0);
		add(h, 4);
		add(h, 8);
		add(h, 3);
		removeMin(h); 
 
	}

	private static void add(Heap t, Integer e) { 
		System.out.println("\nHeap content after adding element " + e); 
		t.add(e); 
		t.display(); 
	}
	
	private static void removeMin(Heap t) { 
		System.out.println("\nHeap content after removing element " + t.removeMin()); 
		t.display(); 
	}

	
}
