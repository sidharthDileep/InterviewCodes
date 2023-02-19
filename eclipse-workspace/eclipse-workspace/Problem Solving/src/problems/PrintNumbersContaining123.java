package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class PrintNumbersContaining123 {

	public static void main(String[] args) {

		// Given an array of numbers,
		// the task is to print only those numbers which have only 1, 2 and 3 as their
		// digits

		int arr[] = { 123, 1232, 456, 234, 32145 };

		int n = arr.length;

		List<Integer> list = new ArrayList<>();
		StringBuffer sbf = new StringBuffer();

		for (int i = 0; i < n; i++) {

			String str = Integer.toString(arr[i]);

			if (str.contains("1") && str.contains("2") && str.contains("3"))
				list.add(arr[i]);

		}

		Collections.sort(list);
		
		System.out.println(list);

		Iterator it = list.iterator();

		while (it.hasNext()) {
			int value = (int) it.next();

			if (sbf.length() > 0)
				sbf.append(", ");

			sbf.append(Integer.toString(value));
		}

		System.out.println(sbf.toString());

	}

}
