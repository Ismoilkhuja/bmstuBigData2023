import java.util.ArrayList;
import java.util.Date;

public class ArtExhibition {
    private String name;
    private ArrayList<Painting> paintings;
//    private ArrayList<String> authors;
    private Date date;

    public ArtExhibition(String name, Date date) {
        this.name = name;
        this.date = date;
        this.paintings = new ArrayList<>();
//        this.authors = new ArrayList<>();
    }

    public void addPainting(Painting painting) {
        paintings.add(painting);
//        authors.add(author);
    }

    public void showExhibitionInfo() {
        System.out.println("Name: " + name);
        System.out.println("Date: " + date);
        System.out.println("Paintings: ");
        for (int i = 0; i < paintings.size(); i++) {
            System.out.println(paintings.get(i).getTitle() + " by " + paintings.get(i).getAuthor());
        }
    }

    public class Painting {

        private String title;
        private int year;

        private String author;
        public Painting(String title, int year, String author) {
            this.title = title;
            this.year = year;
            this.author = author;
        }

        public String getTitle() {
            return title;
        }

        public int getYear() {
            return year;
        }

        public String getAuthor() {
            return author;
        }
    }
}
