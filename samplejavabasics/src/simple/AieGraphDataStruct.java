package simple;

import java.util.ArrayList;
import java.util.List;

public class AieGraphDataStruct {

	/*
	 * A graph data structure is a collection of nodes(vertices) and edges that connect pairs of nodes. 
	 * Graphs are widely used to represent relationships or connections between objects, 
	 * where nodes represent the objects and edges represent the connections or relationships between them.
	 * 
	 * Vertices(Nodes) are the fundamental units of the graph that represent objects or entities. 
	 * In a graph, each vertex can have a unique identifier.

	 * Edges: These are connections between two vertices. An edge can be:
	 *  	Directed: The connection goes from one vertex to another (one-way).
	 *  	Undirected: The connection goes both ways (two-way).
	 *  
	 * Cyclic Graph:
	 * 		A graph that contains at least one cycle, where a path exists that starts and ends 
	 * 		at the same vertex.
	 * Acyclic Graph:
	 * 		A graph that contains no cycles.
	 * Weighted Graph:
	 * 		Each edge has a numerical value (weight) representing the cost, length, or capacity of the connection.
	 * 		Example: A road network where the weight of each edge represents the distance between two cities.

	 * Adjacency: 
	 * 		Two vertices are said to be adjacent if there is an edge connecting them.
	 * Path: 
	 * 		A sequence of edges connecting two vertices in a graph.
	 * Degree: 
	 * 		The number of edges connected to a vertex. For directed graphs, we have:
	 * 		In-degree: 
	 * 			The number of incoming edges to a vertex.
	 * 		Out-degree: 
	 * 			The number of outgoing edges from a vertex.
	 * 
	 * V represents the number of vertices (or nodes) in the graph.
	 * E represents the number of edges in the graph.
	 * 
	 * An ADJACENCY MATRIX is a 2D array (or matrix) of size V×V, 
	 *  	where V is the number of vertices in the graph. 
	 *  	Each cell at position (i,j) indicates whether there is an edge between vertex
	 *  	Space Complexity:O(V^2): 
	 *  		Regardless of the number of edges, the matrix always requires space for entries 
	 *  		because every possible vertex pair is represented.
	 * An ADJACENCY LIST is an array or list where each element corresponds to a vertex and 
	 * 		contains a list of all adjacent vertices (i.e., vertices connected by an edge).
	 * 		Space Complexity:O(V + E): 
	 * 			Space is proportional to the number of vertices plus the number of edges. 
	 * 			Each vertex has a list, and each edge is stored only once.
	 * An ADJACENCY SET is similar to an adjacency list, 
	 * 		but instead of storing adjacent vertices in a list, they are stored in a set (or hash set). 
	 * 		This can improve the time complexity for checking the existence of a specific edge.
	 * 		Space Complexity:O(V + E): 
	 * 			Similar to the adjacency list, space is proportional to the number of vertices plus the number of edges. 
	 * 			The additional overhead comes from the set's internal structure.
	 */
}

interface Graph {
	enum GraphType{    
    	DIRECTED,        
        UNDIRECTED
    }	
	void addEdge(int v1, int v2);
	// NOTE: For an undirected graph, we assume that the weight
	// in both directions is the same
	void addEdge(int v1, int v2, int weight);
	List<Integer> getAdjacentValues(int v);
	int getNumVertices();
	int getIndegree(int v);
	void displayGraph();
	int getWeightedEdge(int v1, int v2);
}

class Vertex { // basically a node

    private int vertexNumber; // node with int value
    private int weight;
    private List<Vertex> adjacencyList = new ArrayList<>();
    private List<Integer> adjacencyNumbers = new ArrayList<>();

    public Vertex(int vertexNumber, int weight) {        
    	this.vertexNumber = vertexNumber;
        this.weight = weight;
    }

    public int getVertexNumber() {
        return vertexNumber;
    }

    public int getWeight() {
        return weight;
    }

    public void addEdge(int vertexNumber, int weight) {
        adjacencyList.add(new Vertex(vertexNumber, weight));
        adjacencyNumbers.add(vertexNumber);
    }

    public List<Vertex> getAdjacentVertices() {
        return adjacencyList;
    }

    public List<Integer> getAdjacentNumbers() {
        return adjacencyNumbers;
    }
    
    public String toString() {
    	return "Vertex: " + vertexNumber + " Weight: " + weight;
    }
}
