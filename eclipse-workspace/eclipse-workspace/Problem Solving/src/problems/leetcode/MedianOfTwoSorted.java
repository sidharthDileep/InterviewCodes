package problems.leetcode;

import java.util.Arrays;

public class MedianOfTwoSorted {

	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 6, 7, 8 };
		int[] arr2 = { 3, 4, 11, 13, 15, 17, 22 };
		
		int m = arr1.length;
		int n = arr2.length;

		System.out.println(findMedianSortedArrray(arr1, arr2));
		
		System.out.println(median(arr1, arr2, m, n));

	}
	
	

	private static double median(int[] arr1, int[] arr2, int m, int n) {
		
		if(m > n)
			return median(arr2, arr1, n, m);
		
		int low = 0, high = m, medianPos = ((m+n)+1)/2;
		
		while(low <= high) {
			int cut1 = (low+high)>>1;
			int cut2 = medianPos - cut1;
			
			int l1 = (cut1 == 0)? Integer.MIN_VALUE:arr1[cut1-1];
			int l2 = (cut2 == 0)? Integer.MIN_VALUE:arr1[cut2-1];
			int r1 = (cut1 == m)? Integer.MAX_VALUE:arr1[cut1];
			int r2 = (cut2 == n)? Integer.MAX_VALUE:arr2[cut2];
			
			if(l1<=r2 && l2<=r1) {
				if((m+n)%2 != 0) {
					return Math.max(l1, l2);
				} else {
					return(Math.max(l1, l2) + Math.min(r1, r2))/2.0;
				}
			} else if(l1 > r2) {
				high = cut1-1;
			} else {
				low = cut1+1;
			}
			
		}
		
		return 0.0;
	}



	private static double findMedianSortedArrray(int[] A, int[] B) {
		int m = A.length;
		int n = B.length;

		if ((m + n) % 2 != 0) {
			return (double) findKth(A, B, (m + n) / 2, 0, m - 1, 0, n - 1);
		} else {
			return (findKth(A, B, (m + n) / 2, 0, m - 1, 0, n - 1) + findKth(A, B, (m + n) / 2 - 1, 0, m - 1, 0, n - 1))
					* 0.5;
		}
	}

	private static int findKth(int[] A, int[] B, int k, int aStart, int aEnd, int bStart, int bEnd) {

		int aLen = aEnd - aStart + 1;
		int bLen = bEnd - bStart + 1;

		if (aLen == 0)
			return B[bStart + k];
		if (bLen == 0)
			return A[aStart + k];
		if (k == 0)
			return A[aStart] < B[bStart] ? A[aStart] : B[bStart];

		int aMid = aLen * k / (aLen + bLen);
		int bMid = k - aMid - 1;

		aMid = aMid + aStart;
		bMid = bMid + bStart;

		if (A[aMid] > B[bMid]) {
			k = k - (bMid - bStart + 1);
			aEnd = aMid;
			bStart = bMid + 1;

		} else {
			k = k - (aMid - aStart + 1);
			bEnd = bMid;
			aStart = aMid + 1;
		}

		return findKth(A, B, k, aStart, aEnd, bStart, bEnd);

	}

}
