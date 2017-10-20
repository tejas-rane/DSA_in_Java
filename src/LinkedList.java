
public class LinkedList {
	Node head ;
	static class Node{
		int data;
		Node next;
		public Node(int data) {
			super();
			this.data = data;
			this.next = null;
		}
		
	}
	public void printlist (){
		Node n = head;
		while (n !=null){
			System.out.print(n.data + "  ");
			n= n.next;
		}
		System.out.println();
	}
	public  void push(int data){
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}
	
	public void insertAfter(int data, int pos){
		int count = 0;
		Node prev = head;
		if(pos == 0 ){
			push(data);
			return;
		}else{
			while (pos > 1){
				prev = prev.next;
				pos--;
			}
			insertAfter(data,prev);
		}
		
		
	}
	
	public void append(int data){
		Node newNode = new Node(data);
		Node temp = head;
		while(temp.next!= null){
			temp= temp.next;
		}
		newNode.next= null;
		temp.next=newNode;
	}
	
	public void insertAfter(int data, Node prev){
		Node newNode = new Node(data);
		if(prev == null) {
			System.out.println("cannot be inserted");
			return ;
		}
		newNode.next = prev.next;
		prev.next = newNode;
		
	}
	
	public void delete(int pos){
		//if it is empty
		if (head == null){
			return;
		}
		
		//if head is to be removed
		Node remove = head;
		if(pos == 0 ){
			head = remove.next;
		}
		else{
			while(pos > 1){
				remove = remove.next;
				pos --;
			}
			if (remove == null || remove.next == null){
				return;
			}
			remove.next = remove.next.next;
		}
	}
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		
		list.head = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);
		Node fourth = new Node (4);
		
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
	}

}
