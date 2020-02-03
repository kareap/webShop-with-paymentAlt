import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Book implements Product{
    private final String title;
    private final String author;
    protected long productId;
    protected int price;

    public Book(long productId, int price, String title, String author) { //kontruktør
        this.productId = productId;
        this.price = price;
        //super(productId, price);
        this.title = title;
        this.author = author;

    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public void printDetails() {
        System.out.println("title: " + getTitle());
        System.out.println("author: " + getAuthor());
        System.out.println("price: " + price);
        System.out.println("");
    }

    @Override
    public String toString() {
        return "Title: " + getTitle() + '\'' +
                "Author: " + getAuthor() + '\'' +
                "Price: " + price;
    }
}



