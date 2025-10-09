import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    static boolean dbg = false;
    
    static int N;
    static int[] arr;
    static ArrayList<Integer>[] list;
    static int[] dist;
    
    static void dfs(int idx, int prv){
        
        for(int i : list[idx]){
            if(i==prv) continue;
            dist[i] = dist[idx] + arr[i];
            dfs(i,idx);
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) arr[i] = Integer.parseInt(st.nextToken());
        
        if(N==1) {
            System.out.println(arr[1] +" "+1);
            return;
        }

        list = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) list[i] = new ArrayList<>();

        for(int i = 0; i < N-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }


        dist = new int[N+1];
        dist[1] = arr[1];
        dfs(1,-1);
        if(dbg)System.out.println(Arrays.toString(dist));
        int max = dist[1];
        int maxidx = 1;
        for(int i = 1; i <= N; i++){
            if(max < dist[i]){
                max = dist[i];
                maxidx = i;
            }
        }

        dist = new int[N+1];
        dist[maxidx] = arr[maxidx];
        dfs(maxidx,-1);
        if(dbg)System.out.println(Arrays.toString(dist));

        int max2 = dist[1];
        int max2idx = 1;
        for(int i = 1; i <= N; i++){
            if(max2 < dist[i]){
                max2 = dist[i];
                max2idx = i;
            }
        }
        System.out.println(max2 +" " + Math.min(maxidx,max2idx));
    }
}
