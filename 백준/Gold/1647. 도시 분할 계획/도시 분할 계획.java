import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int V, E;
    static int[][] graph;
    static int[] parent;

    static boolean union(int a, int b) {
        int aroot = find(a);
        int broot = find(b);
        if (aroot == broot) return true;
        if (aroot > broot) parent[broot] = aroot;
        else parent[aroot] = broot;
        return false;
    }

    static int find(int a) {
        if (parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new int[E][3];
        parent = new int[V + 1];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            graph[i][0] = Integer.parseInt(st.nextToken());
            graph[i][1] = Integer.parseInt(st.nextToken());
            graph[i][2] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(graph, (o1, o2) -> Integer.compare(o1[2], o2[2]));

        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }

        long sum = 0;
        int cnt = 0;
        int max = 0;

        for (int i = 0; i < E; i++) {
            if (union(graph[i][0], graph[i][1])) continue;

            sum += graph[i][2];
            max = graph[i][2];
            cnt++;

            if (cnt == V - 1) {
                break;
            }
        }
        
        System.out.println(sum - max);
    }
}