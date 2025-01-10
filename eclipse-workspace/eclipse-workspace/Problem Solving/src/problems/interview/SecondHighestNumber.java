package problems.interview;

public class SecondHighestNumber {

	public static void main(String[] args) {
		
		int[] arr = {3, 6, 2, 4, 23, 45, 12, 1, 45};
		
		int highest = Integer.MIN_VALUE;
		int second_highest = Integer.MIN_VALUE;
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] > highest) {
				second_highest = highest;
				highest = arr[i];
			} else if(arr[i] > second_highest && arr[i] != highest) {
				second_highest = arr[i];
			}
		}
		
		System.out.println("Highest : " + highest);
		System.out.println("Second Highest : " + second_highest);

	}

}
