import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N,M,count;
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;

    static void dfs(int start){
        visited[start] = true;
        count += 1;
        int size = graph.get(start).size();

        for(int i=0; i<size; i++){
            int vertex = graph.get(start).get(i);
            if(visited[vertex])
                continue;
            dfs(vertex);
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(bf.readLine());
        M = Integer.parseInt(bf.readLine());
        graph = new ArrayList<ArrayList<Integer>>();
        visited = new boolean[N+1];

        for(int i=0; i<N+1; i++)
            graph.add(new ArrayList<Integer>());

        for(int i=0; i<M; i++){
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        dfs(1);
        System.out.println(count-1);
    }
}