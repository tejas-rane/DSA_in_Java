
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
	public  boolean searchRecursive(int i, Node node) {
		
		if(node == null) return false;
		if(node.data == i) return true;
		else return searchRecursive(i, node.next);
	}
	public  boolean searchIterative(int i) {
		Node temp = head;
		while (temp != null ){
			if(temp.data == i )return true;
			else temp = temp.next;
		}
		return false;
	}
	public int lengthIterative() {
		int count = 0 ;
		Node runner = head;
		while (runner!=null){
			count++;
			runner = runner.next; 
		}
		return count;
	}
	public int lengthRecursive(Node node) {
		if(node == null){
			return 0;
		}else return 1+lengthRecursive(node.next);
	}
	public void swapNodes(int x, int y){
		if(x == y){System.out.println("Swap : same"); return;}
		//currx and curry are the nodes to be swapped, as loop will break when data is equal and found!
		Node currx= head;
		Node prevx = null;
		while (currx != null && currx.data != x){
			prevx = currx;
			currx = currx.next;
		}
		Node curry= head;
		Node prevy = null;
		while (curry != null && curry.data != y){
			prevy = curry;
			curry = curry.next;
		}
		//lets check the currx and curry, if they are null, return
		if(currx == null || curry == null) {System.out.println("Swap : any one/both not found"); return;};
		if(prevx != null){// tells that there is a node before currx such that currx is not a head node
			prevx.next = curry;
		}else{
			head = curry;
		}
		if(prevy != null){
			prevy.next = currx;
		}
		else{
			head = currx;
		}
		Node temp = currx.next;
		currx.next = curry.next;
		curry.next = temp;
		this.printlist();
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
		System.out.println("length iterative "+list.lengthIterative());
		System.out.println("length recursive "+list.lengthRecursive(list.head));
		if(list.searchIterative(13)) System.out.println("found " + 13);
		if(list.searchRecursive(13, list.head)) System.out.println("found " + 13);
		System.out.println("found 14 ? " + list.searchRecursive(14, list.head));
		System.out.println("found 14 ? " + list.searchRecursive(14, list.head));
		System.out.println("--------------------------");
		/*1) x and y may or may not be adjacent.
		2) Either x or y may be a head node.
		3) Either x or y may be last node.
		4) x and/or y may not be present in linked list.*/
		list.swapNodes(13,4);
		list.swapNodes(13,13);
		list.swapNodes(13,26);
		list.swapNodes(12,26);
		list.swapNodes(1,4);list.swapNodes(4,25);list.swapNodes(13,4);
		
		//list.reverse();
		//list.reverseInGroupsof();
		//list.reverseFirstK
	}
}
