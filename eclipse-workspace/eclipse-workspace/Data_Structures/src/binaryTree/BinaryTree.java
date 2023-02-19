package binaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

	Node root;

	public BinaryTree(int key) {
		root = new Node(key);
	}

	BinaryTree() {
		root = null;
	}

	public void preOrder(Node node) {
		if (node == null) {
			return;
		}

		System.out.print(node.key + " ");
		preOrder(node.left);
		preOrder(node.right);

	}

	public void inOrder(Node node) {
		if (node == null) {
			return;
		}

		inOrder(node.left);
		System.out.print(node.key + " ");
		inOrder(node.right);

	}

	public void postOrder(Node node) {
		if (node == null) {
			return;
		}

		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.key + " ");

	}

	public int findMin(Node node) {

		if (node == null)
			return Integer.MIN_VALUE;

		int res = node.key;
		int lres = findMin(node.left);
		int rres = findMin(node.right);

		if (lres < res) {
			res = lres;
		}
		if (rres < res) {
			res = rres;
		}

		return res;
	}

	static void insert(Node temp, int key) {
		if (temp == null) {
			temp = new Node(key);
			return;
		}

		Queue<Node> q = new LinkedList<Node>();
		q.add(temp);

		while (!q.isEmpty()) {
			temp = q.peek();
			q.remove();

			if (temp.left == null) {
				temp.left = new Node(key);
				break;
			} else {
				q.add(temp.left);
			}

			if (temp.right == null) {
				temp.right = new Node(key);
				break;
			} else {
				q.add(temp.right);
			}

		}

	}

	int height(Node root) {
		if (root == null)
			return 0;
		else {
			int lheight = height(root.left);
			int rheight = height(root.right);

			if (lheight > rheight) {
				return (lheight + 1);
			} else {
				return rheight + 1;
			}
		}

	}

	void printLevelOrder() {
		int h = height(root);
		int i;

		for (i = 1; i <= h; i++) {
			printGivenLevel(root, i);
			System.out.print(System.lineSeparator());
		}
	}

	private void printGivenLevel(Node root, int level) {

		if (root == null)
			return;

		if (level == 1)
			System.out.print(root.key + " ");

		else if (level > 1) {
			printGivenLevel(root.left, level - 1);
			printGivenLevel(root.right, level - 1);
		}

	}

	private void printLevelOrderQueue() {

		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);

		while (!queue.isEmpty()) {
			Node tempNode = queue.poll();
			System.out.print(tempNode.key + " ");

			if (tempNode.left != null)
				queue.add(tempNode.left);

			if (tempNode.right != null)
				queue.add(tempNode.right);

		}
	}

	private void levelWise(Node root, int k) {
		Stack<Node> currentLevel = new Stack<>();
		Stack<Node> nextLevel = new Stack<>();

		System.out.println("Root " + root);
		int level = 1;
		Node temp;

		currentLevel.push(root);

		while (!currentLevel.isEmpty()) {
			temp = currentLevel.peek();
			currentLevel.pop();

			if (temp.left != null) {
				nextLevel.push(temp.left);
			}

			if (temp.right != null) {
				nextLevel.push(temp.right);
			}

			if (level % k == 0) {
				Node n = temp.left;
				temp.left = temp.right;
				temp.right = n;
			}

			if (currentLevel.isEmpty()) {
				Stack<Node> t = currentLevel;
				currentLevel = nextLevel;
				nextLevel = t;
				level++;
			}
		}

	}

}
