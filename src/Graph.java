import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Graph {



    private int N = 0;//number of vertices
    private int s= 0;//start node
    private int t = 0;//target node
    private int[][] matrix = null;

    public Graph(String fileName){
        this.parse(fileName);


    }

    public int getN() {
        return N;
    }

    public int getS() {
        return s;
    }

    public int getT() {
        return t;
    }


    public List<int[]> neighbors(int nodeID){
        List list1 = new ArrayList<int[]>(this.N);
        for(int i = 0; i < N; i++){
            int[] temp = new int[2];
            temp[0] = this.matrix[nodeID][i];
            temp[1] = i;
            if(temp[0] != 0){
                list1.add(temp);
            }
        }
        return list1;
    }

    public void parse(String fileName){

        try {
            BufferedReader bf = new BufferedReader(new FileReader(fileName));
            String line =bf.readLine();
            this.N = Integer.parseInt(line.strip());
            this.matrix = new int[N][N];

            for(int i = 0; i < N; i++){
                line = bf.readLine().strip();
                String[] nodes = line.split("\s+");
                for(int j = 0; j < N ;j++){
                    int cost = Integer.parseInt(nodes[j]);
                    this.matrix[i][j] = cost;
                }


            }
            line = bf.readLine().strip();
            String[] st = line.split("\s+");
            this.s = Integer.parseInt(st[0]);
            this.t = Integer.parseInt(st[1]);

        }
        catch(IOException e) {
            e.printStackTrace();
        }



    }


    public String toString(){

        return "Graph(N = " + this.N + ",s = " + this.s + ", t = " + this.t + ")";

    }











    public static void main(String[] args) {

    Graph g = new Graph("C:\\Users\\gcues\\IdeaProjects\\Assignment2\\src\\ExampleGraph");
    System.out.println(g);
        for(int i = 0; i < g.getN(); i++){
            List<int[]> neighbors = g.neighbors(i);
            for(int[] neighbor : neighbors){
                System.out.print(neighbor[0] + " , " + neighbor[1] + " ; ");
            }
            System.out.println();
        }



    }


}