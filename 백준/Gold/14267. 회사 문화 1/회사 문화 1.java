import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static ArrayList<Integer>[] graph;
    static int[] good;

    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); 
        M = Integer.parseInt(st.nextToken()); 

        
        graph = new ArrayList[N + 1];
        good = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        st = new StringTokenizer(br.readLine());
        st.nextToken();
        for (int i = 2; i <= N; i++) {
            int people = Integer.parseInt(st.nextToken());
            graph[people].add(i);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken()); // 칭찬받은 직원
            int w = Integer.parseInt(st.nextToken()); // 칭찬 점수
            good[k] += w;
        }
        dfs(1);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(good[i] + " ");
        }
        System.out.println(sb);
    }

    public static void dfs(int u) {
        // 현재 직원(u)의 모든 직속 부하(v)에 대해 반복
        // 부하(v)의 칭찬 점수에 상사(u)의 누적 칭찬 점수를 더함
        // 부하(v)를 기준으로 다시 DFS를 재귀 호출
        for (int v : graph[u]) {
            good[v] += good[u];
            dfs(v);
        }
    }
}