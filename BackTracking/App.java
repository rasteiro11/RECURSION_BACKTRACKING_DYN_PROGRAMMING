/**
 * App
 */
public class App {
    public static void main(String[] args) {
        // int[][] adjacentMatrix = {
        // { 0, 1, 0, 0, 0, 1 },
        // { 1, 0, 1, 0, 0, 0 },
        // { 0, 1, 0, 0, 1, 0 },
        // { 0, 0, 0, 0, 1, 1 },
        // { 0, 0, 1, 1, 0, 1 },
        // { 1, 0, 0, 1, 1, 0 }
        // };
        // HamiltonianCycle problem = new HamiltonianCycle(adjacentMatrix);
        // problem.solve();
        //
        // GraphColoring graphColoring = new GraphColoring();

        // int[][] graphMatrix = new int[][] {
        // { 0, 1, 0, 1, 0 },
        // { 1, 0, 1, 1, 0 },
        // { 0, 1, 0, 1, 0 },
        // { 1, 1, 1, 0, 1 },
        // { 0, 0, 0, 1, 0 }
        // };

        // int numOfColors = 4;

        // graphColoring.graphColor(graphMatrix, numOfColors);
        // graphColoring.solveColoringProblem();
        // KnightTour problem = new KnightTour(5);
        // problem.solve();

        // int mazeTable[][] = {
        // { 1, 1, 1, 1 },
        // { 1, 0, 1, 0 },
        // { 0, 0, 1, 1 },
        // { 1, 0, 1, 1 }
        // };

        // MazeProblem problem = new MazeProblem(mazeTable);
        // problem.solve();
        //
        //

        int[][] sudokuTable = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                { 0, 0, 5, 2, 0, 6, 3, 0, 0 }

        };

        Sudoku problem = new Sudoku(sudokuTable);
        problem.solveProblem();

    }
}
