package binaryTree;

public class BinaryTreeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BinaryTree tree = new BinaryTree();

		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);

		System.out.println("PreOrder");
		tree.preOrder(tree.root);
		System.out.println();

		System.out.println("InOrder");
		tree.inOrder(tree.root);
		System.out.println();

		System.out.println("PostOrder");
		tree.postOrder(tree.root);
		System.out.println();

		BinaryTree tree2 = new BinaryTree();
		tree2.root = new Node(1);
		tree2.root.left = new Node(2);
		tree2.root.right = new Node(3);
		tree2.root.left.left = new Node(4);
		tree2.root.left.right = new Node(5);

		System.out.println("Level order traversal of binary tree is ");
		tree2.printLevelOrder();

	}

}
