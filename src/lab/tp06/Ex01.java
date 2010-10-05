package lab.tp06;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class Ex01<K, V> implements SimpleMap<K, V> {
	
	public static final int DEF_INITIAL_DIRECTORY_SIZE = 4;
	public static final int DEF_BUCKET_SIZE = 3;

	List<Bucket<K, V>> directory;

	static class Bucket<K, V> {
		List<Entry<K, V>> entries;
		
		public Bucket(){
			this(DEF_BUCKET_SIZE);
		}
		
		public Bucket(int initialCapacity) {
			if (initialCapacity < 0)
				throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
			this.entries = new ArrayList<Entry<K, V>>(initialCapacity);
		}
	}

	static class Entry<K, V> {
		public K key;
		public V value;

		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}
	
	public Ex01(){
		this(DEF_INITIAL_DIRECTORY_SIZE);
	}

	public Ex01(int initialCapacity) {
		if (initialCapacity < 0)
			throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
		this.directory = new ArrayList<Bucket<K, V>>(initialCapacity);
	}

	@Override
	public void put(K key, V value) {
		Entry e = new Entry(key, value);
		// TODO Auto-generated method stub

	}

	@Override
	public V get(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(K key) {
		// TODO Auto-generated method stub

	}

	@Override
	public Set<K> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<V> values() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

}
