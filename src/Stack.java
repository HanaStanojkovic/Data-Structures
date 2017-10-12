public class Stack<T> {

	private Object[] arr;
	private int top;

	public Stack(int size) {
		arr = new Object[size];
		top = -1;
	}

	public void push(T item) {
		if (top == (arr.length - 1)) {
			Object[] arr2 = new Object[arr.length * 2];
			for (int i = 0; i < arr.length; i++) {
				arr2[i] = arr[i];
			}
			arr = arr2;
		}
		arr[++top] = item;
	}

	@SuppressWarnings("unchecked")
	public T pop() {
		T result = null;
		if (top >= 0) {
			result = (T) arr[top];
			top--;
		} else {
			throw new NullPointerException();
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public T top() {
		return (T) arr[top];
	}

	public boolean isEmpty() {
		if (top == -1) {
			return true;
		}
		return false;
	}

	public String toString() {
		StringBuilder msg = new StringBuilder();
		for (int i = 0; i <= top; i++) {
			msg.append("[" + arr[i] + "] ");
		}
		return msg.toString();
	}

}