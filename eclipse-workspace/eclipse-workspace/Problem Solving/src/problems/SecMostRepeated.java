package problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;

public class SecMostRepeated {

	public static void main(String[] args) {

		String arr[] = { "ccc", "aaa", "ccc", "ddd", "aaa", "aaa" };

		List<String> seq = Arrays.asList(arr);

		System.out.println(secMostRepeated(new Vector<String>(seq)));

	}

	private static String secMostRepeated(Vector vector) {

		HashMap<String, Integer> map = new HashMap<>();

		for (int i = 0; i < vector.size(); i++) {
			map.put((String) vector.get(i), map.getOrDefault(vector.get(i), 0) + 1);
		}

		int first_max = Integer.MIN_VALUE, sec_max = Integer.MIN_VALUE;

		Iterator<Map.Entry<String, Integer>> itr = map.entrySet().iterator();

		while (itr.hasNext()) {
			Map.Entry<String, Integer> entry = itr.next();
			int v = entry.getValue();
			if (v > first_max) {
				sec_max = first_max;
				first_max = v;
			} else if (v > sec_max && v != first_max) {
				sec_max = v;
			}
		}

		itr = map.entrySet().iterator();
		while (itr.hasNext()) {
			Map.Entry<String, Integer> entry = itr.next();
			int v = entry.getValue();
			if (v == sec_max) {
				return entry.getKey();
			}
		}

		return null;
	}

}
