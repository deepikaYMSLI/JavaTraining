package assignment1;

public class Question1 {

	public static void main(String[] args) {
		int n= 20;
		int fibArr[]= new int[n];
		fibArr[0]=1;
		fibArr[1]=1;
		int sum=2;
		System.out.print("The elements are: ");
		System.out.print( fibArr[0]+", " + fibArr[1]);
		for(int i=2; i<n; i++) {
			fibArr[i]= fibArr[i-1] + fibArr[i-2];
			System.out.print( ", " +fibArr[i]);
			sum+=fibArr[i];
		}
		System.out.println();
		System.out.println("Average is: " +sum/20);
		
		
		

	}

}
