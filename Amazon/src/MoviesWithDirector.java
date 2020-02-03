public class MoviesWithDirector extends Movie{
    protected String director;

    public MoviesWithDirector(long productId, int price, String title, MovieGenre genre, String director) {
        super(productId, price, title, genre);
        this.director = director;
    }
    public String getDirector() {
        return director;
    }
    @Override
    public void printDetails() {
      super.printDetails();
        System.out.println(" Director: " + this.director);

    }
}
