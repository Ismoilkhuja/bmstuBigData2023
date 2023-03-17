import java.util.ArrayList;
import java.util.List;

public class Reader {
    private String name;
    List<Book> books = new ArrayList<>();

    public Reader(String name){
        this.name = name;
    }

    public void giveBook(Book book){
        books.add(book);
    }
}
