package service;

import beans.Board;
import io.restassured.http.Method;
import java.util.List;
import responses.ResponseSpecifications;

public class ListService {

    public static Board createListsOnBoard(List<String> customBoardListsNames, Board board) {
        customBoardListsNames.forEach(listName -> {
                TrelloRestService
                    .lists()
                    .setMethod(Method.POST)
                    .setName(listName)
                    .setBoardId(board.getId())
                    .buildRequest()
                    .send()
                    .then().assertThat()
                    .spec(ResponseSpecifications.goodResponseSpecification());
            }
        );
        return board;
    }
}
