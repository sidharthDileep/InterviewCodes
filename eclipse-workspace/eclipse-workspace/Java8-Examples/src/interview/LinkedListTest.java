package interview;

public class LinkedListTest {

	Node head;

	public void insert(Node node, int data) {

		Node newNode = new Node(data);
		
		if(node == null) {
			head = newNode;
			return;
		}

		node.next = newNode;
		newNode.next = null;

	}

	//SELECT a.name, b.name FROM A a JOIN B b ON a.id = b.a_id;
	
	//DELETE 
	
}
