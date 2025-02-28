import java.io.Serializable;
import java.util.Arrays;

public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String name;
    private int id;
    private int[] testScores;

    public Student(String name, int id, int[] testScores) {
        this.name = name;
        this.id = id;
        this.testScores = testScores;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int[] getTestScores() {
        return testScores;
    }

    public void printInfo() {
        System.out.println("Name: " + this.name);
        System.out.println("ID: " + this.id);
        System.out.println("Test Scores: " + Arrays.toString(this.testScores));
    }
}
