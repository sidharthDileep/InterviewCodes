package others;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.stream.Stream;

public class custom {

	public static void main(String[] args) {

		List<String> names = new LinkedList<>();
		names.add("learn");
		names.add("from");
		names.add("Geeksforgeeks");

		ListIterator<String> listIterator = names.listIterator();

		System.out.println("Forward Direction Iteration:");
		while (listIterator.hasNext()) {
			System.out.print(listIterator.next() + ", ");
		}
		System.out.println();

		System.out.println("Backward Direction Iteration:");
		while (listIterator.hasPrevious()) {
			System.out.print(listIterator.previous() + ", ");
		}

		ArrayList<Integer> al = new ArrayList<>();

		// Add values to the array list.
		al.add(1);
		al.add(2);
		al.add(-3);
		al.add(-4);
		al.add(5);

		// Obtain a Stream to the array list.
		Stream<Integer> str = al.stream();

		// getting Spliterator object on al
		Spliterator<Integer> splitr1 = str.spliterator();

		System.out.println("estimate size : " + splitr1.estimateSize());

		// getExactSizeIfKnown method
		System.out.println("exact size : " + splitr1.getExactSizeIfKnown());

		// hasCharacteristics and characteristics method
		System.out.println(splitr1.hasCharacteristics(splitr1.characteristics()));

		System.out.println("Content of arraylist :");
		// forEachRemaining method
		splitr1.forEachRemaining((n) -> System.out.print(n + " "));

	}

}
