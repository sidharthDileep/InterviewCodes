package arrayList;

public class ArrayListMain {

	public static void main(String[] args) {
		
		MyArrayList list = new MyArrayList();
		list.add(new Integer(2));
		list.add(new Integer(3));
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}

	}

}
