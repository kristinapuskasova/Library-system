package Book;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Book {

    public Book() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Title: ");
            this.title = reader.readLine();
        System.out.print("Author: ");
            this.author = reader.readLine();
        System.out.print("Page count: ");
            this.pageCount = Integer.parseInt(reader.readLine());
    }

    public Book(String title, String author, int pageCount) {
        this.title = title;
        this.author = author;
        this.pageCount = pageCount;
    }

    private int pageCount;
    private String author;
    private String title;



    public int getPageCount() {
        return pageCount;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        String s = "Title: " + this.title + "\nAuthor: " + this.author + "\nPage Count: " + this.pageCount;
        return s;
    }
}
