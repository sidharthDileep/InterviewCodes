package linkedList;

import java.util.HashSet;

public class LinkedList {

	Node head;

	public void printList() {
		Node n = head;

		while (n != null) {
			System.out.print(n.data + " -> ");
			n = n.next;
		}
	}

	public void printList(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}
	/*
	 * public void insert(int d) { Node newNode = new Node(d); Node tempNode = head;
	 * while(tempNode != null) { tempNode = tempNode.next;
	 * 
	 * } tempNode.data = newNode.data; tempNode.next = null; }
	 */

	public void push(int new_data) {

		Node new_node = new Node(new_data);
		new_node.next = head;
		head = new_node;

	}

	public void insert(int d, int location) {
		Node node = new Node(d);
		if (head == null) {
			node.next = null;
			head = node;
		} else if (location == 0) {
			node.next = head;
			head = node;
		} else {
			Node tempNode = head;
			int index = 0;
			while (index < location - 1) {
				tempNode = tempNode.next;
				index++;
			}
			Node nextNode = tempNode.next;
			tempNode.next = node;
			node.next = nextNode;
		}

	}

	public void traverse() {
		if (head == null) {
			System.out.println("List doesn't exist");
		} else {
			Node tempNode = head;
			while (tempNode != null) {
				System.out.print(tempNode.data + " ");
				tempNode = tempNode.next;
			}
		}
	}

	public boolean searchNode(int data) {
		Node tempNode = head;
		int i = 1;
		while (tempNode != null) {
			if (tempNode.data == data) {
				System.out.println("Node found at " + i);
				return true;
			}
			tempNode = tempNode.next;
			i++;
		}

		System.out.println("Node not found");
		return false;
	}

	public void deleteNode(int location) {
		if (head == null) {
			System.out.println("List doesn't exist");
			return;
		} else if (location == 0) {
			head = head.next;
		} else {
			Node tempNode = head;
			int index = 0;
			while (index < location - 1) {
				tempNode = tempNode.next;
			}
			tempNode.next = tempNode.next.next;
		}
	}

	public void deleteList() {
		head = null;
		System.out.println("List deleted successfully");
	}

	public void printNthFromLast(int n) {
		int len = 0;
		Node temp = head;

		while (temp != null) {
			temp = temp.next;
			len++;
		}

		if (len < n) {
			return;
		}

		temp = head;

		for (int i = 1; i < len - n + 1; i++) {
			temp = temp.next;
		}
		System.out.println("Length : " + len);
		System.out.println(temp.data);

	}

	public Node reverse(Node node) {
		Node prev = null;
		Node current = node;
		Node next = null;

		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		node = prev;
		return node;
	}

	public void rotate(int k) {

		if (k == 0) {
			return;
		}

		Node current = head;
		int count = 1;

		while (count < k && current != null) {
			current = current.next;
			count++;
		}

		if (current == null) {
			return;
		}

		Node kthNode = current;

		while (current.next != null) {
			current = current.next;
		}

		current.next = head;
		head = kthNode.next;
		kthNode.next = null;

	}

	public int GetNth(int index) {
		Node current = head;

		int count = 0;

		while (current != null) {

			if (count == index) {
				// System.out.println("Count: " + count);
				return current.data;
			}

			// System.out.println("Count: outside" + count);
			count++;
			current = current.next;
		}

		assert (false);
		return 0;
	}

	boolean detectLoop(Node h) {
		HashSet<Node> s = new HashSet<>();
		while (h != null) {
			if (s.contains(h)) {
				return true;
			}
			s.add(h);
			h = h.next;
		}
		return false;
	}

	int countNodes() {
		int count = 0;
		Node s = head;

		while (s != null) {
			count++;
			s = s.next;
		}
		return count;
	}

	void swapKth(int k) {
		int n = countNodes();

		if (n < k)
			return;

		if (2 * k - 1 == n)
			return;

		Node x = head;
		Node x_prev = null;

		for (int i = 1; i < k; i++) {
			x_prev = x;
			x = x.next;
		}

		Node y = head;
		Node y_prev = null;

		for (int i = 1; i < n - k + 1; i++) {
			y_prev = y;
			y = y.next;
		}

		if (x_prev != null) {
			x_prev.next = y;
		}

		if (y_prev != null) {
			y_prev.next = x;
		}

		Node temp = x.next;
		x.next = y.next;
		y.next = temp;

		if (k == 1)
			head = y;

		if (k == n)
			head = x;

	}

	Node reverseBetween(Node head, int m, int n) {
		if (head == null) {
			return null;
		}

		Node prev = null;
		Node current_node = head;

		while (m > 1) {
			prev = current_node;
			current_node = current_node.next;
			m--;
			n--;
		}

		Node connection = prev;
		Node tail = current_node;

		while (n > 0) {  
			Node next_node = current_node.next;
			current_node.next = prev;
			prev = current_node;
			current_node = next_node;
			n--;
		}

		if (connection != null) {
			connection.next = prev;
		} else {
			head = prev;
		}

		tail.next = current_node;
		return head;
	}

}
