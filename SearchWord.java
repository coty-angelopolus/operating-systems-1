import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class SearchWord {
    public static void main(String args, String wordSearch) {
        File file = new File(args);
        String [] lineSeperator;
        int strCounter =0;
        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                lineSeperator = line.split(" ");
                for (String str : lineSeperator) {
                    if (str.equals(wordSearch)) {
                        System.out.println(Arrays.toString(lineSeperator));
                        strCounter = strCounter +1;
                    }

                }
            }

            System.out.println(strCounter);
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}