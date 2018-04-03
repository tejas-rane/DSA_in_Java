class BSTNode {
	int data;
	BSTNode left, right;

	public BSTNode(int data) {
		super();
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

public class BST {

	static BSTNode root ;

	BST(int data) {
		root = new BSTNode(data);
	}

	BST() {
		root = null;
	}

	BSTNode insert(BSTNode rootNode, int data) {

		if(rootNode == null){
			rootNode = new BSTNode(data);
			//return rootNode;
		}
		else if(data<= rootNode.data){
			rootNode.left = insert(rootNode.left, data);
		}
		else{
			rootNode.right = insert(rootNode.right, data);
		}
		return rootNode;
	}
	boolean search(BSTNode rootNode, int data){
		if(rootNode == null) return false;
		else if(rootNode.data == data) return true;
		else if(data < root.data)return search(rootNode.left, data);
		return  search(rootNode.right, data);
		
	}
	void inOrder(BSTNode rootNode){ // left root right
		if(rootNode==null)return ;
		inOrder(rootNode.left);
		System.out.print(rootNode.data + " ");
		inOrder(rootNode.right);
	}
	void preOrder(BSTNode rootNode){ // root left right
		if(rootNode==null)return ;
		System.out.print(rootNode.data + " ");
		preOrder(rootNode.left);
		preOrder(rootNode.right);
	}
	void postOrder(BSTNode rootNode){ //left right root
		if(rootNode==null)return ;
		postOrder(rootNode.left);
		postOrder(rootNode.right);
		System.out.print(rootNode.data + " ");
	}
	public static int maxDepth(BSTNode root) {
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return 1;
        else if(root.left== null)
            return maxDepth(root.right)+1;
        else if(root.right== null)
            return maxDepth(root.left)+1;
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
	public static int minDepth(BSTNode root) {
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return 1;
        else if(root.left== null)
            return minDepth(root.right)+1;
        else if(root.right== null)
            return minDepth(root.left)+1;
        return Math.min(minDepth(root.left),minDepth(root.right))+1;
    }
	public static int findTilt(BSTNode root) {
        if(root == null)
            return 0;
        int left = findTilt(root.left);
        int right = findTilt(root.right);
        return Math.abs(left - right) + root.data;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BST bst = new BST();
		root = bst.insert(root,15);
		System.out.println("inOrder");
		bst.inOrder(root);
		root = bst.insert(root,10);
		//System.out.println("10 and root");
		System.out.println();bst.inOrder(root);
		root =bst.insert(root,20);
		//System.out.println("10,20 and root");
		System.out.println();bst.inOrder(root);
		bst.insert(root,8);
		System.out.println();bst.inOrder(root);
		bst.insert(root,12);
		System.out.println();bst.inOrder(root);
		bst.insert(root,40);
		System.out.println();bst.inOrder(root);
		bst.insert(root,42);
		System.out.println();bst.inOrder(root);
		bst.insert(root,39);
		System.out.println();bst.inOrder(root);
		bst.insert(root,41);
		System.out.println();bst.inOrder(root);
		bst.insert(root,11);
		System.out.println();bst.inOrder(root);
		bst.insert(root,14);
		System.out.println();bst.inOrder(root);
		if(bst.search(root, 8)) System.out.println("\nfound");
		else System.out.println("Not found");
		if(bst.search(root, 25)) System.out.println("found");
		else System.out.println("Not found");
		System.out.println("\npreorder");bst.preOrder(root);
		System.out.println("\npostorder");bst.postOrder(root);
		System.out.println("\nMax Depth is : "+ maxDepth(root));
		System.out.println("\nMin Depth is : "+ minDepth(root));
		System.out.println("\n Tilt of tree is " + findTilt(root));
	}

}
