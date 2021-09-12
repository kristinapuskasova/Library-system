package Book;

import java.io.IOException;
import java.util.Scanner;

public class ForeignBook extends Book {

    private String language;

    public ForeignBook() throws IOException {
        super();
        System.out.print("Language: ");
        Scanner scanner = new Scanner(System.in);
        this.language = scanner.nextLine();

    }

    public ForeignBook(String title, String author, int pageCount, String language) {
        super(title, author, pageCount);
        this.language = language;
    }

    @Override
    public String toString() {
        String s;
        if (this.isBorrowed() == false) {
            s = "Title: " + this.getTitle() + "\nAuthor: " + this.getAuthor() + "\nPage Count: " + this.getPageCount() + "\nStatus: Currently available" + "\nLanguage: " + this.language;
        } else {
            s = "Title: " + this.getTitle() + "\nAuthor: " + this.getAuthor() + "\nPage Count: " + this.getPageCount() + "\nStatus: Currently unavailable" + "\nLanguage: " + this.language;
        }
        return s;
    }
}