import java.util.ArrayList;
import java.util.Scanner;

/*•	The user can enter any of the following categories to display the films in the list that match the category:
 animated
 drama
 horror
 scifi
 */
public class MovieApp {

	private static ArrayList<Movie> movieCatalog = new ArrayList<Movie>();

	public static void main(String[] args) {

		// display a welcome message
		System.out.println("Welcome to the Movie List Application.\n");
		System.out.println("There are 100 movies in the list.\n");
		// create the Scanner object
		Scanner sc = new Scanner(System.in);
		
		for (int i = 1; i < 100; i++) {
			
			movieCatalog.add(MovieIO.getMovie(i));
		}
		// perform conversions until choice isn't equal to "y" or "Y"
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			// get an int from the user
			System.out.print("What category are you interested in?: ");
			String categoryIn = sc.next();
			System.out.println();
			System.out.println("You Entered " + categoryIn + "\n");
			searchMovies(categoryIn);
			// see if the user wants to continue
			System.out.println();
			System.out.print("Continue? (y/n): ");
			choice = sc.next();
			System.out.println();
		}
		sc.close();
	}

	private static void searchMovies(String categoryIn) {

		for (Movie theMovie : movieCatalog) {
			if (theMovie.category.equalsIgnoreCase(categoryIn))
				System.out.println(theMovie.title);
		}
	}
}
