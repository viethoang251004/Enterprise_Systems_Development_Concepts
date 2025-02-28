public class Account {
    private String id;
    private String name;
    private int balance = 0;

    public Account(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Account(String id, String name, int balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public String getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public int credit(int amount) {
        balance += amount;
        return balance;
    }

    public int debit(int amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Amount exceeded balance");
        }
        return balance;
    }

    public int transferTo(Account another, int amount) {
        if (amount <= balance) {
            this.balance -= amount;
            another.credit(amount);
        } else {
            System.out.println("Amount exceeded balance");
        }
        return balance;
    }

    @Override
    public String toString() {
        return "Account[id=" + id + ", name=" + name + ", balance=" + balance + "]";
    }
    // // Main method to test the class functionality
    // public static void main(String[] args) {
    //     Account account1 = new Account("A001", "Alice", 500);
    //     Account account2 = new Account("A002", "Bob", 300);
    //     System.out.println(account1);  // Account[id=A001, name=Alice, balance=500]
    //     account1.credit(200);
    //     System.out.println(account1);  // Account[id=A001, name=Alice, balance=700]
    //     account1.debit(150);
    //     System.out.println(account1);  // Account[id=A001, name=Alice, balance=550]
    //     account1.transferTo(account2, 100);
    //     System.out.println(account1);  // Account[id=A001, name=Alice, balance=450]
    //     System.out.println(account2);  // Account[id=A002, name=Bob, balance=400]
    // }
}
