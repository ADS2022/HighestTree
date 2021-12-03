package mesw.ads.highesttree.HighestTree.model.database;

import java.io.FileWriter;
import java.io.IOException;

public class Writer {
    public static void writeToFile(String filename, String context) {
        try {
            FileWriter myWriter = new FileWriter(filename, true);
            myWriter.write(context + "\n");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}