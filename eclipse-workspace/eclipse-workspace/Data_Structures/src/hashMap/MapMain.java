package hashMap;

import java.util.HashMap;
import java.util.Map;

public class MapMain {

	public static void main(String[] args) {
		
		MyMap<String, String> myMap = new MyMap<>(3);
        myMap.put("USA", "Washington DC");
        myMap.put("Nepal", "Kathmandu");
        myMap.put("India", "New Delhi");
        myMap.put("Australia", "Sydney");
        
        Map<Integer, Integer> map = new HashMap<>();
        
        
		System.out.println(myMap.get("USA"));

	}

}
