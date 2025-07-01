import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    
    static int parent[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(stz.nextToken());
        int e = Integer.parseInt(stz.nextToken());
        parent = new int[v+1];
        for(int i = 1; i <= v; i++)
            parent[i]= i;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for(int i = 0; i < e; i++) {
            stz = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stz.nextToken());
            int b = Integer.parseInt(stz.nextToken());
            int w = Integer.parseInt(stz.nextToken());
            pq.offer(new Edge(a, b, w));
        }
        
        int weight = 0;
        while(!pq.isEmpty()) {
            Edge now = pq.poll();
            if(find(now.v1) != find(now.v2)) {
                union(now.v1, now.v2);
                weight += now.weight;
            }
        }
        
        System.out.println(weight);
    }
    
    public static void union(int n1, int n2) {
        int p1 = find(n1);
        int p2 = find(n2);
        
        if(p1 < p2)
            parent[p2] = p1;
        else
            parent[p1] = p2;
    }
    
    public static int find(int n) {
        if(parent[n] == n)
            return n;
        return parent[n] = find(parent[n]);
    }
    
    static class Edge implements Comparable<Edge>{
        int v1, v2, weight;
        
        Edge(int v1, int v2, int weight) {
            this.v1 = v1;
            this.v2 = v2;
            this.weight = weight;
        }
        
        public int compareTo(Edge e) {
            return weight - e.weight;
        }
    }
}