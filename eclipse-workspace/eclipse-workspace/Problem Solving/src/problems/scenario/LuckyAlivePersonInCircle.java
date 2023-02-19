package problems.scenario;

public class LuckyAlivePersonInCircle {

	public static void main(String[] args) {
		int N = 5;
		System.out.println(isAlive(N));

	}

	private static int isAlive(int n) {
		
		if(n == 1)
			return 1;
		
		Node last = newNode(1);
		last.next = last;
		
		for(int i=2; i<=n; i++) {
			Node temp = newNode(i);
			temp.next = last.next;
			last.next = temp;
			last = temp;
		}
		
		Node curr = last.next;
		
		Node temp = new Node();
		
		while(curr.next != curr) {
			temp = curr;
			curr = curr.next;
			temp.next = curr.next;
			
			temp = temp.next;
			curr = temp;
		}
		
		int res = temp.data;
		
		return res;
	}
	
	static class Node{
		int data;
		Node next;
	}
	
	static Node newNode(int data) {
		Node node = new Node();
		node.data = data;
		node.next = null;
		return node;
	}

}
