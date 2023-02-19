package problems;

import java.util.LinkedHashMap;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstRepeatAndNonRepeat {

	public static void main(String[] args) {
		
		LinkedHashMap<Character, Long> collect = "Sidharth".chars()
				  .mapToObj(i -> (char)i)
				  .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
		
		Optional<Character> findFirst = collect.entrySet().stream()
			   .filter(e -> (e.getValue() == 1))
			   .map(e -> e.getKey())
			   .findFirst();
		
		String str = "hhaaaf";
		for(char i : str.toCharArray()){
		    if(str.indexOf(i) == str.lastIndexOf(i)){
		        System.out.println("First non-repeating character is: "+i);
		        break;
		    }
		}
		
		Optional<Character> findFirst2 = collect.entrySet().stream()
						  .filter(e -> e.getValue() > 1)
						  .map(e -> e.getKey())
						  .findFirst();

		System.out.println("First Non-Repeating : " + findFirst.get());
		System.out.println("First Repeating : " + findFirst2.get());

	}

}
