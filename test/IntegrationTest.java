import akka.actor.ActorSystem;
import akka.stream.ActorMaterializer;
import akka.util.ByteString;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import play.Application;
import play.core.j.JavaResultExtractor;
import play.libs.Json;
import play.mvc.Http;
import play.mvc.Result;
import play.test.Helpers;

import java.io.IOException;
import java.net.URL;

import static play.test.Helpers.*;

public class IntegrationTest {

    /**
     * add your integration test here
     * in this example we just check if the welcome page is being shown
     */
    @Test
    public void simpleAttackSpell() throws IOException, JSONException {
        initGame();
        String src = "{ \"actionName\" : \"attack\", \"target\" : \"enemy\" }";
        JsonNode parse = Json.parse(src);
        Http.RequestBuilder request = new Http.RequestBuilder()
                .method(POST)
                .bodyJson(parse)
                .uri("/heroTurn");

        Result result = route(request);
         result = route(request);
        String resultJson = extractJsonResponseFromResult(result);
        System.out.println(resultJson);
        assertJsonEquals("simple-attack-result.json", resultJson);
    }

    @Test
    public void fireballSpellTest() throws IOException, JSONException {
        initGame();
        String src = "{ \"actionName\" : \"fireball\", \"target\" : \"enemy\" }";
        JsonNode parse = Json.parse(src);

        Http.RequestBuilder request = new Http.RequestBuilder()
                .method(POST)
                .bodyJson(parse)
                .uri("/heroTurn");

        Result result = route(request);
        String resultJson = extractJsonResponseFromResult(result);
        System.out.println(resultJson);
        assertJsonEquals("fireball-spell-result.json", resultJson);
    }

    @Test
    public void oilDebuffTest() throws IOException, JSONException {
        initGame();
        String src = "{ \"actionName\" : \"oil\", \"target\" : \"enemy\" }";
        JsonNode parse = Json.parse(src);

        Http.RequestBuilder request = new Http.RequestBuilder()
                .method(POST)
                .bodyJson(parse)
                .uri("/heroTurn");

        Result result = route(request);
        String resultJson = extractJsonResponseFromResult(result);
        System.out.println(resultJson);
        assertJsonEquals("oil-debuff-test-result.json", resultJson);
    }

    private void initGame() {
        Application application = Helpers.fakeApplication();
        Helpers.start(application);
        Http.RequestBuilder request = new Http.RequestBuilder()
                .method(GET)
                .uri("/initGame");
        route(request);
    }

    private void assertJsonEquals(String expectedResourceName, String resultJson) throws IOException, JSONException {
        URL resource = Resources.getResource(expectedResourceName);
        String expected = Resources.toString(resource, Charsets.UTF_8);
        JSONAssert.assertEquals(expected, resultJson, JSONCompareMode.STRICT);
    }

    private String extractJsonResponseFromResult(Result result) {
        ActorSystem system = ActorSystem.create("Sys");
        ActorMaterializer materializer = ActorMaterializer.create(system);
        ByteString body = JavaResultExtractor.getBody(result, 80L, materializer);
        byte[] bytes = body.toArray();
        return new String(bytes);
    }


}
