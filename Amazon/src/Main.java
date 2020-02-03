import javax.swing.*;
import java.util.*;

public class Main {

    static List<Product> products = new ArrayList<>();

    public static void main(String[] args) {
        products.add(new Book(873648723L, 100, "The art of happiness", "Dalai Lama"));
        products.add(new Book(892834729L, 399, "Origin", "Dan Brown"));
        products.add(new Book(289376491L,400,"Pippi", "Astrid Lindgren"));
        products.add(new ChildrensBook(289376495, 100, "godnatt", "Astri Andersen", "Anbefalt alder 5år"));
        products.add(new Movie(4654654654309L, 300, "Mission impossible", Movie.MovieGenre.ACTION));
        products.add(new Movie(4654654654302L, 200, "Hangover", Movie.MovieGenre.COMEDY));
        products.add(new Movie(4654654654307L, 200, "Hangover2", Movie.MovieGenre.COMEDY));
        products.add(new MoviesWithDirector(4654654654303L, 299, "Harry Potter", Movie.MovieGenre.DRAMA, "David Yates"));

        List<Movie> movies = new ArrayList<>();
        products.addAll(movies);
        Collections.sort(movies);
        //Comparable er et interface som tvinger klasser som implementerer det til å implementere metoden compareTo.

        for (Product theProduct : products) {
           theProduct.printDetails();
        }

        long searchId = 4654654654303L;

    }
    private static Movie findMovieById(long productId, List<Movie> movies) {
        for (Movie theMovie : movies) {
            if (theMovie.productId == productId) {
                return theMovie;
            }
        }
        return null;
    }
}




