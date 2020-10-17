package melindas;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

class MelindaSInl15Main {
	
	public static void main(String[] args) {
		
		String[] students = {"Oscar", "Johan", "Jerry", "Sofia", "Andreas", "Cemal", "Alexander"};
		Integer[] birthYears = {1994, 1994, 1982, 1987, 1994, 1991, 1988};
		StudentsArray s = new StudentsArray();
		
		for (int i = 0; i < students.length; i++) {
//			Skapa elevobjekt
			Elev elev = new Elev(students[i], birthYears[i]);
//			Lägg till objekten i en arrayList 
			s.addStudent(elev);
		}
//		Sortera arraylistan på ålder.
		Collections.sort(s.getStudents());		
		Print print = new Print();
//		Hämta en utskrift av arraylistan där det istället för födelseår står ålder.
		System.out.printf("%-15s%s%n", "Namn", "Ålder");
		print.printStudentsList(s.getStudents());
	}
}

class Elev extends Person implements Comparable<Object> {
	
	private Integer age;
	private int presentYear = Calendar.getInstance().get(Calendar.YEAR);
	
	Elev(String name, Integer birthYear) {
		super(name, birthYear);
	}
//	Returnerar elevens ålder genom att subtrahera nuvarande år med elevens födelseår. 
	public Integer getAge() {
		this.age = this.presentYear - super.getBirthYear();
		return age;
	}

	@Override
	public int compareTo(Object o) {
		Elev e = (Elev) o;
		return getAge().compareTo(e.getAge());
	}
}

class Person {

	private String name;
	private Integer birthYear;
	
	Person(String name, Integer birthYear) {
		this.name = name;
		this.birthYear = birthYear;
	}
	
	public String getName() {
		return name;
	}

	public Integer getBirthYear() {
		return birthYear;
	}
}

class StudentsArray {
//	Skapar en arraylist som elevobjekten läggs in i. 
	ArrayList<Elev> students = new ArrayList<Elev>();
	int nextPos = 0;
	public void addStudent(Elev elev) {
		students.add(elev);
		nextPos++;
	}
	
	public ArrayList<Elev> getStudents() {
		return students;
	}
}

class Print {
	
	public void printStudentsNameAndAge(Elev elev) {
//		Formaterar och skriver ut tabellraden.
		System.out.printf("%-15s%d%n", elev.getName(), elev.getAge());
	}
	
	public void printStudentsList(ArrayList<Elev> students) {
//		Itererar genom listan och skriver ut alla värden som inte är null. 
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i) != null) {
				printStudentsNameAndAge(students.get(i));
			}
		}
	}
}
 

