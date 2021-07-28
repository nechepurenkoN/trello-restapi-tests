package service;

import beans.Board;
import beans.Card;
import constants.CastOptions;
import constants.Entities;
import io.restassured.http.Method;
import java.util.List;
import responses.ResponseSpecifications;
import utils.Caster;

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

    public static Board deleteAllLists(Board board) {
        BoardService.getAllListsByBoard(board).stream()
                    .map(beans.List::getId)
                    .forEach(ListService::deleteListById);
        return board;
    }

    public static void deleteListById(String id) {
        TrelloRestService
            .lists()
            .setMethod(Method.PUT)
            .setId(id)
            .setEntity(Entities.CLOSED)
            .setClosed(true)
            .buildRequest()
            .send()
            .then().assertThat()
            .spec(ResponseSpecifications.goodResponseSpecification());
    }

    public static List<Card> getAllCards(beans.List list) {
        return Caster.cast(
            TrelloRestService
                .lists()
                .setMethod(Method.GET)
                .setId(list.getId())
                .setEntity(Entities.CARDS)
                .buildRequest()
                .send()
                .then().assertThat()
                .spec(ResponseSpecifications.goodResponseSpecification())
                .and()
                .extract().response(),
            Card.class
        );
    }

    public static void deleteAllCards(beans.List list) {
        TrelloRestService
            .lists()
            .setMethod(Method.POST)
            .setId(list.getId())
            .setEntity(Entities.ARCHIVE_ALL_CARDS)
            .buildRequest()
            .send()
            .then().assertThat()
            .spec(ResponseSpecifications.goodResponseSpecification());
    }

}
