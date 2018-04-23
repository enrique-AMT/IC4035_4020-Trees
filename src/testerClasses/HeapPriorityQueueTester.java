package testerClasses;


import priorityQueue.HeapPriorityQueue;

/**
 * 
 * @author pedroirivera-vega
 *
 */

public class HeapPriorityQueueTester {
	
	public static void main(String[] args) {

		HeapPriorityQueue<Integer, String> pq = new HeapPriorityQueue<>(new IntegerComparator1()); 
		add(pq, 20, "twenty");
		removeMin(pq); 
		add(pq, 10, "ten");
		add(pq, 22, "twenty two");
		add(pq, 7, "seven");
		add(pq, 13, "thirteen");
		add(pq, 23, "twenty three");
		add(pq, 100, "hundred");
		add(pq, 9, "nine"); 
		add(pq, 0, "zero");
		add(pq, 4, "four");
		add(pq, 8, "eight");
		add(pq, 3, "three");
		removeMin(pq); 
		removeMin(pq); 
		removeMin(pq); 
 
	}
	
	private static <K, V> void add(HeapPriorityQueue<K, V> pq, K key, V value) { 
		System.out.println("\nPQ content after adding entry: key = " + key 
				+ " and value = " + value); 
		pq.insert(key, value); 
		pq.display(); 
	}
	
	private static <K, V> void removeMin(HeapPriorityQueue<K, V> pq) { 
		System.out.println("\nPQ content after removing element " + pq.removeMin()); 
		pq.display(); 
	}

	

}
