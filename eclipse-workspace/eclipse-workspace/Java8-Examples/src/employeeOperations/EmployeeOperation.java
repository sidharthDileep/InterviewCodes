package employeeOperations;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeOperation {
public static void main(String[] args) {
		
		List<Employee> employeeList = new ArrayList<Employee>();
        
		employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
		employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
		employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
		employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
		employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
		employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
		employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
		employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
		employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
		employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
		employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
		employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
		employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
		employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
		employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
		employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
		employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));
		
		long noOfMaleEmp = employeeList.stream().filter(emp-> emp.getGender().equals("Male")).count();
		System.out.println("No of Male Employee = " +noOfMaleEmp);
		
		long noOfFemaleEmp = employeeList.stream().filter(emp->emp.getGender().equals("Female")).count();
		System.out.println("No. of Female Employee = "+noOfFemaleEmp );
		
		long toltalEmp = employeeList.stream().count();
		System.out.println("Total Number of Employee = " +toltalEmp);
		
//2.Print all the departments name on the organization
		//way .1
		System.out.println(employeeList.stream().map(emp-> emp.getDepartment()).distinct().collect(Collectors.joining(", ")));
		//way .2
		//Set<String> setOfDeparment = employeeList.stream().map(emp->emp.getDepartment()).collect(Collectors.toSet());
		//setOfDeparment.forEach(System.out::println);
		
//3. what is average of male and female employee
		//First Way
		Double avgOfAgeOfMAle = employeeList.stream().filter(emp-> emp.getGender().equals("Male")).
				collect(Collectors.averagingDouble(Employee::getAge));
		System.out.println("Average of Male Employee = "+avgOfAgeOfMAle);
		
		double aveOfAgeOfFemaleemp = employeeList.stream().filter(emp->emp.getGender().equals("Female")).
				collect(Collectors.averagingDouble(Employee::getAge));
		System.out.println("Average of Female Employee = "+aveOfAgeOfFemaleemp);
		//2nd Way
		Map<String, Double> aveOfEmployeeOnGender = employeeList.stream().
				collect(Collectors.groupingBy(emp->emp.getGender(),Collectors.averagingDouble(Employee::getAge)));
			System.out.println(aveOfEmployeeOnGender);	
//4. Highest paid employeedetails
			Employee highestPaidEmp = employeeList.stream().max((emp1,emp2)->(int)(emp1.getSalary()-(emp2.getSalary()))).get();
			System.out.println(highestPaidEmp);
//5. Get the name of all employee who have join after 2015.
			List<String> nameOfEmployeelist = employeeList.stream().filter(emp->emp.getYearOfJoining()>2015).
					map(Employee::getName).collect(Collectors.toList());
			System.out.println(nameOfEmployeelist);
//6.count the number of employee in each department.
			Map<String,Long> noOfEmpPerDepart = employeeList.stream().
					collect(Collectors.groupingBy(emp->emp.getDepartment(),Collectors.counting()));
			System.out.println(noOfEmpPerDepart);
//7.average salary of each department
			Map<String,Double> avgSalPerDepart = employeeList.stream().
					collect(Collectors.groupingBy(emp->emp.getDepartment(),Collectors.averagingDouble(emp->emp.getSalary())));
			System.out.println(avgSalPerDepart);
//8.get the details of youngest male employee in the product development department.
			Employee youngestMaleInProd = employeeList.stream().
					filter(emp->emp.getGender().equals("Male") && emp.getDepartment().equals("Product Development")).
					min((e1,e2)->e1.getAge()-e2.getAge()).get();
			System.out.println("Youngest male in Product Development "+ youngestMaleInProd);
//9. Most experienced in the organization
			String mostExpEmp = employeeList.stream().min((emp1,emp2)->emp1.getYearOfJoining()-emp2.getYearOfJoining()).get().getName();
			System.out.println("Most experienced in the organization "+mostExpEmp);
//10.How may male and female employee are there in sale department?
			Map<String,Long> saleGenderCount = employeeList.stream().filter(e->e.getDepartment().equals("Sales And Marketing")).
					collect(Collectors.groupingBy(e->e.getGender(),Collectors.counting()));
			System.out.println(saleGenderCount);
//11.What is the average salary of male and female employee?
			Map<String,Double> aveGenderSalary = employeeList.stream().
					collect(Collectors.groupingBy(e->e.getGender(),
							Collectors.averagingDouble(e->e.getSalary())));
			System.out.println(aveGenderSalary);
//12.List down the name of employee in each departmet.
			Map<String,List<String>> listOfnameInEachDepart = employeeList.stream().
					collect(Collectors.groupingBy(emp->emp.getDepartment(), Collectors.mapping(emp->emp.getName(), Collectors.toList())));
			System.out.println(listOfnameInEachDepart);
			
//13.What is the average salary and total salary of whole organization?
			double averageSalary = employeeList.stream().collect(Collectors.averagingDouble(emp->emp.getSalary()));
			System.out.println("Average salary of whole organization = "+averageSalary);
			double totalSalary= employeeList.stream().collect(Collectors.summarizingDouble(emp->emp.getSalary())).getSum();
			System.out.println("Total salary = "+totalSalary);
			
			//Optional<Double> sum = employeeList.stream().map(e -> e.getSalary()).reduce((a, b) -> a+b);
			
//14.seperate the employee who are younger or equal to 25 from those who are older than 25.
			System.out.println("----------------------------");
			Map<Boolean,List<Employee>>map = employeeList.stream().collect(Collectors.partitioningBy(emp->emp.getAge()>25));
			for(Entry<Boolean, List<Employee>> entry : map.entrySet()) {
				if(entry.getKey()) {
					System.out.println("Employees older than 25 years :");
				}else {
					System.out.println("Employees younger than or equal to 25 years :");
				}
				for(Employee e:entry.getValue()) {
					System.out.println(e.getName());
				}
			}
//15.who is the oldest employee of the organization, his name, age, department?
			Employee oldestEmp = employeeList.stream().collect(Collectors.maxBy((e1,e2)->e1.getAge()-e2.getAge())).get();
			Employee oldestEmp2 = employeeList.stream().max((e1, e2) -> e1.getAge() - e2.getAge()).get();
			System.out.println("Employee Name = "+oldestEmp.getName()+" Employee Age = "+oldestEmp.getAge()+" department = "+oldestEmp.getDepartment());
			System.out.println("Employee Name = "+oldestEmp2.getName()+" Employee Age = "+oldestEmp2.getAge()+" department = "+oldestEmp2.getDepartment());
		
		
	}
}
class Employee{
	int id;
    
    String name;
     
    int age;
     
    String gender;
     
    String department;
     
    int yearOfJoining;
     
    double salary;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getYearOfJoining() {
		return yearOfJoining;
	}

	public void setYearOfJoining(int yearOfJoining) {
		this.yearOfJoining = yearOfJoining;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Employee(int id, String name, int age, String gender, String department, int yearOfJoining, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.department = department;
		this.yearOfJoining = yearOfJoining;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", department="
				+ department + ", yearOfJoining=" + yearOfJoining + ", salary=" + salary + "]";
	}
	
	
	
}