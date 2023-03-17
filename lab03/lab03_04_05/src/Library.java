import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books = new ArrayList<>();
    private List<Reader> readers = new ArrayList<>();

    private List<Reader> blockList = new ArrayList<>();

    public void addBook(Book book){
        books.add(book);
    }

    public void addReader(Reader reader){
        readers.add(reader);
    }

    public boolean orderBook(Reader reader, Book book){
        if (blockList.contains(reader))
            return false;

        if (books.contains(book)){
            books.remove(book);
            reader.giveBook(book);
            return true;
        }
        return false;
    }

    public void addToBlackList(Reader reader){
        blockList.add(reader);
    }
}
