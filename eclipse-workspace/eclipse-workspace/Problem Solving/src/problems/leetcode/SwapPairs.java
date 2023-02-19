package problems.leetcode;

public class SwapPairs {

	public static void main(String[] args) {

		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		printList(head);
		
		ListNode swapPairs = swapPairs(head);
		
		System.out.println();
		printList(swapPairs);

	}

	private static void printList(ListNode node) {
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
	}

	private static ListNode swapPairsV2(ListNode head) {

		ListNode fakeHead = new ListNode(-1);
		fakeHead.next = head;
		ListNode node = fakeHead;
		while (node != null & node.next != null && node.next.next != null) {
			
			ListNode first = node; // -1
			ListNode second = node.next;  // 1
			ListNode third = node.next.next; // 2
			first.next = third; // -1 1
			second.next = third.next; // 1 3
			third.next = second;  // 2 1
			node = second; // 1 2 1 3 4
			
			System.out.println();
			printList(head);
			
		}
		return fakeHead.next;
	}
	
	private static ListNode swapPairs(ListNode head) {

		ListNode temp = new ListNode(0);
		temp.next = head;
		ListNode current = temp;
	
		while (current.next != null && current.next.next != null) {
			ListNode first_node = current.next;
			ListNode second_node = current.next.next;
			
			first_node.next = second_node.next;
			current.next = second_node;
			current.next.next = first_node;
			current = current.next.next;
		}
		return temp.next;
	}

}

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}