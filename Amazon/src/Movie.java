import java.util.List;

public class Movie implements Product, Comparable<Movie> {
    public enum MovieGenre {
        DRAMA,
        COMEDY,
        ACTION,
        DOCUMENTARY,
    }

    protected String title;
    protected MovieGenre genre;
    protected long productId;
    protected int price;

    public Movie(long productId, int price, String title, MovieGenre genre) {
        this.productId = productId;
        this.price = price;
        //super(productId, price);
        this.title = title;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public MovieGenre getGenre() {
        return genre;
    }

    @Override
    public void printDetails() {
        System.out.println("title: " + title);
        System.out.println("genre: " + genre);
        System.out.println("price: " + price);
        System.out.println("productId: " + productId);
        System.out.println("");
    }

    @Override
    public int compareTo(Movie movie) {
        if (this.productId == movie.productId) {
            return 0;
        }
        else if (this.productId < movie.productId) {
            return -1;
        }
        return 1;
    }
}

