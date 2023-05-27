import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first name (in our project - t1.txt)");
        String name1 = scanner.nextLine();
        System.out.println("Enter second name (in our project - t2.txt");
        String name2 = scanner.nextLine();

        String filePath = "/Users/fedyafuture/KR10/KR10";

        String filePath1 = filePath + "/" + name1;
        String filePath2 = filePath + "/" + name2;

        try (FileReader fileReader = new FileReader(filePath1)) {
            StringBuilder stringBuilder = new StringBuilder();
            int c;
            while ((c = fileReader.read()) != -1) {
                stringBuilder.append((char) c);
            }
            String fileString = stringBuilder.toString();
            String[] strings = fileString.split(" ");
            ArrayList<Integer> numbers = new ArrayList<>();

            for (int i = 0; i < strings.length; i++) {
                int k;
                try {
                    k = Integer.parseInt(strings[i]);
                    numbers.add(k);
                } catch (NumberFormatException e) {

                }
            }

            try (FileWriter fileWriter = new FileWriter(filePath2)) {
                for (int number : numbers) {
                    fileWriter.append(number + " ");
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}