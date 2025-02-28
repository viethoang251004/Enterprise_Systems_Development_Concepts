public class Test {
    public static void main(String args[]) {
        Book x = new Book("Java Programming");
        System.out.println(x.getTitle());

        Book y = new Book(x);
        System.out.println(y.getTitle());

        y.setTitle("C Programming");
        System.out.println(y.getTitle());

        System.out.println(x.getTitle());

    }
}
// Invoice item thì chỉ biểu diễn 1 item còn muốn biểu diễn nhiều item thì dùng mảng