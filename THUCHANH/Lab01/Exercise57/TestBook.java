
public class TestBook {

    public static void main(String[] args) {
        Author author1 = new Author("J.K. Rowling", "jkrowling@example.com", 'f');
        Author author2 = new Author("Stephen King", "sking@example.com", 'm');

        Author[] authors = {author1, author2};
        Book book1 = new Book("The Wizard and the Horror", authors, 29.99, 10);
        //test the toString method of the Book class
        System.out.println(book1.toString());
        //test the getAuthorNames method of the Book class
        System.out.println("Author Names: " + book1.getAuthorNames());
    }
}
