/**
 * MazeProblem
 */
public class MazeProblem {

    private int[][] maze;
    // 0 values and 1 values - 1 represent the path (solution)
    private int[][] solution;
    private int mazeSize;

    public MazeProblem(int[][] maze) {
        this.maze = maze;
        this.mazeSize = maze.length;
        this.solution = new int[mazeSize][mazeSize];
    }

    public void solve() {
        if (solveProblem(0, 0)) {
            showSolution();
        } else {
            System.out.println("There is no solution...");
        }
    }

    public boolean solveProblem(int rowIndex, int colIndex) {
        // weather we have reached the "destination"
        if (isFinished(rowIndex, colIndex)) {
            return true;
        }
        if (isValid(rowIndex, colIndex)) {
            // it is valid so it is part of the solution
            solution[rowIndex][colIndex] = 1;

            // GOING RIGHT !!!
            // go forward in the horizontally direction
            // note: we have to increment the colIndex to move horizontlly
            if (solveProblem(rowIndex, colIndex + 1)) {
                return true;
            }

            // GOING DOWN !!!
            // go downward in the vertically direction
            // note: we have to increment the rowIndex to move horizontally
            if (solveProblem(rowIndex + 1, colIndex)) {
                return true;
            }

            // BACKTRACK !!!
            solution[rowIndex][colIndex] = 0;

        }
        return false;

    }

    private boolean isFinished(int rowIndex, int colIndex) {
        if (rowIndex == mazeSize - 1 && colIndex == mazeSize - 1) {
            solution[rowIndex][colIndex] = 1;
            return true;
        }
        return false;
    }

    private boolean isValid(int rowIndex, int colIndex) {
        // can not leave the maze horizontally or vertically
        if (rowIndex < 0 || rowIndex >= mazeSize)
            return false;
        if (colIndex < 0 || colIndex >= mazeSize)
            return false;
        // have to consider obstacles
        if (maze[rowIndex][colIndex] != 1)
            return false;
        return true;
    }

    private void showSolution() {
        for (int i = 0; i < mazeSize; i++) {
            for (int j = 0; j < mazeSize; j++) {
                if (solution[i][j] == 1)
                    System.out.print(" S ");
                else
                    System.out.print(" - ");
            }
            System.out.println();
        }
    }

}
