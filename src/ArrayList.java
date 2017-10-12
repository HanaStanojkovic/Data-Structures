import java.util.Arrays;

public class ArrayList<E> {

	private E[] array;
	private int capacity, numberOfElements;

	public ArrayList() {
		numberOfElements = 0;
		capacity = 10;
		array = (E[]) new Object[capacity];
	}

	public void add(E item) {
		if (numberOfElements == capacity) {
			resize();
		}
		array[numberOfElements] = item;
		numberOfElements++;
	}

	private E[] resize() {
		array = Arrays.copyOf(array, array.length * 2);
		return array;
	}

	public E remove(E item) {
		if (isEmpty()) {
			throw new NullPointerException();
		} else {
			for (int i = 0; i < array.length; i++) {
				if (array[i].equals(item)) {
					E itemRemoved = array[i];
					shift(i);
					return itemRemoved;

				}
			}
			return null;
		}
	}

	private E[] shift(int index) {
		for (int j = index; j < numberOfElements; j++) {
			boolean isLast = j == array.length - 1;
			if (isLast) {
				array[j] = null;
			} else {
				array[j] = array[j + 1];
			}
		}
		numberOfElements--;
		return array;
	}

	public boolean contains(E item) {
		if (isEmpty()) {
			throw new NullPointerException();
		} else {
			for (int i = 0; i < array.length; i++) {
				if (array[i].equals(item)) {
					return true;
				}
			}
			return false;
		}
	}

	public boolean isEmpty() {
		return numberOfElements == 0;
	}

	public String toString() {
		if (isEmpty()) {
			return "empty Array";
		} else {
			StringBuilder msg = new StringBuilder();
			for (int i = 0; i < array.length; i++) {
				msg.append("[" + array[i] + "] ");
			}
			return msg.toString() + "\nsize: " + numberOfElements;
		}
	}
}
