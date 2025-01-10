package problems.cts.tiaa;

import java.util.HashMap;
import java.util.Map;

public class RamanujanNumber {
	public static void main(String[] args) {
        findRamanujanNumbers(10000);
    }

	private static void findRamanujanNumbers(int limit) {
		Map<Integer, int[]> cubeSumMap = new HashMap<>();

        for (int i = 1; i <= Math.cbrt(limit); i++) {
            for (int j = i; j <= Math.cbrt(limit); j++) {
                int sum = i * i * i + j * j * j;

                if (cubeSumMap.containsKey(sum)) {
                    int[] pair = cubeSumMap.get(sum);
                    System.out.printf("%d = %d^3 + %d^3 = %d^3 + %d^3%n", sum, pair[0], pair[1], i, j);
                } else {
                    cubeSumMap.put(sum, new int[]{i, j});
                }
            }
        }
	}
}
