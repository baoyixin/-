import customer.Customer;
import movie.Movie;
import rental.Rental;

public class ChongGouMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Movie movie1 = new Movie("少年的你" , 1);
		Movie movie2 = new Movie("冰雪奇缘" , 2);
		Movie movie3 = new Movie("家有喜事" , 0);
		
		Rental rental1 = new Rental(movie1 , 3);
		Rental rental2 = new Rental(movie2,4);
		Rental rental3 = new Rental(movie3,2);
		 
		Customer customer = new Customer("顾客小李");
		
		customer.addRental(rental1);
		customer.addRental(rental2);
		customer.addRental(rental3);
		System.out.println("打印单："+ customer.statement());
		
	}

}
