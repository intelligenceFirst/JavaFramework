package API;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * Created by james on 2/10/2019.
 */
public class IFRequest extends Unirest {

    private String _endpoint;

    public IFRequest(String endpoint) {
        _endpoint = endpoint;
    }

    public HttpResponse<String> executePostAndGetString() {
        HttpResponse<String> response = null;

        try {
            response = Unirest.post(_endpoint).asString();
        } catch (UnirestException e) {
            //TODO: add log message here
        }

        return response;
    }

    public HttpResponse<JsonNode> executePostAndGetJson() {
        HttpResponse<JsonNode> response = null;

        try {
            response = Unirest.post(_endpoint).asJson();
        } catch (UnirestException e) {
            //TODO: add log message here
        }

        return response;
    }
}
