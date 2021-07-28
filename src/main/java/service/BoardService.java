package service;

import beans.Board;
import java.util.List;
import constants.CastOptions;
import constants.Defaults;
import constants.Entities;
import io.restassured.http.Method;
import org.apache.http.HttpStatus;
import responses.ResponseSpecifications;
import utils.BoardsPool;
import utils.Caster;

public class BoardService {
    public static Board createDefaultTodoBoard() {
        Board board = Caster.cast(
            TrelloRestService
                .boards()
                .setMethod(Method.POST)
                .setName(Defaults.DEFAULT_BOARD_NAME)
                .setDescription(Defaults.DEFAULT_BOARD_DESCRIPTION)
                .buildRequest()
                .send()
                .then().assertThat()
                .spec(ResponseSpecifications.goodResponseSpecification())
                .and()
                .extract().response(),
            Board.class,
            CastOptions.SINGLE
        );
        BoardsPool.addBoard(board);
        return board;
    }

    public static void deleteBoard(Board board) {
        TrelloRestService
            .boards()
            .setMethod(Method.DELETE)
            .setId(board.getId())
            .buildRequest()
            .send()
            .then().assertThat()
            .statusCode(HttpStatus.SC_OK);
    }

    public static List<beans.List> getAllListsByBoard(Board board) {
        return Caster.cast(
            TrelloRestService
                .boards()
                .setMethod(Method.GET)
                .setId(board.getId())
                .setEntity(Entities.LISTS)
                .buildRequest()
                .withRetry(2, 500, HttpStatus.SC_INTERNAL_SERVER_ERROR)
                .send()
                .then().assertThat()
                .spec(ResponseSpecifications.goodResponseSpecification())
                .and()
                .extract().response(),
            beans.List.class
        );
    }

    public static Board createBoardWithLists(List<String> customBoardListsNames) {
        Board board = Caster.cast(
            TrelloRestService
                .boards()
                .setMethod(Method.POST)
                .setName(Defaults.DEFAULT_BOARD_NAME)
                .setDescription(Defaults.DEFAULT_BOARD_DESCRIPTION)
                .setDefaultLists(false)
                .buildRequest()
                .send()
                .then().assertThat()
                .spec(ResponseSpecifications.goodResponseSpecification())
                .and()
                .extract().response(),
            Board.class,
            CastOptions.SINGLE
        );
        BoardsPool.addBoard(board);
        return ListService.createListsOnBoard(customBoardListsNames, board);
    }
}
