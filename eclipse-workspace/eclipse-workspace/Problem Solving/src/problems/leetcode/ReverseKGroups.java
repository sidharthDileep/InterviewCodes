package problems.leetcode;

public class ReverseKGroups {

	public static void main(String[] args) {

		Node1 head = null;
		int k = 3;
		head = insertNode(head, 1);
		head = insertNode(head, 2);
		head = insertNode(head, 3);
		head = insertNode(head, 4);
		head = insertNode(head, 5);
		head = insertNode(head, 6);
		head = insertNode(head, 7);
		head = insertNode(head, 8);

		System.out.print("Original Linked List: ");
		printLinkedList(head);
		System.out.print("After Reversal of k nodes: ");
		Node1 newHead = reverseKGroup(head, k);
		printLinkedList(newHead);

	}

	public static Node1 reverseKGroup(Node1 head, int k) {

		if (head == null || head.next == null)
			return head;

		/*
		 * ListNode current = head; ListNode next = null; ListNode prev = null;
		 * 
		 * int count = 0;
		 * 
		 * while(count < k && current != null){ next = current.next; current.next =
		 * prev; prev = current; current = next; count++; }
		 * 
		 * if(next != null) head.next = reverseKGroup(next, k);
		 * 
		 * return prev;
		 */

		Node1 dummy = new Node1(-1);
		dummy.next = head;

		Node1 curr = dummy;
		Node1 next = dummy;
		Node1 prev = dummy;

		int count = 0;

		while (head != null) {
			++count;
			head = head.next;
		}

		//while (count >= k) {
		while (next != null) {
			curr = prev.next;
			next = curr.next;

			 int toLoop = count > k ? k : count-1;
			 
			for (int i = 1; i < toLoop; i++) {
				curr.next = next.next;
				next.next = prev.next;
				prev.next = next;
				next = curr.next;
			}
			prev = curr;
			count -= k;
		}
		return dummy.next;
	}

	static Node1 insertNode(Node1 head, int val) {
		Node1 newNode = new Node1(val);
		if (head == null) {
			head = newNode;
			return head;
		}

		Node1 temp = head;
		while (temp.next != null)
			temp = temp.next;

		temp.next = newNode;
		return head;
	}

	static void printLinkedList(Node1 head) {
		while (head.next != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}
		System.out.println(head.val);
	}
}

class Node1 {
	int val;
	Node1 next;

	Node1() {
	}

	Node1(int val) {
		this.val = val;
	}

	Node1(int val, Node1 next) {
		this.val = val;
		this.next = next;
	}
}
