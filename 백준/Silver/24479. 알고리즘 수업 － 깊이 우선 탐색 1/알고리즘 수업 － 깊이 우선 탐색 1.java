import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer>[] list;
    static boolean[] vis;
    static int[] arr;
    static int cnt = 1;
    static void dfs(int idx){

        arr[idx] = cnt++;
        vis[idx] = true;
        for(int i : list[idx]){
            if(vis[i]) continue;
            dfs(i);
        }
        
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        list = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) list[i] = new ArrayList<>();
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        for(int i = 1; i <= n; i++) Collections.sort(list[i]);
        vis = new boolean[n+1];
        arr = new int[n+1];

        dfs(r);
        for(int i = 1; i <= n; i++){
            System.out.println(arr[i]);
        }


    }
}
