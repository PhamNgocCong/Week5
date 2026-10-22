import java.io.*;
import java.util.Scanner;

public class BinaryNumberWriter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DataOutputStream dos = null;

        try {
            String fileName = scanner.nextLine();
            int n = scanner.nextInt();
            dos = new DataOutputStream(
                    new BufferedOutputStream(new FileOutputStream(fileName)));
            for (int i = 0; i < n; i++) {
                int number = scanner.nextInt();
                dos.writeInt(number);
            }

        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi I/O trong quá trình ghi tệp:");
            e.printStackTrace();
        } finally {
            try {
                if (dos != null) {
                    dos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            scanner.close();
        }
    }
}
