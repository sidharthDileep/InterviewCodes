package circularLinkedList;

public class CLLMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node last = null;
		
		CircularLinkedList cll = new CircularLinkedList();
		
		last = cll.addToEmpty(last, 6);
		System.out.println("***" + last.data);
		last = cll.addBegin(last, 4);
		System.out.println("***" + last.data);
		last = cll.addBegin(last, 2);
		System.out.println("***" + last.data);
		last = cll.addEnd(last, 8);
		System.out.println("***" + last.data);
		last = cll.addEnd(last, 12);
		System.out.println("***" + last.data);
		last = cll.addAfter(last, 10, 8); 
		cll.traverse(last);

	}

}
