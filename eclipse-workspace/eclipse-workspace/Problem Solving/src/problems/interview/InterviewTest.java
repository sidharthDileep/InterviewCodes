package problems.interview;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class InterviewTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Integer num1 = 100;
		Integer num2 = 100;
		
		if(num1 == num2) {
			System.out.println("Hi");
		}
		
		LinkedList<Integer> list = new LinkedList<>();
		
		int arr1[] = {1, 2, 3, 4, 5 };
		int arr2[] = {6, 7, 8, 9, 10};
		
		
		System.arraycopy(arr1, 0, arr2, 1, 3);
		
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
		
		

	}

}
