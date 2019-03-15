import java.util.Scanner;

public class Class_Scores {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
	
		
		System.out.print (" Mark 1 is : ");
		double mark1 = keyboard.nextDouble();

		System.out.print (" Mark 2 is : ");
		double mark2 = keyboard.nextDouble();

		System.out.print (" Mark 3 is : ");
		double mark3 = keyboard.nextDouble();
		
		double average = (mark1+mark2+mark3)/3;
		double maxMark1 = (Math.max(mark1, mark2));
		double maxMark_Final = (Math.max(maxMark1, mark3));
		
		double minMark1 = (Math.min(mark1, mark2));
		double minMark_Final = (Math.min(minMark1, mark3));

		System.out.println( " Minimum mark is:"+ minMark_Final);
		System.out.println( " Average mark is:"+ average);
		System.out.print( " Maximum mark is:"+ maxMark_Final);
	}   }
