import java.util.Stack;

public class LinkedList {
	Node head;

	static class Node {
		int data;
		Node next;

		public Node(int data) {
			super();
			this.data = data;
			this.next = null;
		}
	}

	
	public void printlist() {
		Node n = head;
		while (n != null) {
			System.out.print(n.data + "  ");
			n = n.next;
		}
		System.out.println();
	}

	public void push(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}

	public void insertAfter(int data, int pos) {
		int count = 0;
		Node prev = head;
		if (pos == 0) {
			push(data);
			return;
		} else {
			while (pos > 1) {
				prev = prev.next;
				pos--;
			}
			insertAfter(data, prev);
		}
	}

	public void append(int data) {
		Node newNode = new Node(data);
		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		newNode.next = null;
		temp.next = newNode;
	}

	public void insertAfter(int data, Node prev) {
		Node newNode = new Node(data);
		if (prev == null) {
			System.out.println("cannot be inserted");
			return;
		}
		newNode.next = prev.next;
		prev.next = newNode;
	}

	public void delete(int pos) {
		// if it is empty
		if (head == null) {
			return;
		}
		// if head is to be removed
		Node remove = head;
		if (pos == 0) {
			head = remove.next;
		} else {
			while (pos > 1) {
				remove = remove.next;
				pos--;
				if (remove == null || remove.next == null) {
					return;
				}
			}
			remove.next = remove.next.next;
		}
	}

	public boolean searchRecursive(int i, Node node) {

		if (node == null)
			return false;
		if (node.data == i)
			return true;
		else
			return searchRecursive(i, node.next);
	}

	public boolean searchIterative(int i) {
		Node temp = head;
		while (temp != null) {
			if (temp.data == i)
				return true;
			else
				temp = temp.next;
		}
		return false;
	}

	public int lengthIterative() {
		int count = 0;
		Node runner = head;
		while (runner != null) {
			count++;
			runner = runner.next;
		}
		return count;
	}

	public int lengthRecursive(Node node) {
		if (node == null) {
			return 0;
		} else
			return 1 + lengthRecursive(node.next);
	}

	public void swapNodes(int x, int y) {
		if (x == y) {
			System.out.println("Swap : same");
			return;
		}
		// currx and curry are the nodes to be swapped, as loop will break when
		// data is equal and found!
		Node currx = head;
		Node prevx = null;
		while (currx != null && currx.data != x) {
			prevx = currx;
			currx = currx.next;
		}
		Node curry = head;
		Node prevy = null;
		while (curry != null && curry.data != y) {
			prevy = curry;
			curry = curry.next;
		}
		// lets check the currx and curry, if they are null, return
		if (currx == null || curry == null) {
			System.out.println("Swap : any one/both not found");
			return;
		}
		;
		if (prevx != null) {// tells that there is a node before currx such that
							// currx is not a head node
			prevx.next = curry;
		} else {
			head = curry;
		}
		if (prevy != null) {
			prevy.next = currx;
		} else {
			head = currx;
		}
		Node temp = currx.next;
		currx.next = curry.next;
		curry.next = temp;
		this.printlist();
	}

	public Node reverseIterative() {
		Node prev= null;
        Node curr  = null;
        Node next = head;
        while(next != null){
            curr = next;
            next = next.next;
            curr.next = prev;
            prev = curr ;
        }
        return prev; // return curr also works
		/*Node current = head;
		Node prev = null;
		Node next = null;

		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;*/
	}

	public Node reverseRecursively(Node node) {
		if (node.next == null) {
			return node;
		}
		Node ret = reverseRecursively(node.next);
		// System.out.println("ret value is "+ ret.data);
		node.next.next = node;
		node.next = null;
		return ret; // this is the new head and hence the value of ret is last
					// node in all iteration
	}
	public Node reverseKNodesInGroups(Node head, int k){
		Node prev= null;
        Node curr  = null;
        Node next = head;
        int count = 0;
        while(count < k && next != null){
            curr = next;
            next = next.next;
            curr.next = prev;
            prev = curr ;
            count++;
        }
        //next is pointer to k+ 1 node
        if(next!=null )
            head.next = reverseKNodesInGroups(next,k);
        
        return prev;
        /*int count = 0;
		Node curr= head;
		Node next = null;
		Node prev = null;
		
		while (count < k && curr != null){
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			count++;
		}
		//We need to reverse in groups of K, so it is a problem of recursion
		// at this point first k nodes have reversed, so curr is pointing to k+1 node
		// pass that again to repeat the patter
		//prev holds the end of minor group which is kth node
		// at the end this will be the head, so return prev 
		if(next != null){
			head.next = reverseKNodesInGroups(curr,k);
		}
		return prev;*/
	}
	public void printMiddleElement() {
		Node slw = head;
		Node fast = head;
		while (fast != null && fast.next != null) {
			slw = slw.next;
			fast = fast.next.next;
		}
		System.out.println("middle element is " + slw.data);
		// if length of LinkedList is even, it floors the middle and gives value
		// of next element
	}

	public void getNthElement(int index) {
		int count = 0;
		int length = lengthIterative();
		Node temp = head;
		if (index >= length) {
			System.out.println("Index out of bound");
			return;
		}
		while (count < index) {
			temp = temp.next;
			count++;
		}
		System.out.println("Value at index " + index + " is " + temp.data);
	}

	public void getNthElementFromEnd(int index) {
		int len = lengthIterative();
		int newIndex = (len - index) - 1;
		int count = 0;
		Node temp = head;
		// getNthElement(newIndex); the display messg is not generic, so copy
		// pasted above code
		if (newIndex > len) {
			System.out.println("Index out of bound");
			return;
		}
		while (count < newIndex) {
			temp = temp.next;
			count++;
		}
		System.out.println("Value at index " + index + " from end of list is " + temp.data);
	}

	public void countOccurences(int num) {
		int count = 0;
		Node temp = head;
		while (temp != null) {
			if (temp.data == num)
				count++;
			temp = temp.next;
		}
		System.out.println("Given num: " + num + " fonud " + count + " times.");
	}

	public void deleteList() {
		head = null; // everything else is garbage collected
	}

	public void detectLoop(){ // Floyd's cycle finding algorithm
		Node fst = head; Node slw = head;
		while(slw != null && fst != null && fst.next != null){
			slw = slw.next;
			fst = fst.next.next;
			if(slw == fst){
				System.out.println("Loop detected");
				return; // retun true if boolean
			}
			
		}
		return; // retun false if boolean
	}
	public void swapInpairsIterative(){
		Node temp = head;
		while( temp!=null && temp.next!=null){
			int holder = temp.data;
			temp.data = temp.next.data;
			temp.next.data = holder;
			
			temp = temp.next.next;
		}
		printlist();
	}
	//Function to check if a singly linked list is palindrome
	public void checkPalindrome(){
		Stack<Integer> st = new Stack<>();
		Node temp = head;
		while(temp != null){
			st.push(temp.data);
			temp = temp.next;
		}
		Node temp2 = head;
		boolean palindrome= false;
		while(temp2 != null){
			if(st.pop() == temp2.data){
				temp2 = temp2.next;
				palindrome = true;
			}else{
				System.out.println("Linked list is Not a palindrome");
				palindrome = false;
				break;
			}
		}
		if (palindrome) System.out.println("Linked list is  a palindrome");
		return;
	}
	public void isCircular(){
		if(head == null)
			System.out.println("Its a circle Linked List");
		Node temp = head;
		
		while(temp.next != null && temp.next != head)
			temp = temp.next;
		
		if (temp.next ==  head)
			System.out.println("It is a circular Linked List");
		else System.out.println("Not a circular Linked List");
		
	}
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.head = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);
		Node fourth = new Node(4);
		list.head.next = second;
		second.next = third;
		third.next = fourth;
		list.printlist();
		list.push(0);
		System.out.println("push ");
		list.printlist();
		list.insertAfter(10, second);
		System.out.println("insert after ");
		list.printlist();
		list.insertAfter(13, 3);
		System.out.println("insert after ");
		list.printlist();
		list.append(25);
		System.out.println("append ");
		list.printlist();
		list.delete(0);
		System.out.println("delete ");
		list.printlist();
		list.delete(3);
		System.out.println("delete ");
		list.printlist();
		list.delete(26);
		System.out.println("delete which is not present");
		list.printlist();
		System.out.println("length iterative " + list.lengthIterative());
		System.out.println("length recursive " + list.lengthRecursive(list.head));
		if (list.searchIterative(13))
			System.out.println("found " + 13);
		if (list.searchRecursive(13, list.head))
			System.out.println("found " + 13);
		System.out.println("found 14 ? " + list.searchRecursive(14, list.head));
		System.out.println("found 14 ? " + list.searchRecursive(14, list.head));
		System.out.println("--------------------------");
		/*
		 * 1) x and y may or may not be adjacent. 2) Either x or y may be a head
		 * node. 3) Either x or y may be last node. 4) x and/or y may not be
		 * present in linked list.
		 */
		list.swapNodes(13, 4);
		list.swapNodes(13, 13);
		list.swapNodes(13, 26);
		list.swapNodes(12, 26);
		list.swapNodes(1, 4);
		list.swapNodes(4, 25);
		list.swapNodes(13, 4);

		
		list.printMiddleElement();
		list.append(76);
		list.printlist();
		list.printMiddleElement();
		list.append(37);
		list.printlist();
		list.printMiddleElement();
		list.getNthElement(5);
		list.getNthElement(9);
		list.printlist();
		list.getNthElementFromEnd(2);
		list.countOccurences(4);
		list.push(4);
		list.countOccurences(4);
		list.detectLoop(); // ideally should return boolean
		list.printlist();
		System.out.println("Swap in pairs");
		list.swapInpairsIterative();
		list.head = list.reverseIterative();
		System.out.println("reverse Iterative");
		list.printlist();
		list.head = list.reverseRecursively(list.head);
		System.out.println("reverse Recursively");
		// list.reverseInGroupsof();
		list.printlist();
		list.push(100);
		list.push(16);
		list.printlist();
		System.out.println("reverse in groups");
		list.head = list.reverseKNodesInGroups(list.head,3);
		list.printlist();
		list.checkPalindrome();
		list.delete(0);list.delete(1);list.delete(2);list.delete(3);
		list.printlist();
		list.append(37);list.append(13);list.append(3);list.append(2);list.append(4);
		list.printlist();
		list.checkPalindrome();
		
	}
}
