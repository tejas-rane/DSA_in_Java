
public class Stack {

	int top = -1;
	static final int MAX = 10;
	int arr[] = new int[MAX];

	public boolean isEmpty() {
		return top < 0; // if top is negative, means stack is empty
	}

	public boolean push(int el) {
		/*
		 * if(top >= MAX){ System.out.println("overflow"); return false; } else{
		 */
		if ((top + 1) == MAX) {
			System.out.println("Stack full");
			return false;
		}
		arr[++top] = el;
		printStack();
		return true;
	}

	public int pop() {
		if (top < 0) {
			System.out.println("overflow");
			return 0;
		} else {
			return arr[top--];

		}
	}

	public void printStack() {
		if (top == -1) {
			System.out.println("Stack is empty");
		}
		int pointer = top;
		System.out.println();
		while (pointer >= 0) {
			System.out.println(arr[pointer--]);
		}
	}

	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.printStack();
		stack.pop();
		stack.printStack();
		stack.pop();
		stack.printStack();
		stack.pop();
		stack.printStack();
		stack.pop();
		System.err.println("here");
		stack.printStack();
		for (int i = 0; i <= MAX; i++) {
			stack.push(i);
		}
		

	}

}
