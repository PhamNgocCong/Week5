import java.util.InputMismatchException;
import java.util.Scanner;


public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try{
           int a= scanner.nextInt();
           int b= scanner.nextInt();
           int ketqua=a/b;
           System.out.println(ketqua);
        } catch (InputMismatchException e) {
            System.out.println("Lỗi: Chỉ nhập các số nguyên hợp lệ!");
        } catch (ArithmeticException e) {
            System.out.println("Lỗi : Không thể chia 1 số cho 0!");
        } finally {
            System.out.println("Program finished.");
        }
    }
}
