package binarySearchTree;

public class BinarySearchTree {
	
	
	
	public Node insert(Node node, int data) {
		if(node == null) {
			return (new Node(data));
		} else {
			if(node.data <= data) {
				node.left = insert(node.right, data);
			} else {
				node.right = insert(node.left, data);
			}
		}
		
		return node;
	}
	
	
	
	

	int minValue(Node node) {
		Node current = node;

		while (current.left != null) {
			current = current.left;
		}

		return (current.data);
	}
	


	class Node {

		int data;
		Node left, right;

		Node(int d) {
			data = d;
			left = right = null;
		}
	}
}
