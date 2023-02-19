package Queue;

public class QueueMain {

	public static void main(String[] args) {

		Queue q = new Queue(10);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);
		q.enqueue(1);
		q.enqueue(6);
		q.enqueue(7);

		System.out.println(q.front());
		System.out.println(q.rear());

	}

}
