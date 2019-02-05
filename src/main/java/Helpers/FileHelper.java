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

    public static String retrieveFileContents(String fileName, String... folders) {
        String path = System.getProperty("user.dir") + "\\";
        String fileContents = "";
        StringBuilder sb = new StringBuilder();

        try {
            sb.append(path);

            for(String folder : folders) {
                sb.append(folder + "\\");
            }

            sb.append(fileName);

            fileContents = new String(Files.readAllBytes(Paths.get(sb.toString())));
        } catch (Exception e) {
            Assert.fail(String.format("Unable to retrieve file contents from path '%1s'. %2s", sb.toString(), e.getMessage()));
        }

        return fileContents;
    }
}
