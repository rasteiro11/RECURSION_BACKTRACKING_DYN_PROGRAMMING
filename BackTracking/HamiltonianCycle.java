/**
 * HamiltonianCycle
 */
public class HamiltonianCycle {

    private int numOfVertexes;
    private int[] hamiltonianPath;
    private int[][] adjacencyMatrix;

    public HamiltonianCycle(int[][] adjacentMatrix) {
        this.adjacencyMatrix = adjacentMatrix;
        this.numOfVertexes = adjacentMatrix[0].length;
        this.hamiltonianPath = new int[numOfVertexes];
    }

    public void solve() {

        // we start with the first vertex (with index 0)
        hamiltonianPath[0] = 0;
        if (findSolution(1)) {
            showResult();
        } else {
            System.out.println("There is not solution...");
        }
    }

    private boolean findSolution(int position) {
        // we have considered all the vertex so end the algorithm
        if (position == this.numOfVertexes) {
            // there is a connection back to the first node (index 0) so the cycle exists
            if (adjacencyMatrix[hamiltonianPath[position - 1]][hamiltonianPath[0]] == 1) {
                return true;
            } else {
                return false;
            }
        }
        // try all the possible vertexes in the graph
        for (int vertIndex = 1; vertIndex < numOfVertexes; vertIndex++) {
            // if the node is feasible then this is the next node in the Hamiltonian cycle
            if (isValid(vertIndex, position)) {
                // we include the vertex in the Hamiltonian path
                hamiltonianPath[position] = vertIndex;

                if (findSolution(position + 1)) {
                    return true;
                }
                // BACKTRACK !!!
                // here backtracking does nothing - we just consider another vertex
            }
        }
        // tried all the vertex without a success
        return false;
    }

    private boolean isValid(int vertex, int actualPosition) {
        System.out.println("TESTING BOTH VERTEX: " + vertex + " AND POSITION: " + actualPosition);
        // first criteria: wheather the two nodes are actually connected?
        if (adjacencyMatrix[hamiltonianPath[actualPosition - 1]][vertex] == 0)
            return false;

        // second criteria: whether we have already visited this given node?
        for (int i = 0; i < actualPosition; i++) {
            if (hamiltonianPath[i] == vertex)
                return false;
        }
        System.out.println("VERTEX: " + vertex);
        System.out.println("POSITION: " + actualPosition);
        return true;
    }

    private void showResult() {
        System.out.println("Hamiltonian cycle exists: ");
        for (int i = 0; i < hamiltonianPath.length; i++) {
            System.out.print(hamiltonianPath[i] + " - ");
        }
        System.out.println(hamiltonianPath[0]);
    }

}
