package API;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;

/**
 * Created by james on 2/10/2019.
 */
public class IFRequest extends Unirest {

    private String _endpoint;

    public IFRequest(String endpoint) {
        _endpoint = endpoint;
    }

    /**
     * <b>Description:</b> Executes a Unirest HTTP post and gets a response as a string.
     * @return
     */
    public HttpResponse<String> executePostAndGetString() {
        HttpResponse<String> response = null;

        try {
            response = Unirest.post(_endpoint).asString();
        } catch (UnirestException e) {
            //TODO: add log message here
        }

        return response;
    }

    /**
     * <b>Description:</b> Executes a Unirest HTTP post and gets a response as a JSON object.
     * @return
     */
    public HttpResponse<JsonNode> executePostAndGetJson() {
        HttpResponse<JsonNode> response = null;

        try {
            response = Unirest.post(_endpoint).asJson();
        } catch (UnirestException e) {
            //TODO: add log message here
        }

        return response;
    }

    /**
     * <b>Description:</b> Executes a Unirest HTTP post and gets a response as an XML document.
     * @return
     */
    public Document executePostAndGetXml() {
        Document response = null;

        try {
            String stringResponse = Unirest.post(_endpoint).asString().getBody();

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dbf.newDocumentBuilder();
            InputSource is = new InputSource(new StringReader(stringResponse));
            response = builder.parse(is);
        } catch (UnirestException e) {
            //TODO: add log message here
        } catch (Exception e) {
            //TODO: add log message here
        }

        return response;
    }
}
