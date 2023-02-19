package problems.interview;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Immutable {

	public static void main(String[] args) {

		HashMap<String, String> h1 = new HashMap<>();
		h1.put("1", "first");
		h1.put("2", "second");

		String name = "original";
		String email = "sidharthdileep96@gmail.com";

		int i = 10;

		ArrayList<Integer> l1 = new ArrayList<>();
		l1.add(2);
		l1.add(3);

		Date date = new Date(2000, 12, 25);

		ImmutableEmployee emp = new ImmutableEmployee(i, name, email, date, h1, l1);

		System.out.println(name == emp.getName());
		System.out.println(h1 == emp.getTestMap());

		System.out.println("ce id : " + emp.getId());
		System.out.println("ce name : " + emp.getName());
		System.out.println("ce testMap : " + emp.getTestMap());
		System.out.println("ce testList : " + emp.getTestList());

		i = 20;
		name = "modified";
		h1.put("3", "third");
		l1.add(4);

		System.out.println("-------------------------------");

		System.out.println("emp id after change : " + emp.getId());
		System.out.println("emp name after change : " + emp.getName());
		System.out.println("emp testMap after change : " + emp.getTestMap());
		System.out.println("emp testList : " + emp.getTestList());

		HashMap<String, String> hmTest = emp.getTestMap();
		hmTest.put("4", "fourth");

		System.out.println("emp testMap after changing variable from accessor methods : " + emp.getTestMap());

		System.out.println(emp.getId() + " " + emp.getEmail() + " " + emp.getDOJ());

		Date date2 = emp.getDOJ();
		date2.setDate(12);
		System.out.println(emp.getId() + " " + emp.getEmail() + " " + emp.getDOJ());

		date.setDate(13);
		System.out.println(emp.getId() + " " + emp.getEmail() + " " + emp.getDOJ());
	}

}

final class ImmutableEmployee {

	private final int id;
	private final String name;
	private final String email;

	private final Date DOJ;

	private final HashMap<String, String> testMap;

	private final ArrayList testList;

	public ImmutableEmployee(int id, String name, String email, Date DOJ, HashMap<String, String> hm,
			ArrayList<Integer> hlist) {
		this.id = id;
		this.name = name;
		this.email = email;

		Date temp = new Date(DOJ.getTime());
		this.DOJ = temp;

		HashMap<String, String> tempMap = new HashMap<String, String>();

		for (Map.Entry<String, String> entry : hm.entrySet()) {
			tempMap.put(entry.getKey(), entry.getValue());
		}

		this.testMap = tempMap;

		ArrayList<Integer> tempList = new ArrayList<>();

		for (int j = 0; j < hlist.size(); j++) {
			tempList.add(hlist.get(j));
		}

		this.testList = tempList;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public Date getDOJ() {
		Date temp = new Date(DOJ.getTime());
		return temp;
	}

	public HashMap<String, String> getTestMap() {
		// return testMap;
		return (HashMap<String, String>) testMap.clone();
	}

	public ArrayList<Integer> getTestList() {
		// return Collections.unmodifiableList(this.testList);

		return (ArrayList) testList.clone();
	}

}
