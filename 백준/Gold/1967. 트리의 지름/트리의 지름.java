import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<ArrayList<Node>> list;
    static int n;
    static int max = 0;
    static boolean visited[];
    static int max_idx = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        list = new ArrayList<ArrayList<Node>>();
        
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            
            list.get(parent).add(new Node(child, weight));
            list.get(child).add(new Node(parent, weight));
        }

        visited = new boolean[n + 1];
        visited[1] = true;
        dfs(1, 0);

        visited = new boolean[n + 1];
        visited[max_idx] = true;
        dfs(max_idx, 0);
        System.out.println(max);

    }

    public static void dfs(int idx, int cnt) {

        if (max < cnt) {
            max = cnt;
            max_idx = idx;
        }

        for (Node a : list.get(idx)) {
            if (!visited[a.idx]) {
                visited[a.idx] = true;
                dfs(a.idx, cnt + a.cnt);
            }
        }
    }

    static class Node {
        int idx, cnt;

        Node(int idx, int cnt) {
            this.idx = idx;
            this.cnt = cnt;
        }
    }
}
