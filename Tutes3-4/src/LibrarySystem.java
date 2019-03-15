
public class LibrarySystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book b1 = new Book("B001", "Divergent", "Veronica Roth");
		Book b2 = new Book("B002", "Green Eggs and Ham", "Dr seuss");

		System.out.printf("%s - %s\n", b1.getBookID(), b1.getTitle());
	
		System.out.printf("%s - %s\n", b2.getBookID(), b2.getTitle());

		String memID = "m1234";
		boolean res;
		
		res = b1.borrow("memID");
		
		if(res) {
			
			System.out.println("borrow worked");
		}
		
		System.out.printf("Book %s\n", b1.returnBook() ? "returned" : "not on loan");
		
		System.out.println(b1.toString());
		System.out.println(b2);
		
	}

}
