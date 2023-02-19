package problems.interview.tricky;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class TrickyQuestions4 {

	public static void main(String[] args) {

		// create an array list
		CopyOnWriteArrayList<String> al = new CopyOnWriteArrayList();
		System.out.println("Initial size of al: " + al.size());

		ArrayList<String> arraylist = new ArrayList<>();

		arraylist.add("C");
		arraylist.add("A");
		arraylist.add("E");
		arraylist.add("B");
		arraylist.add("D");
		arraylist.add("F");
		arraylist.add(1, "A2");
		// add elements to the array list
		al.add("C");
		al.add("A");
		al.add("E");
		al.add("B");
		al.add("D");
		al.add("F");
		al.add(1, "A2");
		System.out.println("Size of al after additions: " + al.size());

		// display the array list
		System.out.println("Contents of al: " + al);

		// Remove elements from the array list
		al.remove("F");
		al.remove(2);
		System.out.println("Size of al after deletions: " + al.size());
		System.out.println("Contents of al: " + al);

		try {
			Iterator<String> iterator = al.iterator();
			while (iterator.hasNext()) {
				if (iterator.next() == "D")
					al.remove("D");
				// iterator.remove();
			}
		} catch (ConcurrentModificationException e) {
			System.out.println("Method not supported: ConcurrentModificationException");
		} catch (UnsupportedOperationException e) {
			System.out.println("Method not supported: UnsupportedOperationException");
		}
		System.out.println("Size of al: " + al.size());
		System.out.println("Contents of al: " + al);

		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$");

		System.out.println("Initial size of arraylist: " + arraylist.size());
		System.out.println("Contents of arraylist: " + arraylist);

		arraylist.remove("F");
		arraylist.remove(2);

		System.out.println("Size of arraylist after deletions: " + arraylist.size());
		System.out.println("Contents of arraylist: " + arraylist);

		try {
			Iterator<String> iterator1 = arraylist.iterator();
			while (iterator1.hasNext()) {
				if (iterator1.next() == "D")
					arraylist.remove("D");
				// iterator1.remove();
			}
		} catch (ConcurrentModificationException e) {
			System.out.println("Method not supported: ConcurrentModificationException");
		} catch (UnsupportedOperationException e) {
			System.out.println("Method not supported:");
		} catch (IllegalStateException e) {
			System.out.println("Method not supported here in arraylist");
		}
		System.out.println("Size of arraylist: " + arraylist.size());
		System.out.println("Contents of arraylist: " + arraylist);

	}

}
