package tests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import beans.Board;
import constants.Errors;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.testng.annotations.Test;
import providers.ListsProvider;
import service.BoardService;
import service.ListService;

public class ListsTest implements CleanBoards {

    @Test(
        dataProviderClass = ListsProvider.class,
        dataProvider = "boardWithExistingListsAndNewListName"
    )
    public void listCanBeAddedToExistingBoardWithLists(Board board, List<String> existingListNames,
                                                       String newListName) {
        assertThat(
            BoardService.getAllListsByBoard(board).stream()
                        .map(beans.List::getName).collect(Collectors.toList())
        ).as(String.format("Board should initially contain %s lists", existingListNames))
         .hasSameElementsAs(existingListNames);

        ListService.createListsOnBoard(List.of(newListName), board);

        assertThat(
            BoardService.getAllListsByBoard(board).stream()
                        .map(beans.List::getName).collect(Collectors.toList())
        ).as(String.format("%s list should be added to %s", newListName, existingListNames))
         .hasSameElementsAs(
             Stream.of(existingListNames, List.of(newListName)).flatMap(List::stream).collect(Collectors.toList())
         );
    }

    @Test
    public void addListsCanBeDeleted() {
        Board defaultTodoBoard = BoardService.createDefaultTodoBoard();

        ListService.deleteAllLists(defaultTodoBoard);

        List<beans.List> lists = BoardService.getAllListsByBoard(defaultTodoBoard);
        assertThat(lists).as("All lists should be deleted and lists size is 0").hasSize(0);
    }

    @Test
    public void listNameCannotBeEmpty() {
        assertThatThrownBy(() -> {
            Board boardWithEmptyList = BoardService.createBoardWithLists(List.of(""));
        }).isInstanceOf(AssertionError.class)
          .hasMessageContainingAll(
              Errors.BAD_REQUEST,
              Errors.BAD_CONTENT_TYPE
          );

    }
}
