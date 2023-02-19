package doublyLinkedList;

public class DLLMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DoublyLinkedList DLL = new DoublyLinkedList();
		
		DLL.append(6);
		DLL.append(7);
		DLL.append(1);
		DLL.append(4);
		DLL.append(6);
		
		DLL.printList(DLL.head);
		
		System.out.println();
		
		
		System.out.println("After insertAfter");
		DLL.insertAfter(DLL.head.next, 8);
		
		DLL.printList(DLL.head);
		
		
		System.out.println();
		System.out.println("After insertBefore");
		DLL.insertBefore(DLL.head.next.next, 5);
		  
		
		System.out.println();
        System.out.println("Created DLL is: ");
        DLL.printList(DLL.head);
		
	}

}
