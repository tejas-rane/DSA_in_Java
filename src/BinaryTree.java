class Node{
	int data;
	Node left, right;
	public Node(int data) {
		super();
		this.data = data;
		this.left = null;
		this.right = null;
	}
}
public class BinaryTree {
	Node root;
	BinaryTree( int data){
		root = new Node(data);
	}
	BinaryTree(){
		root = null;
	}
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new Node(1);
		bt.root.left = new Node(2);
		bt.root.right = new Node(3);
		bt.root.left.left = new Node(4);
		BinaryTree bt2 = new BinaryTree(5);
	}
}
