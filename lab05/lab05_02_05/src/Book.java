import java.util.Arrays;
import java.util.Random;

public class Book {
    private long id;
    private String title;
    private String[] authors;
    private String pubHouse;
    private int year;
    private int pagesNum;
    private int price;
    private String binding;
    private static long counter;

    public Book(){

    }

    public Book(String title, String[] authors, String pubHouse, int year, int pagesNum, int price, String binding) {
        this.id = nextId();
        this.title = title;
        this.authors = authors;
        this.pubHouse = pubHouse;
        this.year = year;
        this.pagesNum = pagesNum;
        this.price = price;
        this.binding = binding;
    }

    public Book(String title, String[] authors, String pubHouse) {
        this.id = nextId();
        this.title = title;
        this.authors = authors;
        this.pubHouse = pubHouse;

        Random rand = new Random();

        this.year = rand.nextInt(120) + 1900;
        this.pagesNum = rand.nextInt(200) + 100;
        this.price = rand.nextInt(1000) + 500;
        this.binding = rand.nextBoolean() ? "soft" : "hard";
    }

    private long nextId(){
        return ++counter;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", autors=" + Arrays.toString(authors) +
                ", pubHouse='" + pubHouse + '\'' +
                ", year=" + year +
                ", pagesNum=" + pagesNum +
                ", price=" + price +
                ", binding='" + binding + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public String[] getAuthors() {
        return authors;
    }

    public String getPubHouse() {
        return pubHouse;
    }

    public int getYear() {
        return year;
    }

    public int getPagesNum() {
        return pagesNum;
    }

    public int getPrice() {
        return price;
    }

    public String getBinding() {
        return binding;
    }

    public boolean hasAuthor(String author) throws AuthorException{
        if (author.equals("")){
            throw new AuthorException("Ошибка: Название автора пустой.");
        }

        for (String auth : authors) {
            if (auth.equals(author))
                return true;
        }

        return false;
    }

}
