
public class DoublyLinkedList<E> {

	private Node<E> head, tail;
	private int size;

	public DoublyLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}

	public void addToFront(E item) {
		if (isEmpty()) {
			head = new Node<E>(item, null, null);
			tail = head;
		} else {
			head.prev = new Node<E>(item, null, head);
			head = head.prev;
		}
		size++;
	}

	public void addToEnd(E item) {
		if (isEmpty()) {
			head = new Node<E>(item, null, null);
			tail = head;
		} else {
			tail.next = new Node<E>(item, tail, null);
			tail = tail.next;
		}
		size++;
	}

	public E removeFromFront() {
		E itemRemoved;
		if (isEmpty()) {
			throw new NullPointerException();
		} else if (size == 1) {
			itemRemoved = head.item;
			head = null;
			tail = null;
		} else {
			itemRemoved = head.item;
			head = head.next;
			head.prev = null;
		}
		size--;
		return itemRemoved;
	}

	public E removeFromEnd() {
		E itemRemoved;
		if (isEmpty()) {
			throw new NullPointerException();
		} else if (size == 1) {
			itemRemoved = tail.item;
			head = null;
			tail = null;
		} else {
			itemRemoved = tail.item;
			tail = tail.prev;
			tail.next = null;
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
				if (temp.item.equals(item)) {
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
			msg.append("\nhead: " + head.item + "\ntail: " + tail.item + "\n");
			Node<E> temp = head;
			do {
				msg.append(temp.item + " ");
				temp = temp.next;
			} while (temp != null);
			return msg + "\nsize: " + size;
		} else {
			return "Empty list";
		}
	}

	public class Node<E> {
		private E item;
		private Node<E> prev, next;

		public Node(E item, Node<E> prev, Node<E> next) {
			this.item = item;
			this.prev = prev;
			this.next = next;
		}
	}
}
