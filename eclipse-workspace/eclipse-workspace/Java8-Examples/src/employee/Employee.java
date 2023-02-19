package employee;

import java.util.Objects;

public class Employee implements Comparable<Employee> {

	private int id;
	private String name;
	private String dept;
	private int salary;

	public int compareTo(Employee e) {
		return dept.compareTo(e.dept);

	}

	@Override
	public int hashCode() {

		int hash = 7;
		hash = 31 * hash + id;
		hash = 31 * hash + (null == name ? 0 : name.hashCode());
		return hash;

		// return Objects.hash(salary);
	}

	/*
	 * 
	 * @Override 
	 * public int hashCode() { 
	 * 	int result = (int) (id ^ (id >>> 32));
	 * 	result = 31 * result + name.hashCode(); 
	 * 	result = 31 * result +
	 * 	dept.hashCode(); 
	 * 	return result; 
	 * }
	 * 
	 * 
	 */
	@Override
	public boolean equals(Object obj) {

		if (obj == null || getClass() != obj.getClass())
			return false;

		if (obj == this)
			return true;

		return this.getSalary() == ((Employee) obj).getSalary();

	}

	public Employee(int id, String name, String dept, int salary) {
		this.id = id;
		this.name = name;
		this.dept = dept;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDept() {
		return dept;
	}

	public int getSalary() {
		return salary;
	}

}
