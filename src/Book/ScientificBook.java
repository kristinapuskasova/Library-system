package Book;

import java.io.IOException;
import java.util.Scanner;

public class ScientificBook extends Book {

    private String scientificField;

    public ScientificBook() throws IOException {
        super();
        System.out.print("Scientific field: ");
        Scanner scanner = new Scanner(System.in);
        this.scientificField = scanner.nextLine();
    }

    public ScientificBook(String title, String author, int pageCount, String scientificField) {
        super(title, author, pageCount);
        this.scientificField = scientificField;
    }

    @Override
    public String toString() {
        String s = "Title: " + this.getTitle() + "\nAuthor: " + this.getAuthor() + "\nPage Count: " + this.getPageCount() + "\nScientific Field: " + this.scientificField;
        return s;
    }

}
