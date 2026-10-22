import java.io.*;
import java.util.Scanner;

public class BinaryNumberReader {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DataInputStream dis = null;

        try {
            String fileName = scanner.nextLine();
            dis = new DataInputStream(
                    new BufferedInputStream(new FileInputStream(fileName)));
            while (true) {
                try {
                    int number = dis.readInt();
                    System.out.print(number + " ");
                } catch (EOFException e) {
                    break;
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Lỗi: Không tìm thấy tệp!");
        } catch (IOException e) {
            System.out.println("Lỗi I/O trong quá trình đọc tệp:");
            e.printStackTrace();
        } finally {
            try {
                if (dis != null) {
                    dis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            scanner.close();
        }
    }
}
