package day4_livecoding.class_problems;

public class LibraryBook {
    private String title;
    private String isbn;
    private boolean isCatalogued;

    public LibraryBook(String title, String isbn) {
        this.title = title;
        if (isbn == null || isbn.trim().isEmpty()) {
            this.isbn = "PENDING";
        } else {
            this.isbn = isbn;
        }
        this.isCatalogued = true;
    }

    public LibraryBook(String title) {
        this(title, "PENDING");
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isCatalogued() {
        return isCatalogued;
    }

    public void printEntry() {
        System.out.println(title + " | " + isbn + " | Catalogued: " + isCatalogued);
    }

    public static void main(String[] args) {
        String[] titles = {"Clean Code", "Untitled Draft", "1984", "Notes"};
        String[] isbns = {"978-0132350884", "", "9780451524935", ""};

        for (int i = 0; i < titles.length; i++) {
            LibraryBook book = new LibraryBook(titles[i], isbns[i]);
            book.printEntry();
        }
    }
}