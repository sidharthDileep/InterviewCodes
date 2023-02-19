package student;

import java.time.LocalDate;

public class Student {
	
	int rollNo;
    String name;
    int Englishmarks;
    int Mathsmarks;
    int Sciencehmarks;
    LocalDate dateOfBirth;
    
	public Student(int rollNo, String name, int englishmarks, int mathsmarks, int sciencehmarks,
			LocalDate dateOfBirth) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		Englishmarks = englishmarks;
		Mathsmarks = mathsmarks;
		Sciencehmarks = sciencehmarks;
		this.dateOfBirth = dateOfBirth;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEnglishmarks() {
		return Englishmarks;
	}

	public void setEnglishmarks(int englishmarks) {
		Englishmarks = englishmarks;
	}

	public int getMathsmarks() {
		return Mathsmarks;
	}

	public void setMathsmarks(int mathsmarks) {
		Mathsmarks = mathsmarks;
	}

	public int getSciencehmarks() {
		return Sciencehmarks;
	}

	public void setSciencehmarks(int sciencehmarks) {
		Sciencehmarks = sciencehmarks;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
    
    
	
    

}
