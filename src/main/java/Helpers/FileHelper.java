package Helpers;

import org.junit.Assert;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by james on 2/3/2019.
 */
public class FileHelper {

    public static String retrieveFileContents(String filePath) {
        String path = System.getProperty("user.dir") + "\\" + filePath;
        String fileContents = "";

        try {
             fileContents = new String(Files.readAllBytes(Paths.get(path)));
        } catch (Exception e) {
            Assert.fail(String.format("Unable to retrieve file contents from path %1s. %2s", filePath, e.getMessage()));
        }

        return fileContents;
    }
}
