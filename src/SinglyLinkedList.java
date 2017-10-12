
public class SinglyLinkedList<E> {

	private Node<E> head;
	private int size;

	public SinglyLinkedList() {
		head = null;
		size = 0;
	}

	public void addToFront(E item) {
		Node<E> temp = new Node<E>(item, head);
		head = temp;
		size++;
	}

	public void addToEnd(E item) {
		if (isEmpty()) {
			head = new Node<E>(item, null);
		} else {
			Node<E> temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = new Node<E>(item, head);
		}
		size++;
	}

	public E removeFromFront() {
		if (isEmpty()) {
			throw new NullPointerException();
		} else {
			E itemRemoved = head.data;
			head = head.next;
			size--;
			return itemRemoved;
		}
	}

	public E removeFromEnd() {
		E itemRemoved;
		if (isEmpty()) {
			throw new NullPointerException();
		} else if (size == 1) {
			itemRemoved = head.data;
			head = null;
		} else {
			Node<E> temp = head;
			while (temp.next.next != null) {
				temp = temp.next;
			}
			itemRemoved = temp.next.data;
			temp.next = null;
		}
		size--;
		return itemRemoved;
	}

	public boolean contains(E item) {
		if (isEmpty()) {
			throw new NullPointerException();
		} else {
			Node<E> temp = head;
			do {
				if (temp.data.equals(item)) {
					return true;
				}
				temp = temp.next;
			} while (temp != null);
			return false;
		}
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public String toString() {
		StringBuilder msg = new StringBuilder();
		if (!isEmpty()) {
			Node<E> temp = head;
			do {
				msg.append(temp.data + " ");
				temp = temp.next;
			} while (temp != null);
			return msg + "\nsize: " + size;
		} else {
			return "empty list";
		}
	}

	public class Node<E> {
		private E data;
		private Node<E> next;

		public Node(E data, Node<E> next) {
			this.data = data;
			this.next = next;
		}
	}

}
