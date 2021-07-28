package tests;

import org.testng.annotations.AfterClass;
import utils.BoardsPool;

public interface CleanBoards {
    @AfterClass(alwaysRun = true)
    default void deleteAllBoards() {
        BoardsPool.deleteAll();
    }
}
