package providers;

import java.util.List;
import org.testng.annotations.DataProvider;
import service.BoardService;

public class BoardsProvider {
    @DataProvider
    public static Object[][] boardsWithLists() {
        List<String> customBoardListsNames = List.of("First column", "Second column");
        return new Object[][] {
            {BoardService.createDefaultTodoBoard(), List.of("To Do", "Doing", "Done")},
            {BoardService.createBoardWithLists(customBoardListsNames), customBoardListsNames}
        };
    }
}
