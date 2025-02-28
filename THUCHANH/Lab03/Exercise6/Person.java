import java.io.Serializable;

public class Person implements Serializable {
    private String surname;
    private double pctwhite;
    private int count;

    public Person(String surname, double pctwhite, int count) {
        this.surname = surname;
        this.pctwhite = pctwhite;
        this.count = count;
    }

    public String getSurname() {
        return surname;
    }

    public double getPctwhite() {
        return pctwhite;
    }

    public int getCount() {
        return count;
    }
}
