import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class HashSet<K, V> {

	private int currentSize;
	private int capacity;
	private double loadFactor;
	private Map<K, V>[] array;

	public HashSet() {
		currentSize = 0;
		capacity = 16;
		loadFactor = 0.75;
		array = new Map[capacity];
	}

	public int getIndex(Object o) {
		return o.hashCode() % array.length;
	}

	public boolean contains(K key) {
		if (isEmpty()) {
			throw new NoSuchElementException();
		} else {
			int index = getIndex(key);
			while (!array[index].key.equals(key)) {
				index = (index + 1) % array.length;
				if (array[index].key.equals(key)) {
					return true;
				}
			}
			return false;

		}
	}

	// returns a boolean explaining whether or not value was added
	public boolean put(V value) {
		if (currentSize == capacity * loadFactor) {
			Map<K, V>[] temp = new Map[capacity * 2];
			for (int i = 0; i < array.length; i++) {
				temp[i] = array[i];
			}
			array = temp;
		}
		int index = getIndex(value);
		// if key is unoccupied, place
		if (array[index] == null) {
			currentSize++;
			array[index] = new Map(index, value);
			return true;
		}
		// if key is occupied
		else {
			while (array[index] == null || !array[index].key.equals(index)) {
				index = (index + 1) % array.length;
			}
			if (array[index].key.equals(index)) {
				return false; // no duplicates!
			}
			currentSize++;
			array[index] = new Map(index, value);
			return true;
		}
	}

	public boolean remove(K key) {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		int index = getIndex(key);
		while (array[index] == null || !array[index].key.equals(key)) {
			index = (index + 1) % array.length;
		}
		if (array[index].key.equals(key)) {
			currentSize--;
			array[index] = null;
			return true;
		} else {
			return false;
		}
	}

	public int size() {
		return currentSize;
	}

	public boolean isEmpty() {
		return currentSize == 0;
	}

	public String toString() {
		if (isEmpty()) {
			return "Empty set";
		}
		StringBuilder msg = new StringBuilder();
		for (int i = 0; i < array.length; i++) {
			if (array[i] == null) {
				msg.append("[" + i + "]: " + "null\n");
			} else {
				msg.append("[" + i + "]: " + array[i].key + ", " + array[i].value + "\n");
			}
		}
		return msg + "\n" + size();
	}

	public class Map<K, V> {
		private K key;
		private V value;

		public Map(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}
}
