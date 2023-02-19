package problems;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class findIps {

	public static void main(String[] args) throws IOException {
		
		/*
		 * File("src/60.ips.txt") .readLines() .groupingBy { it } .eachCount() .forEach
		 * { (ip, count) -> println("$ip -> $count times") }
		 */
		
		
		Map<String, Long> dupes = new HashMap<>();
		try {
			dupes = Files.lines(Paths.get("C:\\Codes\\60ips.txt"))
			        .collect(Collectors.groupingBy(e -> e.substring(0, 8), 
			             Collectors.counting()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		dupes
			.forEach((k, v) -> System.out.printf("(%d) times : %s %n", v, k));

        // pretty print
        //dupes.forEach((k, v)-> System.out.printf("(%d) times : %s ....%n", 
          //   v, k.substring(0,  Math.min(50, k.length()))));
		
		long count = Files.lines(Paths.get("C:\\Codes\\60ips.txt")).distinct().count();
		
		System.out.println("Count : " + count);
		
	}

}
