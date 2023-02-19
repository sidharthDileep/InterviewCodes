package circularLinkedList;

public class CircularLinkedList {

	Node addToEmpty(Node last, int data) {

		if (last != null) {
			return last;
		}

		Node temp = new Node();
		temp.data = data;
		last = temp;

		last.next = last;

		return last;

	}

	Node addBegin(Node last, int data) {
		if (last == null) {
			return addToEmpty(last, data);
		}

		Node temp = new Node();
		temp.data = data;

		temp.next = last.next;
		last.next = temp;

		last = temp;
		return last;
	}

	Node addEnd(Node last, int data) {
		if (last == null)
			return addToEmpty(last, data);

		Node temp = new Node();
		temp.data = data;
		temp.next = last.next;
		last.next = temp;
		last = temp;
		return last;
	}

	Node addAfter(Node last, int data, int item) {

		if (last == null) {
			return null;
		}

		Node temp, p;
		p = last.next;

		do {
			if (p.data == item) {
				temp = new Node();
				temp.data = data;
				temp.next = p.next;
				p.next = temp;
				if (p == last) {
					last = temp;
				}
				return last;
			}
			p = p.next;
		} while (p != last.next);

		System.out.println(item + " not present in the list.");
		return last;

	}

	void traverse(Node last) {
		Node p;

		if (last == null) {
			System.out.println("List is empty.");
			return;
		}

		p = last.next;
		do {
			System.out.print(p.data + " ");
			p = p.next;
		} while (p != last.next);

	}
	
	Node push(Node head_ref, int data) {
		Node ptr = new Node();
		Node temp = head_ref;
		ptr.data = data;
		ptr.next = head_ref;
		
		if(head_ref != null) {
			while(temp.next != head_ref) {
				temp = temp.next;
			}
			temp.next = ptr;
		} else {
			ptr.next = ptr;
		}
		
		head_ref = ptr;
		
		return head_ref;
	}

}
