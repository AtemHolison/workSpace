import java.util.Scanner;

public class Revision {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		System.out.print("How many keywords will be used ?");
		int input = keyboard.nextInt();

		while (input <= 0) {
			System.out.println("Re-Enter");
			input = keyboard.nextInt();
		}

		String[] keys = new String[input];

		String[] target = { "money", "cars", "house", "drinks", "food" };

		int i = 0;
		while (i < input) {
			System.out.println("Enter Keywords : ");
			keys[i] = keyboard.nextLine(); 
		
			int j = 0;
			while (j < target.length) {
				if (target[j].equals(keys[i])) {
					System.out.println(keys[i]);
					i++;
					j = target.length;
				} 
				
			else {
					j++;
					if (j == target.length) {
						System.out.println("Wrong word, Please Enter Again");
					}
				}

			}

		}
	}}

