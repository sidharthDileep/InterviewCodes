package employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class employeeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Employee employeeOne = new Employee(1, "personOne", "HR", 70000);
		Employee employeeTwo = new Employee(2, "personTwo", "HR", 20000);
		Employee employeeThree = new Employee(3, "personThree", "IT", 30000);
		Employee employeeFour = new Employee(4, "personFour", "IT", 40000);
		Employee employeeFive = new Employee(5, "personFive", "FIN", 50000);
		Employee employeeSix = new Employee(6, "personSix", "FIN", 60000);

		List<Employee> employees = new ArrayList<>(6);

		employees.add(employeeOne);
		employees.add(employeeTwo);
		employees.add(employeeThree);
		employees.add(employeeFour);
		employees.add(employeeFive);
		employees.add(employeeSix);
		
		OptionalDouble average = employees.stream()
				 .mapToInt(Employee::getSalary)
				 .average();
		
		System.out.println("Average : " + average.getAsDouble());
		
		Map<String, Double> avgPerDept = employees.stream()
		 .collect(Collectors.groupingBy(Employee::getDept, 
				 Collectors.averagingDouble(Employee::getSalary)));
		
		System.out.println("Average : " + avgPerDept);
		
		List<String> employeeNames = employees.stream()
								.collect(Collectors.mapping(Employee::getName, Collectors.toList()));
		
		System.out.println(employeeNames);
		
		//employees.stream().collect(Collectors.mapping(e -> e.getAge(), Collectors.maxBy(Integer::compareTo)));
		
		Map<String, Integer> map = employees.stream().collect(Collectors.toMap(Employee::getName, Employee::getSalary));
		
		
		System.out.println(map);

	}

}
