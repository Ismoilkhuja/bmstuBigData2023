public class Main {
    public static void main(String[] args) {
        Reader reader1 = new Reader("Иванов");
        Reader reader2 = new Reader("Петров");
        Reader reader3 = new Reader("Сидоров");

        Book book1 = new Book("War and Peace", "Lev Tolstoy");
        Book book2 = new Book("The C Programming Language", "Brian Kernighan");
        Book book3 = new Book("Test Driven Development for Embedded C", "James Grenning");

        Library library = new Library();

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        library.addReader(reader1);
        library.addReader(reader2);
        library.addReader(reader3);

        library.orderBook(reader1, book3);

        library.addToBlackList(reader3);
    }
}