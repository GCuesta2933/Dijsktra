import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {


    public static NodePath run(Graph g){
        Comparator<NodePath> comparator = (n1,n2) -> Integer.compare(n1.cost, n2.cost);
        PriorityQueue<NodePath> pq = new PriorityQueue<>(comparator);
        NodePath first = new NodePath(0, g.getS(), g.getS() + "");
        pq.add(first);

        while(!pq.isEmpty()){
            NodePath curr = pq.poll();
            if(curr.nodeID == g.getT()){
                return curr;
            }
            List<int[]> neighbors = g.neighbors(curr.nodeID);
            for(int[] neighbor : neighbors){
                NodePath temp = new NodePath(curr.cost + neighbor[0], neighbor[1], curr.path + neighbor[1]);
                pq.add(temp);
            }

        }
        return null;

    }


    public static void main(String[] args){
        Graph g = new Graph("C:\\Users\\gcues\\IdeaProjects\\Assignment2\\src\\ExampleGraph");
        System.out.println(Dijkstra.run(g));
        Graph t = new Graph("C:\\Users\\gcues\\IdeaProjects\\Assignment2\\src\\LongPath");
        System.out.println(Dijkstra.run(t));
    }
}

class NodePath {
    public int cost;
    public int nodeID;
    public String path;
    public NodePath(int cost, int nodeID, String path){
        this.cost = cost;
        this.nodeID = nodeID;
        this.path = path;
    }
    public String toString(){

        return "NodePath(cost = " + this.cost + ",nodeID = " + this.nodeID + ", path = " + this.path + ")";

    }
}
