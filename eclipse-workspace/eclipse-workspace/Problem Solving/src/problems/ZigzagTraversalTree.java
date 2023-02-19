package problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

import java.util.LinkedList;

public class ZigzagTraversalTree {

	public static void main(String[] args) {

		List<Integer> ans;

		Tree tree = new Tree();

		Node root = tree.newNode(1);
		root.left = tree.newNode(2);
		root.right = tree.newNode(3);
		root.left.left = tree.newNode(7);
		root.left.right = tree.newNode(6);
		root.right.left = tree.newNode(5);
		root.right.right = tree.newNode(4);
		System.out.println("ZigZag Order traversal of binary tree is");

		ans = tree.zigZagTraversal(root);

		System.out.println(ans);

	}

}

class Node {

	public int data;
	public Node left, right;

	public Node(int data) {
		this.data = data;
		left = right = null;
	}

}

class Tree {

	List<Integer> zigZagTraversal(Node root) {
		List<Integer> list = new ArrayList<>();

		if (root == null)
			return list;

		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);

		boolean leftToRight = true;

		while (queue.size() > 0) {
			int size = queue.size();
			List<Integer> temp = new ArrayList<>();

			for (int i = 0; i < size; i++) {
				Node curr = queue.poll();
				if (curr.left != null)
					queue.add(curr.left);
				if (curr.right != null)
					queue.add(curr.right);

				temp.add(curr.data);
			}

			if (leftToRight) {

			} else {
				Collections.reverse(temp);
			}

			for (int i = 0; i < temp.size(); i++) {
				list.add(temp.get(i));
			}

			leftToRight = !leftToRight;
		}

		return list;
	}

	Node newNode(int data) {
		Node node = new Node(data);
		return node;
	}

}