package Classes;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReader {

    public Path filePath;
    public List<String> data;

    public List<String> readFile(Path filePath) {
        try {
            data = Files.readAllLines(filePath);
        } catch (FileNotFoundException e) {
//            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
