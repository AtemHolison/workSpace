

import java.util.Scanner;

public class Nested {
	static Scanner x = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("Enter age :" );
		int age = GetLength();
		System.out.println("You entered " + age);
	}
		
		public static int GetLength() {
			
				
				
				int i=2;
				int [] age = new int[i];
				while(age.length >= 2 ) {
					try {
				
					return x.nextInt();
				
			} catch (ArrayIndexOutOfBoundsException e) {
				x.next();
				System.out.println("Array length too long ");
			} finally {
				System.out.println("Finally");
			}
		
	}
				return age.length;
				
				
				
}}
