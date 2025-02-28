// DO NOT USE PACKAGE

import java.io.*;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashSet;
public class StudentManagementImpl implements StudentManagement {
    ArrayList<Student> students;
    public StudentManagementImpl() {
        this.students = new ArrayList<>();
    }
    public StudentManagementImpl(String dataPath) {
        this.students = new ArrayList<>();
        readData(dataPath);
    }
    private void readData(String filePath) {
        try {
            File file = new File(filePath);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String readLine;
            while ((readLine = br.readLine()) != null) {
                // Insert your code here ...
                String[] info = readLine.split("\t");
                Student s = new Student(info[0], info[1], info[2], Double.parseDouble(info[3]), info[4]);
                this.students.add(s);
            }
            br.close();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
    @Override
    public int getNoOfStudent() throws RemoteException {
        // Insert your code here ...
        return students.size();
        // return -1;
    }
    @Override
    public int getNoOfStudent_byGender(String gender) throws RemoteException {
        // Insert your code here ...
        int count = 0;
        for (Student s : students) {
            if (s.getGender().equalsIgnoreCase(gender)) {
                count++;
            }
        }
        return count;
    }
    @Override
    public int getNoOfStudent_byMajor(String major) throws RemoteException {
        // Insert your code here ...
        int count = 0;
        for (Student s : students) {
            if (s.getMajor().equalsIgnoreCase(major)) {
                count++;
            }
        }
        return count;
    }
    @Override
    public int getNoOfStudent_byGPA(double gpa) throws RemoteException {
        // Insert your code here ...
        int count = 0;
        for (Student s : students) {
            if (s.getGpa() < gpa) {
                count++;
            }
        }
        return count;
    }
    @Override
    public Student findStudent_byName(String name) throws RemoteException {
        // Insert your code here ...
        for (Student s : students) {
            if (s.getName().equalsIgnoreCase(name)) {
                return s;
            }
        }
        return null;
    }
    @Override
    public Student findStudent_byID(String id) throws RemoteException {
        // Insert your code here ...
        for (Student s : students) {
            if (s.getId().equalsIgnoreCase(id)) {
                return s;
            }
        }
        return null;
    }
    @Override
    public ArrayList<Student> findStudent_byMajor(String major) throws RemoteException {
        // Insert your code here ...
        ArrayList<Student> result = new ArrayList<>();
        for (Student s : students) {
            if (s.getMajor().equalsIgnoreCase(major)) {
                result.add(s);
            }
        }
        return result;
    }
    @Override
    public ArrayList<Student> findStudent_byGPA(double GPA) throws RemoteException {
        // Insert your code here ...
        ArrayList<Student> result = new ArrayList<>();
        for (Student s : students) {
            if (s.getGpa() < GPA) {
                result.add(s);
            }
        }
        return result;
    }
    @Override
    public double getAvgGPA() throws RemoteException {
        // Insert your code here ...
        if (students.isEmpty()) {
            return 0;
        }
        double totalGPA = 0;
        for (Student s : students) {
            totalGPA += s.getGpa();
        }
        return totalGPA / students.size();
    }
    @Override
    public Student getHighestGPA_byGender(String gender) throws RemoteException {
        // Insert your code here ...
        Student highest = null;
        for (Student s : students) {
            if (s.getGender().equalsIgnoreCase(gender)) {
                if (highest == null || s.getGpa() > highest.getGpa()) {
                    highest = s;
                }
            }
        }
        return highest;
    }
    @Override
    public Student getHighestGPA_byFName(String fname) throws RemoteException {
        // return null;
        Student highest = null;
        for (Student s : students) {
            String firstName = s.getName().split(" ")[0]; // Giả định tên đầu là first name
            if (firstName.equalsIgnoreCase(fname)) {
                if (highest == null || s.getGpa() > highest.getGpa()) {
                    highest = s;
                }
            }
        }
        return highest;
    }
    @Override
    public Student getHighestGPA_byLName(String lname) throws RemoteException {
        // Insert your code here ...
        Student highest = null;
        for (Student s : students) {
            String lastName = s.getName().split(" ")[s.getName().split(" ").length - 1]; // Giả định tên cuối là last name
            if (lastName.equalsIgnoreCase(lname)) {
                if (highest == null || s.getGpa() > highest.getGpa()) {
                    highest = s;
                }
            }
        }
        return highest;
    }
    @Override
    public Student getHighestGPA_byMajor(String major) throws RemoteException {
        // Insert your code here ...
        Student highest = null;
        for (Student s : students) {
            if (s.getMajor().equalsIgnoreCase(major)) {
                if (highest == null || s.getGpa() > highest.getGpa()) {
                    highest = s;
                }
            }
        }
        return highest;
    }
    @Override
    public Student getLowestGPA_byMajor(String major) throws RemoteException {
        // Insert your code here ...
        Student lowest = null;
        for (Student s : students) {
            if (s.getMajor().equalsIgnoreCase(major)) {
                if (lowest == null || s.getGpa() < lowest.getGpa()) {
                    lowest = s;
                }
            }
        }
        return lowest;
    }
    @Override
    public ArrayList<Student> getTop10_byGPA() throws RemoteException {
        // Insert your code here ...
        students.sort((s1, s2) -> Double.compare(s2.getGpa(), s1.getGpa())); // Sắp xếp theo GPA giảm dần
        ArrayList<Student> top10 = new ArrayList<>();
        for (int i = 0; i < Math.min(10, students.size()); i++) {
            top10.add(students.get(i));
        }
        return top10;
    }
    @Override
    public ArrayList<Student> getTop10GPA_byGender(String gender) throws RemoteException {
        // Insert your code here ...
        ArrayList<Student> genderFiltered = new ArrayList<>();
        for (Student s : students) {
            if (s.getGender().equalsIgnoreCase(gender)) {
                genderFiltered.add(s);
            }
        }
        genderFiltered.sort((s1, s2) -> Double.compare(s2.getGpa(), s1.getGpa())); // Sắp xếp theo GPA giảm dần
        ArrayList<Student> top10 = new ArrayList<>();
        for (int i = 0; i < Math.min(10, genderFiltered.size()); i++) {
            top10.add(genderFiltered.get(i));
        }
        return top10;
    }
    @Override
    public ArrayList<Student> getTop10GPA_byMajor(String major) throws RemoteException {
        // Insert your code here ...
        ArrayList<Student> majorFiltered = new ArrayList<>();
        for (Student s : students) {
            if (s.getMajor().equalsIgnoreCase(major)) {
                majorFiltered.add(s);
            }
        }
        majorFiltered.sort((s1, s2) -> Double.compare(s2.getGpa(), s1.getGpa())); // Sắp xếp theo GPA giảm dần
        ArrayList<Student> top10 = new ArrayList<>();
        for (int i = 0; i < Math.min(10, majorFiltered.size()); i++) {
            top10.add(majorFiltered.get(i));
        }
        return top10;
    }
    @Override
    public ArrayList<Student> getLast10GPA_byGender(String gender) throws RemoteException {
        // Insert your code here ...
        ArrayList<Student> genderFiltered = new ArrayList<>();
        for (Student s : students) {
            if (s.getGender().equalsIgnoreCase(gender)) {
                genderFiltered.add(s);
            }
        }
        genderFiltered.sort((s1, s2) -> Double.compare(s1.getGpa(), s2.getGpa())); // Sắp xếp theo GPA tăng dần
        ArrayList<Student> last10 = new ArrayList<>();
        for (int i = 0; i < Math.min(10, genderFiltered.size()); i++) {
            last10.add(genderFiltered.get(i));
        }
        return last10;
    }
    @Override
    public ArrayList<Student> getLast10GPA_byMajor(String major) throws RemoteException {
        // Insert your code here ...
        // Lọc sinh viên theo ngành học
        ArrayList<Student> majorFiltered = new ArrayList<>();
        for (Student s : students) {
            if (s.getMajor().equalsIgnoreCase(major)) {
                majorFiltered.add(s);
            }
        }
        // Sắp xếp danh sách sinh viên theo GPA tăng dần
        majorFiltered.sort((s1, s2) -> Double.compare(s1.getGpa(), s2.getGpa()));
        // Lấy danh sách Last10 sinh viên có GPA thấp nhất
        ArrayList<Student> last10 = new ArrayList<>();
        for (int i = 0; i < Math.min(10, majorFiltered.size()); i++) {
            last10.add(majorFiltered.get(i));
        }
        return last10;
    }
    @Override
    public ArrayList<String> getMajors() throws RemoteException {
        // Sử dụng HashSet để loại bỏ các giá trị trùng nhau
        HashSet<String> majorSet = new HashSet<>();
        for (Student s : students) {
            majorSet.add(s.getMajor());
        }
        // Chuyển HashSet thành ArrayList để trả về
        return new ArrayList<>(majorSet);
    }
}




// import java.io.*;
// import java.lang.reflect.Array;
// import java.rmi.RemoteException;
// import java.util.ArrayList;
// import java.util.HashSet;

// public class StudentManagementImpl implements StudentManagement {

//     ArrayList<Student> students;

//     public StudentManagementImpl() {
//         this.students = new ArrayList<>();
//     }

//     public StudentManagementImpl(String dataPath) {
//         this.students = new ArrayList<>();
//         readData(dataPath);
//     }

//     private void readData(String filePath) {
//         try {
//             File file = new File(filePath);
//             BufferedReader br = new BufferedReader(new FileReader(file));

//             String readLine;
//             while ((readLine = br.readLine()) != null) {
//                 // Insert your code here...
//                 String[] info = readLine.split("\t");
//                 Student s = new Student(info[0], info[1], info[2], Double.parseDouble(info[3]), info[4]);
//                 this.students.add(s);
//             }
//         } catch (Exception e) {
//             System.err.println(e.getMessage());
//         }
//     }

//     public int getNoOfStudent() throws RemoteException {
//         // Insert your code here ...
//         return students.size();
//     }

//     public int getNoOfStudent_byGender(String gender) throws RemoteException {
//         // Insert your code here ...
//         int count = 0;
//         for (Student s : students) {
//             if (s.getGender().equalsIgnoreCase(gender)) {
//                 count++;
//             }
//         }
//         return count;
//     }

//     public int getNoOfStudent_byMajor(String major) throws RemoteException {
//         // Insert your code here ...
//         int count = 0;
//         for (Student s : students) {
//             if (s.getMajor().equalsIgnoreCase(major)) {
//                 count++;
//             }
//         }
//         return count;
//     }

//     public int getNoOfStudent_byGPA(double gpa) throws RemoteException {
//         // Insert your code here ...
//         int count = 0;
//         for (Student s : students) {
//             if (s.getGpa() < gpa) {
//                 count++;
//             }
//         }
//         return count;
//     }

//     public Student findStudent_byName(String name) throws RemoteException {
//         // Insert your code here ...
//         for (Student s : students) {
//             if (s.getName().equalsIgnoreCase(name)) {
//                 return s;
//             }
//         }
//         return null;
//     }

//     public Student findStudent_byID(String id) throws RemoteException {
//         for (Student s : students) {
//             if (s.getId().equalsIgnoreCase(id)) {
//                 return s;
//             }
//         }
//         return null;
//     }

//     public ArrayList<Student> findStudent_byMajor(String major) throws RemoteException {
//         ArrayList<Student> result = new ArrayList<>();
//         for (Student s : students) {
//             if (s.getMajor().equalsIgnoreCase(major)) {
//                 result.add(s);
//             }
//         }
//         return result;
//     }

//     public ArrayList<Student> findStudent_byGPA(double GPA) throws RemoteException {
//         ArrayList<Student> result = new ArrayList<>();
//         for (Student s : students) {
//             if (s.getGpa() < GPA) {
//                 result.add(s);
//             }
//         }
//         return result;
//     }

//     public double getAvgGPA() throws RemoteException {
//         if (students.isEmpty()) {
//             return 0;
//         }
//         double totalGPA = 0;
//         for (Student s : students) {
//             totalGPA += s.getGpa();
//         }
//         return totalGPA / students.size();
//     }

//     public Student getHighestGPA_byGender(String gender) throws RemoteException {
//         Student highest = null;
//         for (Student s : students) {
//             if (s.getGender().equalsIgnoreCase(gender)) {
//                 if (highest == null || s.getGpa() > highest.getGpa()) {
//                     highest = s;
//                 }
//             }
//         }
//         return highest;
//     }

//     public Student getHighestGPA_byFName(String fname) throws RemoteException {
//         Student highest = null;
//         for (Student s : students) {
//             String firstName = s.getName().split(" ")[0]; //Giả định tên đầu là first name
//             if (firstName.equalsIgnoreCase(fname)) {
//                 if (highest == null || s.getGpa() > highest.getGpa()) {
//                     highest = s;
//                 }
//             }
//         }
//         return highest;
//     }

//     public Student getHighestGPA_byLName(String lname) throws RemoteException {
//         Student highest = null;
//         for (Student s : students) {
//             String lastName = s.getName().split(" ")[s.getName().split(" ").length - 1]; //Giả định tên cuối là Last Name
//             if (lastName.equalsIgnoreCase(lName)) {
//                 if (highest == null || s.getGpa() > highest.getGpa()) {
//                     highest = s;
//                 }
//             }
//         }
//         return highest;
//     }

//     public Student getHighestGPA_byMajor(String major) throws RemoteException {
//         Student highest = null;
//         for (Student s : students) {
//             if (s.getMajor().equalsIgnoreCase(major)) {
//                 if (highest == null || s.getGpa() > highest.getGpa()) {
//                     highest = s;
//                 }
//             }
//         }
//         return highest;
//     }

//     public Student getLowestGPA_byMajor(String major) throws RemoteException {
//         Student lowest = null;
//         for (Student s : students) {
//             if (s.getMajor().equalsIgnoreCase(major)) {
//                 if (lowest == null || s.getGpa() < lowest.getGpa()) {
//                     lowest = s;
//                 }
//             }
//         }
//         return lowest;
//     }

//     public ArrayList<Student> getTop10_byGPA() throws RemoteException {
//         students.sort((s1, s2) -> Double.compare(s2.getGpa(), s1.getGpa())); //Sắp xếp GPA tăng dần
//         ArrayList<Student> top10 = new ArrayList<>();
//         for (int i = 0; i < Math.min(10, students.size()); i++) {
//             top10.add(students.get(i));
//         }
//         return top10;
//     }

//     public ArrayList<Student> getTop10GPA_byGender(String gender) throws RemoteException {
//         ArrayList<Student> genderFiltered = new ArrayList<>();

//         for (Student s : students) {
//             if (s.getGender().equalsIgnoreCase(gender)) {
//                 genderFiltered.add(s);
//             }
//         }

//         genderFiltered.sort((s1, s2) -> Double.compare(s2.getGpa(), s1.getGpa())) //Sắp xếp GPA giảm dần
//         ArrayList<Student> top10 = new ArrayList<>();
//         for (int i = 0; i < Math.min(10, genderFiltered.size()); i++) {
//             top10.add(genderFiltered.get(i));
//         }
//         return top10;
//     }

//     public ArrayList<Student> getTop10GPA_byMajor(String major) throws RemoteException {
//         ArrayList<Student> majorFiltered = new ArrayList<>();

//         for (Student s : students) {
//             if (s.getMajor().equalsIgnoreCase(major)) {
//                 majorFiltered.add(s);
//             }
//         }

//         majorFiltered.sort((s1, s2) -> Double.compare(s2.getGpa(), s1.getGpa())) //Sắp xếp GPA giảm dần
//         ArrayList<Student> top10 = new ArrayList<>();

//         for (int i = 0; i < Math.min(10, majorFiltered.size()); i++) {
//             top10.add(majorFiltered.get(i));
//         }

//         return top10;
//     }

//     public ArrayList<Student> getLast10GPA_byGender(String gender) throws RemoteException {
//         ArrayList<Student> genderFiltered = new ArrayList<>();

//         for (Student s : students) {
//             if (s.getGender().equalsIgnoreCase(gender)) {
//                 genderFiltered.add(s);
//             }
//         }

//         genderFiltered.sort((s1, s2) -> Double.compare(s1.getGpa(), s2.getGpa()));//Sắp xếp GPA tăng dần
//         ArrayList<Student> last10 = new ArrayList<>();

//         for (int i = 0; i < Math.min(10, genderFiltered.size()); i++) {
//             last10.add(genderFiltered.get(i));
//         }

//         return last10;
//     }

//     public ArrayList<Student> getLast10GPA_byMajor(String major) throws RemoteException {
//         ArrayList<Student> majorFiltered = new ArrayList<>();

//         for (Student s : students) {
//             if (s.getMajor().equalsIgnoreCase(major)) {
//                 majorFiltered.add(s);
//             }
//         }

//         majorFiltered.sort((s1, s2) -> Double.compare(s1.getGpa(), s2.getGpa())); // Sap xep GPA tang dan
//         ArrayList<Student> last10 = new ArrayList<>();

//         for(int i = 0; i < Math.min(10, majorFiltered.size()); i++) {
//             last10.add(majorFiltered.get(i));
//         }

//         return last10;
//     }

//     public ArrayList<String> getMajors() throws RemoteException {
//         HashSet<String> majorSet = new HashSet<>();

//         for (Student s : students) {
//             majorSet.add(s.getMajor());
//         }

//         return new ArrayList<>(majorSet);
//     }
// }



// import java.io.*;
// import java.lang.reflect.Array;
// import java.rmi.RemoteException;
// import java.util.ArrayList;
// import java.util.HashSet;

// public class StudentManagementImpl implements StudentManagement {

//     ArrayList<Student> students;

//     public StudentManagementImpl() {
//         this.students = new ArrayList<>();
//     }

//     public StudentManagementImpl(String dataPath) {
//         this.students = new ArrayList<>();
//         readData(dataPath);
//     }

//     private void readData(String filePath) {
//         try {
//             File file = new File(filePath);
//             BufferedReader br = new BufferedReader(new FileReader(file));

//             String readLine;
//             while ((readLine = br.readLine()) != null) {
//                 String info = readLine.split("\t");
//                 Student s = new Student(info[0], info[1], info[2], Double.parseDouble(info[3]), info[4]);
//                 this.students.add(s);
//             }

//             br.close();
//         } catch (IOException e) {
//             System.err.println(e);
//         }
//     }

//     public int getNoOfStudent() throws RemoteException {
//         return students.size();
//     }

//     public int getNoOfStudent_byGender(String gender) throws RemoteException {
//         int count = 0;

//         for (Student s : students) {
//             if (s.getGender().equalsIgnoreCase(gender)) {
//                 count++;
//             }
//         }

//         return count;
//     }

//     public int getNoOfStudent_byMajor(String major) throws RemoteException {
//         int count = 0;

//         for (Student s : students) {
//             if (s.getMajor().equalsIgnoreCase(major)) {
//                 count++;
//             }
//         }
//         return count;
//     }

//     public int getNoOfStudent_byGPA(double gpa) throws RemoteException {
//         int count = 0;

//         for (Student s : students) {
//             if (s.getGpa() < gpa) {
//                 count++;
//             }
//         }
//         return count;
//     }

//     public Student findStudent_byName(String name) throws RemoteException {
//         for (Student s : students) {
//             if (s.getName().equalsIgnoreCase(name)) {
//                 return s;
//             }
//         }
//         return null;
//     }

//     public Student findStudent_byID(String id) throws RemoteException {
//         for (Student s : students) {
//             if (s.getId().equalsIgnoreCase(id)) {
//                 return s;
//             }
//         }
//         return null;
//     }

//     public ArrayList<Student> findStudent_byMajor(String major) throws RemoteException {
//         ArrayList<Student> majorFiltered = new ArrayList<>();

//         for (Student s : students) {
//             if (s.getMajor().equalsIgnoreCase(major)) {
//                 majorFiltered.add(s);
//             }
//         }

//         return majorFiltered;
//     }

//     public ArrayList<Student> findStudent_byGPA(double GPA) throws RemoteException {
//         ArrayList<Student> gpaFiltered = new ArrayList<>();

//         for (Student s : students) {
//             if (s.getGpa() < GPA) {
//                 gpaFiltered.add(s);
//             }
//         }
//         return gpaFiltered;
//     }

//     public double getAvgGPA()throws RemoteException {
//         if (students.isEmpty()) {
//             return 0;
//         }
//         double totalGPA = 0;
//         for (Student s : students) {
//             totalGPA += s.getGpa();
//         }
//         return totalGPA/students.size();
//     }

//     public Student getHighestGPA_byGender(String gender) throws RemoteException {
//         Student highest = null;
//         for (Student s : students) {
//             if (s.getGender().equalsIgnoreCase(gender)) {
//                 if (highest == null || s.getGpa() > highest.getGpa()) {
//                     highest = s;
//                 }
//             }
//         }
//         return highest;
//     }

//     public Student getHighestGPA_byFName(String fname) throws RemoteException {
//         Student highest = null;

//         for (Student s : students) {
//             String firstName = s.getName().split(" ")[0] //Gia su tu dau tien la first name
//             if (firstName.equalsIgnoreCase(fname)) {
//                 if (highest == null || s.getGpa() > highest.getGpa()) {
//                     highest = s;
//                 }
//             }
//         }
//         return highest;
//     }

//     public Student getHighestGPA_byLName(String lname) throws RemoteException {
//         Student highest = null;
//         for (Student s : students) {
//             String lastName = s.getName().split(" ").length - 1; // Gia su ten cuoi la last name
//             if (lastName.equalsIgnoreCase(lname)) [
//                 if (highest == null || s.getGpa() > highest.getGpa()) {
//                     highest = s;
//                 }
//             ]
//         }
//         return highest;
//     }

//     public Student getHighestGPA_byMajor(String major) throws RemoteException {
//         Student highest = null;

//         for (Student s : students) {
//             if (s.getMajor().equalsIgnoreCase(major)) {
//                 if (highest == null || s.getGpa() > highest.getGpa()) {
//                     highest = s;
//                 }
//             }
//         }
//         return highest;
//     }

//     public Student getLowestGPA_byMajor(String major) throws RemoteException {
//         Student lowest = null;
//         for (Student s : students) {
//             if (s.getMajor().equalsIgnoreCase(major)) {
//                 if (lowest == null || s.getGpa() < lowest.getGpa()) {
//                     lowest = s;
//                 }
//             }
//         }
//         return lowest;
//     }

//     public ArrayList<Student> getTop10_byGPA() throws RemoteException {
//         students.sort((s1, s2) -> Double.compare(s2.getGpa(), s1.getGpa())); // sap xep GPA giam dan
//         ArrayList<Student> top10 = new ArrayList<>();
//         for (int i = 0; i < Math.min(10, students.size()); i++) {
//             top10.add(students.get(i))
//         }
//         return top10;
//     }
// }