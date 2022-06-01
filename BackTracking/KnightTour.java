
/**
 * KnightTour
 */
public class KnightTour {

    private int[][] chessTable;
    private int boardSize;
    private int[] xMoves = { 2, 1, -1, -2, -2, -1, 1, 2 };
    private int[] yMoves = { 1, 2, 2, 1, -1, -2, -2, -1 };

    public KnightTour(int boardSize) {
        this.boardSize = boardSize;
        this.chessTable = new int[boardSize][boardSize];
        initializeChessTable();
    }

    private void initializeChessTable() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                chessTable[i][j] = Integer.MIN_VALUE;
            }
        }
    }

    public void solve() {

        // initial value (0, 0)
        chessTable[0][0] = 0;
        if (solveProblem(1, 0, 0)) {
            showSolution();

        } else {
            System.out.println("There is not solution...");
        }
    }

    private boolean solveProblem(int stepCount, int x, int y) {
        // base-case
        // this is when we have considered all hte cells of the chess board
        if (stepCount == boardSize * boardSize) {
            return true;
        }

        // consider all possible
        for (int moveIndex = 0; moveIndex < yMoves.length; ++moveIndex) {
            int nextX = x + xMoves[moveIndex];
            int nextY = y + yMoves[moveIndex];

            // if the move is valid
            if (isValid(nextX, nextY)) {
                // make that valid move
                chessTable[nextX][nextY] = stepCount;

                // solve the problem for the next index (next step)
                if (solveProblem(stepCount + 1, nextX, nextY)) {
                    return true;
                }
                // can not solve the problem so we backtrack
                // remove from solutions "BACKTRACKING"
                chessTable[nextX][nextY] = Integer.MIN_VALUE;
            }

        }
        return false;
    }

    private boolean isValid(int x, int y) {
        // can not leave the board horizontally and vertically
        if (x < 0 || x >= boardSize)
            return false;
        if (y < 0 || y >= boardSize)
            return false;
        // we can not visit the same cell multiple times
        if (chessTable[x][y] != Integer.MIN_VALUE)
            return false;

        return true;

    }

    private void showSolution() {

        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                System.out.print(this.chessTable[i][j] + " ");
            }
            System.out.println();
        }
    }

}
