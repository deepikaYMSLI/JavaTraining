package assignment1;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Question4 {
	    public static void PascalTriangle(int rows) {
	    	int[][] triangle = new int[rows][];

	        // Fill the 2D array
	        for (int i = 0; i < rows; i++) {
	            triangle[i] = new int[i + 1];
	            for (int j = 0; j <= i; j++) {
	                triangle[i][j] = j + 1;
	            }
	        }

	        // Print the pattern
	        for (int i = 0; i < rows; i++) {
	            for (int j = 0; j < triangle[i].length; j++) {
	                System.out.print(triangle[i][j] + " ");
	            }
	            System.out.println();
	        }
	    }
	    public static void main (String[] args) {
	    	Scanner sc= new Scanner(System.in);
	    	int rows=0;
	    	System.out.print("Enter the no of rows: ");
	    	while(true)
	    	{
	    		try {
	    			rows = sc.nextInt();
	    			if(rows<=0) {
	    				System.out.print("No of rows can be greater than 0 only.");
	    			}
	    			else {
	    				break;
	    			}
	    		} catch(InputMismatchException e) {
	    			System.out.print("Enter valid number please.");
	    			sc.next();
	    		}
	    	}
	    	PascalTriangle(rows);
	        sc.close();
	    }
	

}
