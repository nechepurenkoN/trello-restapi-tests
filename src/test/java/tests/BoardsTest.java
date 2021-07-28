package tests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import beans.Board;
import constants.Defaults;
import constants.Errors;
import java.util.List;
import java.util.stream.Collectors;
import org.testng.annotations.Test;
import providers.BoardsProvider;
import service.BoardService;

public class BoardsTest implements CleanBoards {

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

    @Test(
        dataProviderClass = BoardsProvider.class,
        dataProvider = "names"
    )
    public void boardNameCanBeChanged(String name) {
        Board defaultTodoBoard = BoardService.createDefaultTodoBoard();
        assertThat(defaultTodoBoard.getName()).isEqualTo(Defaults.DEFAULT_BOARD_NAME);

        BoardService.renameBoard(defaultTodoBoard, name);
        Board renamedBoard = BoardService.getBoardById(defaultTodoBoard.getId());

        assertThat(renamedBoard.getName()).isEqualTo(name);
    }

    @Test
    public void boardNameCannotBeEmpty() {
        Board defaultTodoBoard = BoardService.createDefaultTodoBoard();
        assertThat(defaultTodoBoard.getName()).isEqualTo(Defaults.DEFAULT_BOARD_NAME);

        assertThatThrownBy(() -> {
            Board renamedBoard = BoardService.renameBoard(defaultTodoBoard, "");
        }).isInstanceOf(AssertionError.class)
          .hasMessageContainingAll(
              Errors.BAD_REQUEST,
              Errors.BAD_CONTENT_TYPE
          );
    }
}
