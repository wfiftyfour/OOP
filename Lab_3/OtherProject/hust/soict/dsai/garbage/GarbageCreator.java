package hust.soict.dsai.garbage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {
    public static void main(String[] args) {
        String filename = "/Users/buiviethung/eclipse-workspace/AimProject/src/hust/soict/dsai/garbage/text.txt";
        byte[] inputBytes = {0};
        long startTime, endTime;

        // Check if the file exists
        File file = new File(filename);
        if (!file.exists()) {
            System.err.println("Error: File not found: " + filename);
            return;
        }

        try {
            inputBytes = Files.readAllBytes(Paths.get(filename));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        startTime = System.currentTimeMillis();
        String outputString = "";
        for (byte b : inputBytes) {
            outputString += (char) b;
        }
        System.out.println(outputString);
        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
}