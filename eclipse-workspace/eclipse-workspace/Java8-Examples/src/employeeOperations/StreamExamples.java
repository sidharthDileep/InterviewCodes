package employeeOperations;

import java.util.*;
import java.util.stream.Collectors;

class EmployeeTwo {
    Integer empId;
    String empName;
    Long salary;
    String email;
    Department department;

    EmployeeTwo(Integer empId, String empName, Long salary, String email, Department department) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.email = email;
        this.department = department;
    }

    public Department getDepartment() {
        return department;
    }

    public Long getSalary() {
        return salary;
    }
}

class Department {
    Integer deptId;
    String departmentName;

    Department(Integer deptId, String departmentName) {
        this.deptId = deptId;
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return departmentName;
    }
}

public class StreamExamples {
    public static void main(String[] args) {
        Department hrDept = new Department(1, "HR");
        Department corpDept = new Department(2, "CORP");
        Department itDept = new Department(3, "IT");

        Map<Integer, EmployeeTwo> empMap = new HashMap<>();
        empMap.put(1, new EmployeeTwo(1, "Harsh", 1000L, "Harsh@gmail.com", hrDept));
        empMap.put(2, new EmployeeTwo(2, "Harshita", 2000L, "Harshitha@gmail.com", hrDept));
        empMap.put(3, new EmployeeTwo(3, "Harshad", 1000L, "Harshad@gmail.com", hrDept));
        empMap.put(4, new EmployeeTwo(4, "Harshneeta", 4000L, "Harshneeta@gmail.com", hrDept));
        empMap.put(5, new EmployeeTwo(5, "Harshal", 2000L, "Harshal@gmail.com", hrDept));
        empMap.put(6, new EmployeeTwo(6, "Harshali", 3000L, "Harshali@gmail.com", hrDept));
        empMap.put(11, new EmployeeTwo(11, "Harshi", 1000L, "Harsh@gmail.com", corpDept));
        empMap.put(12, new EmployeeTwo(12, "Harshita", 2000L, "Harshitha@gmail.com", corpDept));
        empMap.put(13, new EmployeeTwo(13, "Harshad", 1000L, "Harshad@gmail.com", corpDept));
        empMap.put(14, new EmployeeTwo(14, "Harshneeta", 4000L, "Harshneeta@gmail.com", itDept));
        empMap.put(15, new EmployeeTwo(15, "Harshal", 2000L, "Harshal@gmail.com", itDept));
        empMap.put(16, new EmployeeTwo(16, "Harshali", 3000L, "Harshali@gmail.com", itDept));

        highestSalaryInEachDepartment(empMap);
    }

    public static void highestSalaryInEachDepartment(Map<Integer, EmployeeTwo> empMap) {
        empMap.values().stream()
            .collect(Collectors.groupingBy(EmployeeTwo::getDepartment))
            .forEach((department, employees) -> {
                EmployeeTwo highestPaidEmployee = employees.stream()
                    .max(Comparator.comparing(EmployeeTwo::getSalary))
                    .orElseThrow(NoSuchElementException::new);
                System.out.println("Highest salary in " + department + " is " + highestPaidEmployee.getSalary());
            });
    }
}

//SELECT s.SubjectName
//FROM Students st
//JOIN StudentSubjects ss ON st.StudentID = ss.StudentID
//JOIN Subjects s ON ss.SubjectID = s.SubjectID
//WHERE st.StudentName = 'John Doe';
