
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/25759
public class Main {

    /// 선택하거나 안하거나
    /// 거기에 메모이제이션
    /// 중복호출이 많으니까
    
    static int N;
    static int[] arr;
    static int[][] memo;

    static int dfs(int idx, int prv){
        if(idx == N){
            return 0;
        }
        if(memo[idx][prv]!= -1) return memo[idx][prv];

        int a = 0;
        int b = 0;
        if(prv == 0) a = dfs(idx+1,arr[idx]);
        else a = dfs(idx+1, arr[idx]) + ((arr[idx] - prv)*(arr[idx] - prv));

        b = dfs(idx+1, prv);


        return memo[idx][prv] = Math.max(a, b);
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        memo = new int[N][110];
        for(int i = 0; i < N; i++) Arrays.fill(memo[i], -1);
        System.out.println(dfs(0,0));
    }
}