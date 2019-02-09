package Helpers;

import org.json.JSONObject;
import org.junit.Assert;

/**
 * Created by james on 2/5/2019.
 */
public class JsonDataProvider {

    /**
     * <b>Description:</b> Retrieves the test data from the data provider with the given test class and test name.
     * @param testClass
     * @param testName
     * @return
     */
    public static JSONObject getTestData(String testClass, String testName) {
        JSONObject json = null;
        String filePath = "";

        try {
            // creating the path to the data provider json file
            filePath = "src//main//resources//TestData//" + testClass + "_Data.json";

            // getting the file contents
            String contents = FileHelper.retrieveFileContents(filePath);

            // converting the contents to json object
            json = new JSONObject(contents);

            // retrieving the specific json object by the testname
            if (json.get(testName).getClass().toString().toLowerCase().contains("array")) {
                json = json.getJSONArray(testName).getJSONObject(0);
            } else {
                json = json.getJSONObject(testName);
            }
        } catch (Exception e) {
            Assert.fail(String.format("Error retrieving test data for test '%s1' in data provider '%s1'.", testName, testClass + "_Data.json"));
        }

        return json;
    }

    /**
     * <b>Description:</b> Retrieves the test data from the data provider with the given test class, test name, and custom column name.
     * @param testClass
     * @param testName
     * @param customColumnName
     * @return
     */
    public static JSONObject getTestData(String testClass, String testName, String customColumnName) {
        JSONObject json = null;
        String filePath = "";

        try {
            // creating the path to the data provider json file
            filePath = "src//main//resources//TestData//" + testClass + "_Data.json";

            // getting the file contents
            String contents = FileHelper.retrieveFileContents(filePath);

            // converting the contents to json object
            json = new JSONObject(contents);

            if (json.get(testName).getClass().toString().toLowerCase().contains("array")) {
                json = json.getJSONArray(testName).getJSONObject(0);
            } else {
                json = json.getJSONObject(testName);
            }

            if (json.get(customColumnName).getClass().toString().toLowerCase().contains("array")) {
                json = json.getJSONArray(customColumnName).getJSONObject(0);
            } else {
                json = json.getJSONObject(customColumnName);
            }

        } catch (Exception e) {
            Assert.fail(String.format("Error retrieving test data for test '%s1' in data provider '%s2' and custom column '%s3'.", testName, testClass + "_Data.json", customColumnName));
        }

        return json;
    }
}
