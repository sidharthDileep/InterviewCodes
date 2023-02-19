package problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class BookingsArrivalDeparture {

	public static void main(String[] args) {

		int arrival[] = { 1, 3, 5 };
		int departure[] = { 2, 6, 8 };
		int n = arrival.length;
		System.out.println(areBookingsPossible(arrival, departure, n, 1) ? "Yes" : "No");

	}

	private static boolean areBookingsPossible(int[] arrival, int[] departure, int n, int k) {

		List<List<Integer>> list = new ArrayList<>();

		for (int i = 0; i < arrival.length; i++) {
			List<Integer> li = new ArrayList<>();
			li.add(arrival[i]);
			li.add(departure[i]);
			list.add(li);
		}

		System.out.println(list);

		Collections.sort(list, new Comparator<List<Integer>>() {

			@Override
			public int compare(List<Integer> l1, List<Integer> l2) {
				if (l1.get(0) < l2.get(0)) {
					return -1;
				} else if (l1.get(0) == l2.get(0)) {
					if (l1.get(1) < l1.get(1))
						return -1;
					else
						return 1;
				} else {
					return 1;
				}
			}

		});

		System.out.println(list);

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).get(0) != list.get(i).get(1)) {
				if (k > 0) {
					k--;
					pq.add(list.get(i).get(1));
				} else {
					if (pq.peek() <= list.get(i).get(0)) {
						pq.remove();
						pq.add(list.get(i).get(1));
					} else {
						return false;
					}
				}
			}
		}

		return true;
	}

}
