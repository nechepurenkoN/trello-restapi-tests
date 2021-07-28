package requests;

import io.restassured.response.Response;

public interface Request {
    Response send();
}
