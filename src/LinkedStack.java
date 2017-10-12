public class LinkedStack<E> {

	private Node<E> top;
	private int size;

	public LinkedStack() {
		top = null;
		size = 0;
	}

	public void push(E item) {
		Node<E> temp = new Node<E>(item, top);
		top = temp;
		size++;
	}

	public E pop() {
		if (isEmpty()) {
			throw new NullPointerException();
		} else {
			E itemRemoved = top.data;
			top = top.next;
			size--;
			return itemRemoved;
		}
	}

	public E top() {
		if (isEmpty()) {
			throw new NullPointerException();
		} else {
			return top.data;
		}
	}

	public boolean isEmpty() {
		return size == 0;
	}
	
	public String toString() {
		StringBuilder msg = new StringBuilder();
		if (!isEmpty()) {
			msg.append("\ntop: "+top.data + "\n");
			Node<E> temp = top;
			do {
				msg.append(temp.data + " ");
				temp = temp.next;
			} while (temp != null);
			return msg + "\nsize: "+size;
		} else {
			return "Empty list";
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
