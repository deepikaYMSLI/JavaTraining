package assignment1;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Question2 {
	public static void main(String args[]) {
		
		Scanner sc= new Scanner(System.in);
		int noOfStudents=0;
		while (true) {
			try {
				System.out.println("Enter the number of students: ");
				noOfStudents = sc.nextInt();
				if(noOfStudents<=0) {
					System.out.print("No Of Students can't be negative.");
				}
				else {
					break;
				}
			}
			catch (InputMismatchException e){
				System.out.println("Invalid input! Please enter a number.");
                sc.next(); 
			
			}
		}
		
		
		int grades[] = new int [noOfStudents];
		
		for(int i=0; i<noOfStudents; i++) {
				while(true) {
					try {
						
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
					
				
				catch (InputMismatchException e){
					System.out.println("Invalid input! Please enter a number.");
	                sc.next(); 
				
				}
			}
		}
		double sum=0;
		for(int i=0; i<noOfStudents; i++) {
			sum+= grades[i]; 
		}
		System.out.println("The average mark is: " + (double) sum/noOfStudents);
		sc.close();
	}

}
