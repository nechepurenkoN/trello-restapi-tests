package utils;

import beans.Board;
import java.util.HashSet;
import java.util.Set;
import service.BoardService;

public class BoardsPool {
    private static final Set<Board> pool = new HashSet<>();

    public static void addBoard(Board board) {
        pool.add(board);
    }

    public static void deleteAll() {
        pool.forEach(BoardService::deleteBoard);
    }
}
