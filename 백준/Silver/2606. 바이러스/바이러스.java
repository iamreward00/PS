import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    /// 1에서 dfs 돌리면되겠다 bfs나
    
    static int N,M;
    static ArrayList<Integer>[] list;
    static int cnt;
    static boolean[] vis;

    static int dfs(int idx){

        if(vis[idx]) return 0;
        vis[idx] = true;
        int a = 1;

        for(int i : list[idx]){
            a += dfs(i);
        }

        return a;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());    
        list = new ArrayList[N+1];

        for(int i = 1; i <= N; i++) list[i] = new ArrayList<>();
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        vis = new boolean[N+1];
        
        System.out.println(dfs(1)-1);

    }
}