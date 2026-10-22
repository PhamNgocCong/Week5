import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName = "students.dat";
        List<Student> studentList = new ArrayList<>();


        while (true) {
            String id = scanner.nextLine();
            if (id.equalsIgnoreCase("END")) {
                break;
            }
            String name = scanner.nextLine();
            double gpa = Double.parseDouble(scanner.nextLine());

            studentList.add(new Student(id, name, gpa));
        }

        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(fileName));
            oos.writeObject(studentList);
        } catch (FileNotFoundException e) {
            System.out.println("Lỗi: Không tìm thấy đường dẫn tệp để ghi!");
        } catch (IOException e) {
            System.out.println("Lỗi I/O trong quá trình ghi tệp đối tượng:");
            e.printStackTrace();
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(fileName));
            List<Student> readStudents = (List<Student>) ois.readObject();
            for (Student s : readStudents) {
                System.out.println(s);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Lỗi: Không tìm thấy tệp '" + fileName + "' để đọc!");
        } catch (EOFException e) {
            System.out.println("Lỗi: Đã đọc chạm đến cuối tệp bất ngờ (EOFException).");
        } catch (ClassNotFoundException e) {
            System.out.println("Lỗi: Không tìm thấy lớp Student (ClassNotFoundException): " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Lỗi I/O trong quá trình đọc tệp:");
            e.printStackTrace();
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            scanner.close();
        }
    }
}
