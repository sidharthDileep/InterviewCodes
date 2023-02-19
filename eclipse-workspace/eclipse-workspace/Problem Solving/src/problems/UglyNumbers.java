package problems;

public class UglyNumbers {

	public static void main(String[] args) {
		
		//Ugly numbers are numbers whose only prime factors are 2, 3 or 5. 
		//The sequence 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, … shows the first 11 ugly numbers. 
		//By convention, 1 is included. Write a program to find Nth Ugly Number.
		int ugly = 150;
		
		int num = getUglyNum(ugly);
		
		System.out.println(ugly + "th Ugly number : " + num);
		
	}

	private static int getUglyNum(int n) {
		
		int i = 1;
		int count = 1;
		
		while( n > count) {
			i++;
			if(isUgly(i) == 1)
				count++;
		}
		
		return i;
	}

	private static int isUgly(int no) {
		
		no = maxDivide(no, 2);
		no = maxDivide(no, 3);
		no = maxDivide(no, 5);
		
		return (no == 1)? 1 : 0;
	}

	private static int maxDivide(int a, int b) {
		
		while( a % b == 0) {
			a = a/b;
		}
		
		return a;
	}

}
