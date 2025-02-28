
public class Student implements Person {

    private String name;
    private String address;
    private String program;
    private int year;
    private double fee;

    public Student(String name, String address, String program, int year, double fee) {
        this.name = name;
        this.address = address;
        this.program = program;
        this.year = year;
        this.fee = fee;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String getAddress() {
        return address;
    }
    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }
    @Override
    public String toString() {
        return "Student[Person[name=" + name + ",address=" + address + "],program=" + program + ",year=" + year + ",fee=" + fee + "]";
    }
}
