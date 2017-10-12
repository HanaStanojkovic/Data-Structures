
public class Queue<T> {

	private Object[] array;
	private int front, rear, counter;

	public Queue(int size) {
		array = new Object[size];
		front = -1;
		rear = -1;
		counter = 0;
	}

	public void enqueue(T item) {
		if (!isEmpty()) {
			if (counter == array.length) {
				Object[] tempArray = new Object[array.length * 2];
				int temp = front;
				for (int i = 0; i < counter; i++) {
					tempArray[i] = array[temp % array.length];
					temp++;
				}
				array = tempArray;
				front = 0;
				rear = counter;
			}
			rear = (front + counter) % array.length;
			array[rear] = item;
			counter++;
		} else {
			front = ++rear;
			array[counter] = item;
			counter++;
		}
	}

	@SuppressWarnings("unchecked")
	public T dequeue() {
		T result = null;
		if (counter != 0) {
			result = (T) array[front];
			front = (front + 1) % array.length;
			counter--;
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public T front() {
		return (T) array[front];
	}

	public boolean isEmpty() {
		if (front == -1 && rear == -1) {
			return true;
		}
		return false;
	}

	public String toString() {
		StringBuilder msg = new StringBuilder();
		int temp = front;
		for (int i = 0; i < counter; i++) {
			msg.append("[" + array[temp % array.length] + "] ");
			temp++;
		}
		return msg.toString();
	}
}
