package problems;

public class ReversePartialList {

	public static void main(String[] args) {

		int[] array = { 4, 1, 7, 2, 9, 4, 11, 8 };

		reverse(array, 3, 7);

		LinkedList list = new LinkedList();
		LinkedList.head = new problems.LinkedList.Node(10);
		LinkedList.head.next = new problems.LinkedList.Node(20);
		LinkedList.head.next.next = new problems.LinkedList.Node(30);
		LinkedList.head.next.next.next = new problems.LinkedList.Node(40);
		LinkedList.head.next.next.next.next = new problems.LinkedList.Node(50);
		LinkedList.head.next.next.next.next.next = new problems.LinkedList.Node(60);
		LinkedList.head.next.next.next.next.next.next = new problems.LinkedList.Node(70);
		list.printList(LinkedList.head);
		System.out.println();
		LinkedList.reverseBetween(LinkedList.head, 3, 6);
		list.printList(LinkedList.head);

	}

	private static void reverse(int[] arr, int start_index, int end_index) {

		int j = end_index;

		for (int i = start_index; i <= end_index / 2 + 1; i++) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			j--;
		}
		for (int k = 0; k < arr.length; k++) {
			System.out.print(arr[k] + " ");
		}
		System.out.println();
	}

}

class LinkedList {

	static Node head;

	LinkedList() {

	}

	static class Node {

		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	static Node reverse(Node node) {
		Node prev = null;
		Node current = node;

		while (current != null) {
			Node next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		node = prev;
		return node;
	}

	static Node reverseBetween(Node head, int m, int n) {
		
		Node curr = head, prev = null;
		int i;
		for (i = 1; i < m; i++) {
			prev = curr;
			curr = curr.next;
		}
		// This pointer stores the pointer to the head of
		// the reversed linkedlist
		Node rtail = curr;
		// This pointer stores the pointer to the tail of
		// the reversed linkedlist
		Node rhead = null;
		// Now reverse the linked list from m to n nodes
		while (i <= n) {
			Node next = curr.next;
			curr.next = rhead;
			rhead = curr;
			curr = next;
			i++;
		}
		// if prev is not null it means that some of the
		// nodes exits before m ( or if m!=1)
		if (prev != null)
			prev.next = rhead;
		else
			head = rhead;
		// at this point curr will point to the next of nth
		// node where we will connect the tail of the
		// reversed linked list
		rtail.next = curr;
		return head;
	}

	static Node reverseBetweenV2(Node head, int m, int n) {
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

	void printList(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}

}
