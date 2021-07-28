package providers;

import beans.Board;
import java.util.List;
import org.testng.annotations.DataProvider;
import service.BoardService;
import service.CardService;

public class CardsProvider {
    @DataProvider
    public static Object[][] listAndNewCardName() {
        Board board = BoardService.createBoardWithLists(List.of("Test list"));
        beans.List list = BoardService.getAllListsByBoard(board).get(0);
        return new Object[][] {
            {list, List.of("Test Card", "another card")}
        };
    }

    @DataProvider
    public static Object[][] listWithCards() {
        Board board = BoardService.createBoardWithLists(List.of("Test list"));
        beans.List list = BoardService.getAllListsByBoard(board).get(0);
        CardService.createCardByName(list, "Card to delete");
        return new Object[][] {
            {list}
        };
    }
}
