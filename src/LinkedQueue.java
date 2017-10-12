
public class LinkedQueue<E> {

	private Node<E> head;
	private int size;

	public LinkedQueue() {
		head = null;
		size = 0;
	}

	public void enqueue(E item) {
		if (isEmpty()) {
			head = new Node<E>(item, null);
		} else {
			Node<E> temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = new Node<E>(item, null);
		}
		size++;
	}

	public E dequeue() {
		if (isEmpty()) {
			throw new NullPointerException();
		} else {
			E itemRemoved = head.data;
			head = head.next;
			size--;
			return itemRemoved;
		}
	}

	public E peek() {
		if (isEmpty()) {
			throw new NullPointerException();
		} else {
			return head.data;
		}
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public String toString() {
		if (!isEmpty()) {
			StringBuilder msg = new StringBuilder();
			Node<E> temp = head;
			do {
				msg.append(temp.data);
				temp = temp.next;
			} while (temp != null);
			return msg.toString();	
		} else {
			return "empty";
		}
	}

	public class Node<E> {
		private Node<E> next;
		private E data;

		public Node(E data, Node<E> next) {
			this.data = data;
			this.next = next;
		}
	}
}
