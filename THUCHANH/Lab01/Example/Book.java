public class Book {
    private String title;

    public Book() {
        this.title = "";
    }

    public Book(String title) {
        this.title = title;
    }
    
    public Book(Book b) {
        this.title = b.title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}