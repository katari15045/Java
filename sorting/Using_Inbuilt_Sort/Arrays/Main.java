import java.util.Arrays;
import java.util.Comparator;

public class Main
{
	private static Student[] students;

	public static void main(String[] args)
	{
		initializeStudents();

		System.out.println("Unsorted Students : ");
		printStudents();

		Arrays.sort( students, new RollComparator() );
		System.out.println("Sorted on Roll no : ");
		printStudents();

		Arrays.sort( students, new NameComparator() );
		System.out.println("Sorted on Names : ");
		printStudents();

		Arrays.sort( students, new MarksComparator() );
		System.out.println("Sorted on Marks : ");
		printStudents();
	}

	private static void printStudents()
	{
		System.out.println( students[0] );
		System.out.println( students[1] );
		System.out.println( students[2] );

		System.out.println();
	}

	private static void initializeStudents()
	{
		students = new Student[3];

		Student a = new Student();
		Student b = new Student();
		Student c = new Student();
										// Fidaa
		a.rollNumber = 72;
		a.name = "Pallavi";
		a.marks = 35;

		b.rollNumber = 45;
		b.name = "Varun";
		b.marks = 24;

		c.rollNumber = 50;
		c.name = "Kammula";
		c.marks = 98;

		students[0] = a;
		students[1] = b;
		students[2] = c;
	}
}


class RollComparator implements Comparator<Student>
{
	public int compare(Student a, Student b)
	{
		return a.rollNumber - b.rollNumber;
	}
}

class NameComparator implements Comparator<Student>
{
	public int compare(Student a, Student b)
	{
		return a.name.compareTo(b.name);
	}
}

class MarksComparator implements Comparator<Student>
{
	public int compare(Student a, Student b)
	{
		return a.marks - b.marks;
	}
}


class Student
{
	int rollNumber;
	String name;
	int marks;

	public String toString()
	{
		return "Roll : " + rollNumber + "\nName : " + name + "\nMarks : " + marks + "\n";
	}
}