package UnitTests;

import Helpers.FileHelper;
import Helpers.JsonDataProvider;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

/**
 * Created by james on 2/5/2019.
 */
public class JsonDataProviderTests {

    @Test
    public void retrieveDataTest() {
        JSONObject data = JsonDataProvider.getTestData("JsonDataProviderTests", "retrieveDataTest");
        Assert.assertEquals("Value2", data.getString("Key2"), "The json data didn't match.");
    }

    @Test
    public void retrieveCustomColumnDataTest() {
        JSONObject data = JsonDataProvider.getTestData("JsonDataProviderTests", "retrieveCustomColumnDataTest", "CustomColumn");
        Assert.assertEquals("CustomValue2", data.getString("Key2"), "The json data didn't match.");
    }
}
