import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N,R,Q;
    static ArrayList<Integer>[] list;
    static int[] memo;
    static boolean[] vis;
    static void dfs(int idx){
        
        vis[idx] = true;
        memo[idx] = 1;
        for(int i : list[idx]){
            if(vis[i]) continue;
            dfs(i);
            memo[idx] += memo[i];
        }

        
    }


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];

        for(int i = 1; i <= N; i++ ) list[i] = new ArrayList<>();

        for(int i = 0; i < N-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        memo = new int[N+1];
        vis = new boolean[N+1];
        dfs(R);
        for(int i = 0; i < Q; i++){
            int a = Integer.parseInt(br.readLine());
            sb.append(memo[a]);
            sb.append("\n");
        }
        System.out.println(sb);
        
    }
}