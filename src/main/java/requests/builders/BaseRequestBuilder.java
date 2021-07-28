package requests.builders;

import constants.Credentials;
import constants.Endpoints;
import io.restassured.http.Method;
import java.util.HashMap;
import java.util.Map;

public abstract class BaseRequestBuilder<T> {
    protected final String TRELLO_API_BASE = Endpoints.TRELLO_API_BASE;
    protected Method requestMethod = Method.GET;
    protected final Map<String, String> parameters = new HashMap<>();

    protected BaseRequestBuilder() {
        parameters.put(Credentials.API_KEY_PARAM, Credentials.API_KEY);
        parameters.put(Credentials.API_TOKEN_PARAM, Credentials.API_TOKEN);
    }


    public T setMethod(Method method) {
        this.requestMethod = method;
        return (T) this;
    }
}
