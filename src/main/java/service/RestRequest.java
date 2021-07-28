package service;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.List;
import java.util.Map;

public class RestRequest implements Request {

    private final String url;
    private final Method requestMethod;
    private final Map<String, String> parameters;

    public RestRequest(String url, Method requestMethod, Map<String, String> parameters) {
        this.url = url;
        this.requestMethod = requestMethod;
        this.parameters = parameters;
    }

    @Override
    public Response send() {
        return RestAssured
            .given(requestSpecification()).log().all()
            .queryParams(parameters)
            .request(requestMethod, url)
            .prettyPeek();
    }

    private RequestSpecification requestSpecification() {
        return new RequestSpecBuilder()
            .setAccept(ContentType.JSON)
            .build();
    }

    public Request withRetry(int times, int delay, List<Integer> onCodes) {
        return new RetryableRequest(times, delay, onCodes, this);
    }

    public Request withRetry(int times, int delay, Integer... onCodes) {
        return withRetry(times, delay, List.of(onCodes));
    }
}
