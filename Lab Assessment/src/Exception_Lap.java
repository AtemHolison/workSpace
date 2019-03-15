import java.util.InputMismatchException;
import java.util.Scanner;

public class Exception_Lap {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Enter an integer: ");
		int i = GetAnInteger();
		System.out.println("You entered " + i);
	}

	public static int GetAnInteger()  {
		while (true) {
			try {
				return sc.nextInt();
			} catch (InputMismatchException e) {
				sc.next();
				System.out.print("That’s not " + "an integer. Try again: ");
			}
		}
	}
}
