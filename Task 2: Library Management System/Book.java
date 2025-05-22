public class Book {
    private int id;
    private String title;
    private String author;
    private String genre;
    private int year;
    private boolean isIssued;

    public Book(int id, String title, String author, String genre, int year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.year = year;
        this.isIssued = false;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isIssued() {
        return isIssued;
    }

    public void issueBook() {
        isIssued = true;
    }

    public void returnBook() {
        isIssued = false;
    }

    public String toString() {
        return "ID: " + id +
               "\nTitle: " + title +
               "\nAuthor: " + author +
               "\nGenre: " + genre +
               "\nYear: " + year +
               "\nIssued: " + (isIssued ? "Yes" : "No") +
               "\n";
    }
}
