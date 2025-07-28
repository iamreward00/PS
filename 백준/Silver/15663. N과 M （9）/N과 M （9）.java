import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
public class Main {

    static int N,M;
    static int[] arr;
    static int[] num;
    static HashSet<String> set = new HashSet<>();
    static HashSet<String> set2 = new HashSet<>();
    static boolean[] visited;


    static void dfs(int len){
        if(len==M){
            String temp = "";
            for(int i = 0; i<M;i++){
                temp = temp + arr[i] + " ";
            }
            set.add(temp);
            return;
        }

        for(int i = 0; i < N; i++){
            if(visited[i]){
                continue;
            }
            visited[i] = true;
            arr[len] = i;
            dfs(len + 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st= new StringTokenizer(br.readLine());
        num = new int[N];
        arr = new int[M];
        for(int i = 0; i < N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        visited = new boolean[N];
        Arrays.sort(num);

        dfs(0);

        ArrayList<String> ans = new ArrayList<>(set);

        Collections.sort(ans);
        
        for(String str : ans){
            st = new StringTokenizer(str);
            String temp = "";
            for(int i = 0; i < M; i++){
                temp = temp + num[Integer.parseInt(st.nextToken())] + " ";
                
            }
            if(set2.contains(temp)){
                continue;
            }
            else{
                set2.add(temp);
                System.out.println(temp);
            }
        }

    }
}
