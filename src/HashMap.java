import java.util.NoSuchElementException;

public class HashMap<K, V> {

	private double loadFactor;
	private int initialCapacity;
	private int capacity;
	private HashNode<K, V>[] array;

	public HashMap() {
		loadFactor = 0.75;
		initialCapacity = 16;
		capacity = 0;
		array = new HashNode[initialCapacity];
	}

	public int getIndex(K key) {
		return key.hashCode() % array.length;
	}

	public V get(K key) {
		if (isEmpty()) {
			return null;
		}
		int index = getIndex(key);
		if (array[index].key.equals(key)) {
			return array[index].value;
		} else {
			while (array[index] == null || !array[index].key.equals(key)) {
				index = (index + 1) % array.length;
			}
			if (array[index].key.equals(key)) {
				return array[index].value;
			} else {
				// key not found
				throw new NoSuchElementException();
			}
		}
	}

	public V put(K key, V value) {
		if (capacity == (initialCapacity * loadFactor)) {
			initialCapacity *= 2;
			HashNode<K, V>[] temp = new HashNode[initialCapacity];
			for (int i = 0; i < array.length; i++) {
				temp[i] = array[i];
			}
			array = temp;
		}
		capacity++;
		if (array[getIndex(key)] != null) {
			if (array[getIndex(key)].key.equals(key)) {
				array[getIndex(key)] = new HashNode<K, V>(key, value);
				return get(key);
			}
			int index = getIndex(key);
			while (array[index] != null) {
				index = (index + 1) % array.length;
			}
			array[index] = new HashNode<K, V>(key, value);
			return array[index].value;
		} else {
			array[getIndex(key)] = new HashNode<K, V>(key, value);
			return get(key);
		}

	}

	public boolean isEmpty() {
		return capacity == 0;
	}

	public V remove(K key, V value) {
		if (isEmpty()) {
			return null;
		}
		int index = getIndex(key);

		if (array[index] != null && array[index].key.equals(key) && array[index].value.equals(value)) {
			V val = array[index].value;
			array[index] = null;
			capacity--;
			return val;
		} else {
			while (array[index] == null || !array[index].key.equals(key) && !array[index].value.equals(value)) {
				index = (index + 1) % array.length;
			}
			if (array[index].key.equals(key) && array[index].value.equals(value)) {
				V val = array[index].value;
				array[index] = null;
				capacity--;
				return val;
			} else {
				throw new NoSuchElementException();
			}
		}
	}

	public int size() {
		return capacity;
	}

	public String toString() {
		if (isEmpty()) {
			return "Empty Hash Table";
		}
		StringBuilder msg = new StringBuilder();
		for (int i = 0; i < array.length; i++) {
			if (array[i] == null) {
				msg.append("[" + i + "]: null\n");
			} else {
				msg.append("[" + i + "]: " + "key: " + array[i].key + ", value: " + array[i].value + "\n");
			}
		}
		return msg + "size: " + size();
	}

	public class HashNode<K, V> {
		private K key;
		private V value;

		public HashNode(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}
}
