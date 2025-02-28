
public class Staff implements Person {

    private String name;
    private String address;
    private String school;
    private double pay;

    public Staff(String name, String address, String school, double pay) {
        this.name = name;
        this.address = address;
        this.school = school;
        this.pay = pay;
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

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public double getPay() {
        return pay;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }

    @Override
    public String toString() {
        return "Staff[Person[name=" + name + ",address=" + address + "],school=" + school + ",pay=" + pay + "]";
    }
}
