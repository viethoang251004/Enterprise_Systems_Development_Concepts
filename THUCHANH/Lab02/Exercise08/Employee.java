import java.io.Serializable;

public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private double salary;
    private transient String password; // transient field

    public Employee(String name, double salary, String password) {
        this.name = name;
        this.salary = salary;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public String getPassword() {
        return password;
    }

    public void printInfo() {
        System.out.println("Employee -> Name: " + name + ", Salary: " + salary + ", Password: " + password);
    }
}
