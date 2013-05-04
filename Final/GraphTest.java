/**
 *  Test file for Graph class
 *  
 *  @author  Zacharias J. Arthurs
 *  @version 24 April 2013
 */

public class GraphTest {
    public static void main(String[] args) {
        Graph<String, String> map = new Graph<String,String>();
        map.addNode("Amherst College");
        map.addNode("Hampshire College");
        map.addNode("Mount Holyoke College");
        map.addNode("Smith College");
        map.addNode("UMass Amherst");
        map.print();
        map.addEdge("B43", map.getNode(3), map.getNode(4));
        map.addEdge("39", map.getNode(3), map.getNode(1));
        map.addEdge("38", map.getNode(2), map.getNode(4));
        map.print();
        map.removeNode(map.getNode(0));
        map.print();
        map.removeNode(map.getNode(2));
        map.print();
        map.removeEdge(map.getEdge(0));
    }
}