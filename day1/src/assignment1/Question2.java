package assignment1;
import java.util.Scanner;
public class Question2 {
	public static void main(String args[]) {
		
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the number of students: ");
		int noOfStudents = sc.nextInt();
		int grades[] = new int [noOfStudents];
		for(int i=0; i<noOfStudents; i++) {
			while(true) {
			System.out.println("Enter marks of Student "+ (i+1));
			int mark = sc.nextInt();
			if(mark<=100 && mark>=0)
			{
				grades[i]= mark;
				break;
			}
			else {
				System.out.println("Invalid Marks!! Please Enter Again.");
				
			}
		}
		}
		double sum=0;
		for(int i=0; i<noOfStudents; i++) {
			sum+= grades[i]; 
		}
		System.out.println("The average mark is: " + (double) sum/noOfStudents);
		
	}

}
