package priorityQueue;
import java.util.Comparator;

import priorityQueueInterfaces.*; 

/**
 * 
 * @author pedroirivera-vega
 *
 * @param <K>
 * @param <V>
 */

public abstract class AbstractPriorityQueue<K, V> implements PriorityQueue<K, V> {
	protected Comparator<K> cmp; 
	
	private static class DefaultComparator<E> implements Comparator<E> {

		@Override
		public int compare(E o1, E o2) {
			return ((Comparable<E>) o1).compareTo(o2);
		} 
		
	}
	
	protected static class PQEntry<K, V> implements Entry<K, V> {

		private K key; 
		private V value; 
		
		public PQEntry(K key, V value) { 
			this.key = key; 
			this.value = value; 
		}
		
		@Override
		public K getKey() {
			// TODO Auto-generated method stub
			return key;
		}

		@Override
		public V getValue() {
			// TODO Auto-generated method stub
			return value;
		}

		public void setKey(K key) {
			this.key = key;
		}

		public void setValue(V value) {
			this.value = value;
		} 
		
		public String toString() { 
			return "[" + key + ", " + value + "]"; 
		}
	}
	
	protected AbstractPriorityQueue() { 
		cmp = new DefaultComparator<K>(); 
	}

	public boolean isEmpty() { 
		return this.size() == 0; 
	}
	
	protected int compare(Entry<K, V> e1, Entry<K, V> e2) { 
		return cmp.compare(e1.getKey(), e2.getKey());
	}

	protected boolean validate(K key) throws IllegalArgumentException { 
		if (key == null) throw new IllegalArgumentException("Key is null.");
		try { 
			return cmp.compare(key, key)==0; 
		}
		catch (ClassCastException e) { 
			throw new IllegalArgumentException("Key does not match comparator requirements.");
		}
	}
}
