package doublyLinkedList;

public class DoublyLinkedList {

	Node head;

	public void push(int new_data) {
		Node new_node = new Node(new_data);

		new_node.next = head;
		new_node.prev = null;

		if (head != null) {
			head.prev = new_node;
		}

		head = new_node;
	}

	public void insertBefore(Node next_node, int new_data) {

		if (next_node == null) {
			System.out.println("The given next node can not be NULL");
			return;
		}

		Node new_node = new Node(new_data);

		new_node.prev = next_node.prev;

		next_node.prev = new_node;

		new_node.next = next_node;

		if (new_node.prev != null) {
			new_node.prev.next = new_node;
		} else {
			head = new_node;
		}

	}

	public void insertAfter(Node prev_node, int new_data) {

		if (prev_node == null) {
			System.out.println("The given previous node cannot be NULL ");
			return;
		}

		Node new_node = new Node(new_data);

		new_node.next = prev_node.next;

		prev_node.next = new_node;

		new_node.prev = prev_node;

		if (new_node.next != null) {
			new_node.next.prev = new_node;
		}
	}

	public void append(int new_data) {

		Node new_node = new Node(new_data);

		Node last = head;

		new_node.next = null;

		if (head == null) {
			new_node.prev = null;
			head = new_node;
			return;
		}

		while (last.next != null) {
			last = last.next;
		}

		last.next = new_node;

		new_node.prev = last;

	}

	public void printList(Node node) {
		Node last = null;

		System.out.println("Traversal in forward Direction");

		while (node != null) {
			System.out.print(node.data + " ");
			last = node;
			node = node.next;
		}

		System.out.println();
		System.out.println("Traversal in reverse direction");

		while (last != null) {
			System.out.print(last.data + " ");
			last = last.prev;
		}
	}

	public void reverse() {
		Node temp = null;
		Node current = head;

		while (current != null) {
			temp = current.prev;
			current.prev = current.next;
			current.next = temp;
			current = current.prev;
		}

		if (temp != null) {
			head = temp.prev;
		}
	}

}
