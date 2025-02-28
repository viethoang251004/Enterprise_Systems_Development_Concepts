// import java.io.Serializable;
// public class Employee implements Serializable {
//     private static final long serialVersionUID = 1L;
//     private String name;
//     private int id;
//     public Employee(String name, int id) {
//         this.name = name;
//         this.id = id;
//     }
//     public void printEmployeeInfo() {
//         System.out.println("Employee -> Name: " + name + ", ID: " + id);
//     }
// }


import java.io.Serializable;
//Modified Employee class with an additional field
public class Employee implements Serializable {
    private static final long serialVersionUID = 1L; //Keeping the same serialVersionUID for compatibility
    private String name;
    private int id;
    private String department; //New field

    public Employee(String name, int id, String department) {
        this.name = name;
        this.id = id;
        this.department = department;// Assign value to new field
    }
    public void printEmployeeInfo() {
        System.out.println("Employee -> Name: " + name + ", ID: " + id + ", Department: " + department);
    }
}
