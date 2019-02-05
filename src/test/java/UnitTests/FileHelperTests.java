package UnitTests;

import Helpers.FileHelper;
import org.junit.Assert;
import org.testng.annotations.Test;

/**
 * Created by james on 2/3/2019.
 */
public class FileHelperTests {

    @Test
    public void readEnvironmentConfigTest() {
        String contents = FileHelper.retrieveFileContents("dev.json", "src", "main", "resources", "configurations");
        Assert.assertTrue(contents.contains("\"url\" : \"https://www.google.com\""));
    }
}
