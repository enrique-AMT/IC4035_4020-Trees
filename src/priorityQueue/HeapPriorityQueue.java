package priorityQueue;

import java.util.Comparator;

import heap.Heap;
import priorityQueueInterfaces.Entry;

/**
 * 
 * @author pedroirivera-vega
 *
 * @param <K>
 * @param <V>
 */

public class HeapPriorityQueue<K, V> extends AbstractPriorityQueue<K, V> {
	private Heap<Entry<K, V>> heap; 

	public HeapPriorityQueue(Comparator<K> cmp) {
		heap = new Heap<Entry<K, V>>( new EntryComparator<K, V>(cmp)); 		
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return heap.size();
	}

	@Override
	public Entry<K, V> min() {
		return heap.getMin();
	}

	@Override
	public Entry<K, V> removeMin() {
		// TODO Auto-generated method stub
		return heap.removeMin();
	}

	@Override
	public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
		if (!validate(key)) 
			throw new IllegalArgumentException("Invalid key."); 
		PQEntry<K, V> entry = new PQEntry<K, V>(key, value); 
		heap.add(entry);
		
		return entry;
	}

	
	public void display() { 
		heap.display(); 
	}
	
	private static class EntryComparator<K, V> implements Comparator<Entry<K, V>> {
		private Comparator<K> cmp; 
		public EntryComparator(Comparator<K> cmp) { 
			this.cmp = cmp; 
		}
		
		public int compare(Entry<K, V> e1, Entry<K, V> e2) {
			return cmp.compare(e1.getKey(), e2.getKey());
		} 
		
	}
}
