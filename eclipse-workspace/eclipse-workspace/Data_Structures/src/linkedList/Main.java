package linkedList;

public class Main {

	public static void main(String[] args) {

		LinkedList llist = new LinkedList();
		llist.head = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);

		llist.head.next = second;
		second.next = third;

		llist.printList();

		System.out.println();

		llist.insert(4, 2);

		System.out.println();

		llist.printList();

		System.out.println();

		llist.traverse();

		System.out.println();

		llist.searchNode(4);

		System.out.println();

		llist.deleteNode(1);

		llist.printList();

		System.out.println();

		llist.deleteList();

		llist.printList();

		/*
		 * llist.insert(1); llist.printList();
		 */

		llist.push(4);
		llist.push(5);
		llist.push(6);
		llist.push(7);
		llist.push(8);

		llist.printList();

		System.out.println();

		llist.printNthFromLast(4);

		LinkedList list = new LinkedList();
		list.head = new Node(85);
		list.head.next = new Node(15);
		list.head.next.next = new Node(4);
		list.head.next.next.next = new Node(20);

		System.out.println("Given Linked list");
		list.printList();
		list.head = list.reverse(list.head);
		System.out.println("");
		System.out.println("Reversed linked list ");
		list.printList();

		System.out.println();

		System.out.println("Rotate");
		list.rotate(2);
		list.printList();

		System.out.println();
		llist.deleteList();

		llist.push(20);
		llist.push(4);
		llist.push(15);
		llist.push(10);

		/* Create loop for testing */
		llist.head.next.next.next.next = llist.head;

		if (llist.detectLoop(llist.head))
			System.out.println("Loop found");
		else
			System.out.println("No Loop");

		System.out.println();

		LinkedList newList = new LinkedList();

		newList.push(1);
		newList.push(2);
		newList.push(3);
		newList.push(4);
		newList.push(5);

		System.out.println("Head : " + newList.head.data);

		newList.printList();

		System.out.println();

		newList.reverseBetween(newList.head, 2, 4);

		newList.printList();

	}

}
