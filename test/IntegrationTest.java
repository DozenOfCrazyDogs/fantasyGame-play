import akka.actor.ActorSystem;
import akka.stream.ActorMaterializer;
import akka.stream.Materializer;
import akka.stream.impl.ActorMaterializerImpl;
import akka.stream.impl.MaterializerSession;
import akka.stream.impl.MaterializerSession$;
import akka.stream.impl.io.ByteStringParser;
import akka.stream.javadsl.Source;
import akka.util.ByteString;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import play.Application;
import play.Logger;
import play.core.j.JavaResultExtractor;
import play.http.HttpEntity;
import play.libs.Json;
import play.mvc.Http;
import play.mvc.Result;
import play.test.Helpers;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;
import static play.test.Helpers.*;

public class IntegrationTest {

    /**
     * add your integration test here
     * in this example we just check if the welcome page is being shown
     */
    @Test
    public void test() {
        Application application = Helpers.fakeApplication();
        Helpers.start(application);
        Http.RequestBuilder request = new Http.RequestBuilder()
                .method(GET)
                .uri("/initGame");
        route(request);

        String src = "{ \"actionName\" : \"attack\", \"target\" : \"enemy\" }";
        JsonNode parse = Json.parse(src);
        request = new Http.RequestBuilder()
                .method(POST)
                .bodyJson(parse)
                .uri("/heroTurn");

        Result result = route(request);

        final ActorSystem system = ActorSystem.create("Sys");
        final ActorMaterializer materializer = ActorMaterializer.create(system);
        ByteString body = JavaResultExtractor.getBody(result, 80L, materializer);
        byte[] bytes = body.toArray();
        System.out.println(new String(bytes));
        assertEquals(OK, result.status());
    }


}
