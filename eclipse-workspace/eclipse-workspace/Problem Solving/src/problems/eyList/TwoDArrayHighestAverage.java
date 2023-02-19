package problems.eyList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TwoDArrayHighestAverage {

	public static void main(String[] args) {

		String[][] str = { { "vijay", "-66" }, { "vijay", "-65" }, { "akila", "-122" } };

		int n = str.length;
		int sum = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 2; j++) {
				System.out.println(str[i][j]);
			}
		}
		Map<String, Double> map = new HashMap<>();
		Map<String, Double> map2 = new HashMap<>();

		for (int i = 0; i < n; i++) {
			if (map.get(str[i][0]) == null) {
				map.put(str[i][0], Double.valueOf(str[i][1]));
			} else {
				map.put(str[i][0], map.get(str[i][0]) + Double.valueOf(str[i][1]));
			}
		}

		for (int i = 0; i < n; i++) {
			if (map2.get(str[i][0]) == null) {
				map2.put(str[i][0], 1.0);
			} else {
				map2.put(str[i][0], map2.get(str[i][0]) + 1.0);
			}
		}

		map.forEach((k, v) -> System.out.println("Name : " + k + " -- " + "Total Marks : " + Double.valueOf(v)));
		map2.forEach((k, v) -> System.out.println("Name : " + k + " -- " + "Total Subjects : " + Double.valueOf(v)));
		double max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			double avg = (double) Math.floor(map.get(str[i][0]) / map2.get(str[i][0]));
			if (avg > max) {
				max = avg;
			}
		}

		System.out.println("Avg : " + max);

		////////////////////////////////////

		Map<String, double[]> map3 = new HashMap<>();

		for (int i = 0; i < n; i++) {
			if (map3.get(str[i][0]) == null) {
				double[] array = new double[2];
				array[0] = Double.parseDouble(str[i][1]);
				array[1] = 1;
				map3.put(str[i][0], array);
			} else {
				double[] array = map3.get(str[i][0]);
				array[0] = array[0] + Double.parseDouble(str[i][1]);
				array[1] = array[1] + 1;
				map3.put(str[i][0], array);
			}
		}
		
		double max2 = Integer.MIN_VALUE;
		for(int i=0; i<n; i++){
		    double[] array = map3.get(str[i][0]);
		    double avg = (double) Math.floor(array[0]/array[1]);
		    if(avg > max){
		        max2 = avg;
		    }
		}
		
		System.out.println("Max " + max2);
		
		///////////////////////////
		
		Stream.of(str)
        .collect(
                Collectors.groupingBy(a -> a[0], 
                Collectors.averagingInt(a -> Integer.parseInt(a[1]))))
        .entrySet()
        .stream()
        .max(Map.Entry.comparingByValue())
        .ifPresent(bestScore -> {
                String message = String.format("Best score is %s, by %s", bestScore.getValue(), bestScore.getKey());
                System.out.println(message);
        });
		
		////////////////////////////////
        
        String[][] scores = { { "Amit", "70" }, { "Arthit", "60" },
                { "Peter", "60" }, { "Arthit", "100" } };
        
        Map<String, Double> sample = Arrays.stream(scores)
                						   .collect(Collectors.groupingBy(a -> a[0],
                						            Collectors.averagingDouble(a -> Double.parseDouble(a[1]))));
        System.out.println(sample);
        Entry<String, Double> entity = sample.entrySet().stream()
                .max(Map.Entry.comparingByValue()).get();
        System.out.println(entity);

	}

}
