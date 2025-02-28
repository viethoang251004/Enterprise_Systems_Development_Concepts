
public class Book {

    private String name;
    private Author[] authors;
    private double price;
    private int qty = 0;

    public Book(String name, Author[] authors, double price) {
        this.name = name;
        this.authors = authors;
        this.price = price;
    }

    public Book(String name, Author[] authors, double price, int qty) {
        this.name = name;
        this.authors = authors;
        this.price = price;
        this.qty = qty;
    }

    public String getName() {
        return name;
    }

    public Author[] getAuthors() {
        return authors;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    //toString method to return the required string format
    @Override
    public String toString() {
        StringBuilder authorsStr = new StringBuilder();
        for (int i = 0; i < authors.length; i++) {
            authorsStr.append(authors[i].toString());
            if (i != authors.length - 1) {
                authorsStr.append(",");
            }
        }
        return "Book[name=" + name + ",authors={" + authorsStr.toString() + "},price=" + price + ",qty=" + qty + "]";
    }

    //get author names as a string
    public String getAuthorNames() {
        StringBuilder authorNames = new StringBuilder();
        for (int i = 0; i < authors.length; i++) {
            authorNames.append(authors[i].getName());
            if (i != authors.length - 1) {
                authorNames.append(",");
            }
        }
        return authorNames.toString();
    }
}
