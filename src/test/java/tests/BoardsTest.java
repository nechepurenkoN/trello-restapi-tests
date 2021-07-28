package tests;

import static org.assertj.core.api.Assertions.assertThat;

import beans.Board;
import java.util.List;
import java.util.stream.Collectors;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;
import providers.BoardsProvider;
import service.BoardService;
import utils.BoardsPool;

public class BoardsTest {

    @Test(
        dataProviderClass = BoardsProvider.class,
        dataProvider = "boardsWithLists"
    )
    public void boardShouldContainSpecifiedLists(Board board, List<String> listNames) {
        List<beans.List> listsOfBoard = BoardService.getAllListsByBoard(board);

        assertThat(listsOfBoard.size())
            .as(String.format("Board should contain %d lists", listNames.size()))
            .isEqualTo(listNames.size());

        assertThat(listsOfBoard.stream().map(beans.List::getName).collect(Collectors.toList()))
            .as(String.format("Default lists should be named as %s", listNames))
            .hasSameElementsAs(listNames);
    }

    @AfterSuite(alwaysRun = true)
    public void deleteAllBoards() {
        BoardsPool.deleteAll();
    }
}
