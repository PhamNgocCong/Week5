import java.io.*;
import java.util.Scanner;

public class TextFileCopy{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sourcePath=scanner.nextLine();
        String destPath=scanner.nextLine();

        BufferedReader reader=null;
        PrintWriter writer = null;

        try{


            try{
                reader = new BufferedReader(new FileReader(sourcePath));
            } catch (FileNotFoundException e) {
                System.out.println("Source file not found.");
                return;
            }

            try{
                writer = new PrintWriter(new FileWriter(destPath));
            } catch (FileNotFoundException e) {
                System.out.println("Cannot create destination file.");
                return;
            }

            String line;
            while ((line=reader.readLine()) != null) {
                writer.println(line);
            }



        } catch (IOException e) {
            System.out.println("I/O error.");
            e.printStackTrace();
        } finally {
            try {
                if(reader != null) { reader.close();}
    
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (writer != null) {
                writer.close();
            }
        }

    }
}
