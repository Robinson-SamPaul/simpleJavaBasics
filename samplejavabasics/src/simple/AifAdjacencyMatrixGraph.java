package simple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AifAdjacencyMatrixGraph {
	public static void main(String[] args) {

        AdjacencyMatrixGraph graph = new AdjacencyMatrixGraph(8, Graph.GraphType.DIRECTED);

        graph.addEdge(1, 0, 2);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 5, 3);
        graph.addEdge(3, 4);
        graph.addEdge(2, 7);
        graph.addEdge(2, 4);
        graph.addEdge(2, 3, 5);
        graph.addEdge(5, 6, 4);
        graph.addEdge(6, 3, 2);
        graph.displayGraph();        
        System.out.println("\nIndegree of 1: " + graph.getIndegree(1));
        System.out.println("\nIndegree of 3: " + graph.getIndegree(3));
        System.out.println("\nOutdegree of 3: " + graph.getOutdegree(3));        
        System.out.println("\nIndegree of 5: " + graph.getIndegree(5));
    }
}

class AdjacencyMatrixGraph implements Graph {

	private int[][] adjacencyMatrix;
	private int numVertices = 0;
	private GraphType graphType;

	public AdjacencyMatrixGraph(int numVertices, GraphType graphType) {
		this.numVertices = numVertices;
		this.graphType = graphType;
		this.adjacencyMatrix = new int[numVertices][numVertices];
		//System.out.println("array created when constructor called " + Arrays.deepToString(adjacencyMatrix));
	}

	@Override
	public void addEdge(int v1, int v2) {
		addEdge(v1, v2, 1);
	}

	@Override
	public void addEdge(int v1, int v2, int weight) { // weight can be 0? not sure
		if (v1 >= numVertices || v2 >= numVertices || v1 < 0 || v2 < 0) {
			throw new IllegalArgumentException("Vertex number is not valid");
		}
		adjacencyMatrix[v1][v2] = weight;
		if (graphType == GraphType.UNDIRECTED) {
			adjacencyMatrix[v2][v1] = weight;
		}
	}

	@Override
	public List<Integer> getAdjacentValues(int v) {
		if (v < 0 || v >= numVertices) {
			throw new IllegalArgumentException("Vertex number is not valid");
		}
		List<Integer> adjacentVerticesList = new ArrayList<>();
		for (int i = 0; i < numVertices; i++) {
			if (adjacencyMatrix[v][i] != 0) {
				adjacentVerticesList.add(i);
			}
		}
		// Always return the vertices in ascending order.
		Collections.sort(adjacentVerticesList);
		return adjacentVerticesList;
	}

	@Override
	public int getIndegree(int v) { // Incoming elements
		if (v < 0 || v >= numVertices) {
			throw new IllegalArgumentException("Vertex number is not valid");
		}
		int indegree = 0;
		for (int i = 0; i < numVertices; i++) {
			if (adjacencyMatrix[i][v] != 0) {
				indegree++;
			}
		}
		return indegree;
	}
	
	public int getOutdegree(int v) { // outgoing elements
		if (v < 0 || v >= numVertices) {
			throw new IllegalArgumentException("Vertex number is not valid");
		}
		int indegree = 0;
		for (int i = 0; i < numVertices; i++) {
			if (adjacencyMatrix[v][i] != 0) {
				indegree++;
			}
		}
		return indegree;
	}

	@Override
	public int getNumVertices() {
		return numVertices;
	}

	@Override
	public void displayGraph() {
		System.out.println("Adjacency Matrix\n");
		for (int i = 0; i < numVertices; i++) {
			for (int j = 0; j < numVertices; j++) {
				System.out.print(adjacencyMatrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		for (int i = 0; i < numVertices; i++) {
			System.out.print("Edges from " + i + " to : ");
			for (int j = 0; j < numVertices; j++) {
				if (adjacencyMatrix[i][j] > 0) {
					System.out.print(j + " ");
				}
			}
			System.out.println();
		}
	}
	
	@Override
    public int getWeightedEdge(int v1, int v2) {
        return adjacencyMatrix[v1][v2];
    }
}
