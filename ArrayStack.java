package lab6;

public class ArrayStack<T> implements Stack<T> {

	@SuppressWarnings("unchecked")
	T[] arr = (T[]) new Object[10];
	int top = 0;

	@SuppressWarnings("unchecked")
	protected void grow_array() {
		T[] newArr = (T[]) new Object[arr.length * 2];
		for (int i = 0; i < arr.length; i++) {
			newArr[i] = arr[i];
		}

	}

	@Override
	public void push(T item) {
		if (top == arr.length)
			grow_array();
		arr[top++] = item;
	}

	@Override
	public T pop() throws Exception {
		if (!empty())
			return arr[--top];
		throw new Exception("Stack underflow");

	}

	@Override
	public T peek() throws Exception {
		if (empty())
			throw new Exception();
		return arr[top - 1];

	}

	@Override
	public boolean empty() {
		return top == 0;

	}

}
