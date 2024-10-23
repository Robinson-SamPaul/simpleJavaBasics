package simple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AiiTopologicalSort {
	
	public static void main(String[] args) {
		//sortTest();
		orderTest();
	}

	// sorting based on vertex, not values, don't get confused (basically we're traversing in order)
	/*
	 * Topological Sort: Requires a Directed and Acyclic Graph (DAG).
	 * Undirected Graphs: Cannot be topologically sorted because there's no directional information to determine the order of nodes.
	 */
    public static List<Integer> sort(Graph graph) {
    	LinkedList<Integer> queue = new LinkedList<>();        
    	Map<Integer, Integer> indegreeMap = new HashMap<>();
        for (int vertex = 0; vertex < graph.getNumVertices(); vertex++) {
            int indegree = graph.getIndegree(vertex);
            indegreeMap.put(vertex, indegree);            
            if (indegree == 0) {
                queue.add(vertex); // adding non indegree element (basically adding starting points, may contain 1+ starting point)
            }
        }
        System.out.println("Starting points " + queue);
        List<Integer> sortedList = new ArrayList<>();
        while (!queue.isEmpty()) {            
        	// NOTE: If more than one element exists then it means that the graph
            // has more than one topological sort solution.            
        	int vertex = queue.remove();
        	// NOTE: This is the equivalent of processing the list
        	sortedList.add(vertex);
            List<Integer> adjacentVertices = graph.getAdjacentValues(vertex);            
            for (int adjacentVertex : adjacentVertices) {                
            	int updatedIndegree = indegreeMap.get(adjacentVertex) - 1;
            	indegreeMap.put(adjacentVertex, updatedIndegree);
                if (updatedIndegree == 0) {                    
                	queue.add(adjacentVertex);
                }
            }
        }
        if (sortedList.size() != graph.getNumVertices()) {
            throw new RuntimeException("The graph had a cycle!");
        }
        return sortedList;
    }
    
    public static void sortTest() {
        Graph graph = new AdjacencyMatrixGraph(9, Graph.GraphType.DIRECTED);
        graph.addEdge(2, 0);
        graph.addEdge(8, 0);
        graph.addEdge(2, 7);
        graph.addEdge(0, 3);
        graph.addEdge(0, 4);
        graph.addEdge(0, 1);
        graph.addEdge(2, 1);
        graph.addEdge(1, 3);
        graph.addEdge(3, 5);
        graph.addEdge(3, 6);
        graph.addEdge(4, 7);  
        //graph.addEdge(7, 0); // Exception - Graph had a cycle
        graph.displayGraph(); // draw like binary tree/graph and try to understand
        /*
         * 
         */
        System.out.println("\n------------------------------------------\n");        
        System.out.println(sort(graph));
        System.out.println("\n------------------------------------------\n");
        System.out.println("\n------------------------\n");
		boolean[] breadthFirstFlag = new boolean[graph.getNumVertices()];
		AihGraphTraversal.breadthFirstTraversal(graph, breadthFirstFlag, 2);
		System.out.println("\n------------------------\n");

    }
    
    public static void orderTest() {
    	List<String> courses = new ArrayList<>();        
        courses.add("Java");
        courses.add("SpringBoot");
        courses.add("Spring");
        courses.add("Python");
        courses.add("Django");
        courses.add("Numpy");
        courses.add("Quarkus");
        
        Map<String, List<String>> prereqs = new HashMap<>();
        List<String> list = new ArrayList<>();
        
        list.add("Quarkus");
        list.add("SpringBoot");
        list.add("Spring");
        prereqs.put("Java", list);
        
        list = new ArrayList<>();
        list.add("SpringBoot");
        prereqs.put("Spring", list);
        
        list = new ArrayList<>();
        list.add("Numpy");
        prereqs.put("Python", list);
        
        list = new ArrayList<>();
        list.add("Django");
        prereqs.put("Numpy", list);
        
        list = new ArrayList<>();
        list.add("Django");
        list.add("Numpy");
        prereqs.put("Python", list);
        
        List<String> courseSchedule = order(courses, prereqs);
        System.out.println("Valid schedule for CS Students: " + courseSchedule);
    }

	private static List<String> order(List<String> courseList, Map<String, List<String>> prereqs) {
		Graph courseGraph = new AdjacencyMatrixGraph(courseList.size(), Graph.GraphType.DIRECTED);
        Map<String, Integer> courseIdMap = new HashMap<>();
        Map<Integer, String> idCourseMap = new HashMap<>();
        for (int i = 0; i < courseList.size(); i++) {            
            courseIdMap.put(courseList.get(i), i);            
            idCourseMap.put(i, courseList.get(i));
        }
        System.out.println("courseIdMap = " + courseIdMap);
        System.out.println("idCourseMap = " + idCourseMap);
        for (Map.Entry<String, List<String>> prereq : prereqs.entrySet()) {            
            for (String course : prereq.getValue()) {                
                courseGraph.addEdge(courseIdMap.get(prereq.getKey()), courseIdMap.get(course));
            }
        }
        courseGraph.displayGraph();
        List<Integer> courseIdList =  sort(courseGraph);
        System.out.println("courseIdList = " + courseIdList);
        List <String> courseScheduleList =  new ArrayList<>();
        for (int courseId : courseIdList) {
            courseScheduleList.add(idCourseMap.get(courseId));
        }
        return courseScheduleList;
	}
}
