package interview;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

public class Test {

	public static void main(String[] args) {
		
		Map<Integer, String> tmap = new TreeMap<>();
		Map<Integer, String> hmap = new HashMap<>();
		Map<Integer, String> chmap = new ConcurrentHashMap<>();
		
		tmap.put(1, "sid");
		tmap.put(2, "vasu");
		
	}

}
