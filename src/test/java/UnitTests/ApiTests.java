package UnitTests;

import API.IFRequest;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by james on 2/10/2019.
 */
public class ApiTests {

    @Test
    public void postRequestTest_JsonObject() {
        IFRequest request = new IFRequest("http://api.openweathermap.org/data/2.5/weather?zip=63368,us&APPID=32f8471216a8c4d470be45252d394d26");
        HttpResponse<JsonNode> response = request.executePostAndGetJson();
        JSONObject obj = response.getBody().getObject();
        Assert.assertEquals(-90.73, obj.getJSONObject("coord").getDouble("lon"), "The response json values didn't match.");
    }

    @Test
    public void postRequestTest_JsonArray() {
        IFRequest request = new IFRequest("http://api.openweathermap.org/data/2.5/weather?zip=63368,us&APPID=32f8471216a8c4d470be45252d394d26");
        HttpResponse<JsonNode> response = request.executePostAndGetJson();
        JSONObject obj = response.getBody().getArray().getJSONObject(0);
        Assert.assertEquals(-90.73, obj.getJSONObject("coord").getDouble("lon"), "The response json values didn't match.");
    }
}
