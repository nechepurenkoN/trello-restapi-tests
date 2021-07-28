package providers;

import java.util.List;
import org.testng.annotations.DataProvider;
import service.BoardService;

public class ListsProvider {
    @DataProvider
    public static Object[][] boardWithExistingListsAndNewListName() {
        List<String> existingNames = List.of("Column one", "Column Two");
        return new Object[][] {
            {BoardService.createBoardWithLists(existingNames), existingNames, "New List!"}
        };
    }
}
