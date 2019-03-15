import java.util.Scanner;

public class Rectangle {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
	

		System.out.print (" Enter the width : ");
		double width = keyboard.nextDouble();

		System.out.print (" Enter the length : ");
		double length = keyboard.nextDouble();
		
		double area = width * length;
		double perimeter = 2 * (width + length);
		
		System.out.printf("width = %8.2f  ", width );
		System.out.printf("length = %8.2f  " , length);
		System.out.printf("Area = %8.2f  ", area);
		System.out.printf("Perimeter = %8.2f  ", perimeter);
		
	}   }