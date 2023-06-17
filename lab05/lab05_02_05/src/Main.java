public class Main {
    public static void main(String[] args) {

        String[] tmp1 = {"Lev Toolstoy"};
        String[] tmp2 = {"Adam"};


        Book[] books = {
                new Book("War and Peace", tmp1, "ASD"),
                new Book("Heroes of War", tmp1, "ADB"),
                new Book("World", tmp2, "ASD")
        };

        // список всех книг
        System.out.println("Список всех книг");
        for (Book book : books) System.out.println(book);
        System.out.println();

        // список книг заданного автора
        System.out.println("Список книг заданного автора:");
        String author = "Adam";
        for (Book book : books) {

            try {
                if (book.hasAuthor(author))
                    System.out.println(book);
            } catch (AuthorException e) {
                e.printStackTrace();
            }
        }
        System.out.println();

        // список книг, выпущенных заданным издательством
        System.out.println("Список книг, выпущенных заданным издательством");
        String pubHouse = "ASD";
        for (Book book : books) {
            if (book.getPubHouse().equals(pubHouse))
                System.out.println(book);
        }
        System.out.println();

        // список книг, выпущенных после заданного года.
        System.out.println("Список книг, выпущенных после заданного года: ");
        int year = 1940;
        for (Book book : books) {
            if (book.getYear() > year)
                System.out.println(book);
        }
        System.out.println();



        Book as = new Book();

        try {
            as.hasAuthor("");
        } catch (AuthorException e) {
            e.printStackTrace();
        }


        /*
        as = null
         */




    }
}