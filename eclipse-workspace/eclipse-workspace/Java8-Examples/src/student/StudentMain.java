package student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class StudentMain {

	public static void main(String[] args) {
		
		Student s1 = new Student(101, "Sachin", 98, 96, 87, LocalDate.of(1996, 1, 8));
		Student s2 = new Student(102, "Prayag", 95, 92, 88, LocalDate.of(1994, 2, 5));
		Student s3 = new Student(103, "Dipin", 68, 76, 80, LocalDate.of(1993, 10, 23));
		Student s4 = new Student(104, "Jithin", 98, 91, 38, LocalDate.of(1989, 3, 21));
		Student s5 = new Student(105, "Suraj", 99, 56, 23, LocalDate.of(1991, 4, 13));
		
		List<Student> studentList = new ArrayList<>();
		
		studentList.add(s1);
		studentList.add(s2);
		studentList.add(s3);
		studentList.add(s4);
		studentList.add(s5);
		
		for(int i=0 ;i<studentList.size(); i++) {
			System.out.println(studentList.get(i).getRollNo());
		}
		
				 studentList.stream()
							//.sorted(Comparator.comparing(Student::getDateOfBirth))
							.filter(e -> e.getDateOfBirth().getYear() > 1995)
							.map(Student::getName)
							.forEach(System.out::println);
				 
		Map<String, Integer> map = new HashMap<>();
				 
	    for(int i=0; i<studentList.size(); i++) {
	    	
	    	int totalMarks = studentList.get(i).getEnglishmarks() + studentList.get(i).getMathsmarks()
	    							+ studentList.get(i).getSciencehmarks();
	    	
	    	map.put(studentList.get(i).getName(), totalMarks);
	    	
	    }
	    
	    System.out.println("**********");		
							   
	    
	    map.entrySet().stream()
	    			  .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
	    			  .limit(3)
	    			  .map(e -> e.getKey())
	    			  .forEach(System.out::println);;
	    			  
	    Map<String, Integer> finalMap = new LinkedHashMap<>();
	    
	    
	    studentList.stream()
	    		   .forEachOrdered(e -> finalMap.put(e.getName(), e.getEnglishmarks() + e.getMathsmarks() + e.getSciencehmarks()));
	    
	    System.out.println(finalMap);
	    
	    finalMap.entrySet().stream().limit(3).forEach(System.out::println);
		
	    Optional<Student> stu = studentList.stream()
				   .collect(Collectors.maxBy(Comparator.comparing(Student::getEnglishmarks)));
	    
	    String name = studentList.stream()
	    		   .max((e1, e2) -> e1.getEnglishmarks() - e2.getEnglishmarks()).get().getName();
	    
	    
	    System.out.println(stu.get().getName());
	    
	    System.out.println("Name : " + name);
	    
	    Optional<Integer> reduce = studentList.parallelStream().map(Student::getMathsmarks).reduce((a, b) -> a+b);
		
	    System.out.println(reduce);

	}

}
