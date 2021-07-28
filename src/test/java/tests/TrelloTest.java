package tests;

import beans.Board;
import constants.CastOptions;
import io.restassured.http.Method;
import io.restassured.response.Response;
import java.util.List;
import org.testng.annotations.Test;
import service.TrelloRestService;

public class TrelloTest {

    @Test
    public void test() {
        Response lists = TrelloRestService
            .boards()
            .setMethod(Method.GET)
            .setId("610109d6891f9f1d29b9d78e")
            .setEntity("lists")
            .buildRequest()
            .withRetry(2, 500, 500, 501)
            .send();
        List<Board> cast = TrelloRestService.cast(lists, Board.class);
        Board cast1 = TrelloRestService.cast(lists, Board.class, CastOptions.SINGLE);
    }
}
