package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListAndSet {

	public static void main(String[] args) {

		List<String> lista = new ArrayList<String>();
		List<String> listb = new ArrayList<String>();

		lista.add("Isabella");
		lista.add("Angelina");
		lista.add("Pille");
		lista.add("Hazem");

		listb.add("Isabella");
		listb.add("Angelina");
		listb.add("Bianca");
		
		List<String> listapluslistb = new ArrayList<>(lista);
		listapluslistb.addAll(listb);
		
		Set<String> listaunionlistb = new HashSet<>(lista);
		listaunionlistb.addAll(listb);
		
		listapluslistb.removeAll(listaunionlistb);
		
		System.out.println(listaunionlistb);
		
		/////////////////////////////////////////////////
		
		Collection<String> listDir = new ArrayList(Arrays.asList("1", "2", "3", "4", "5", "6", "7"));
		Collection<String> listDirCopy = new ArrayList<>();
		listDirCopy.addAll(listDir);
		Collection<String> listDB = new ArrayList(Arrays.asList("1", "3", "5", "7", "9"));
		List<String> destinationList = new ArrayList<String>();

		listDir.removeAll(listDB);
		listDB.removeAll(listDirCopy);

		destinationList.addAll(listDirCopy);
		destinationList.addAll(listDB);
		System.out.println(destinationList);
	}

}
