import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/// 백준 3067  Coins
/// https://www.acmicpc.net/problem/3067
public class Main {

    /// 이게 이제 0 N 냅색인가
    /// 그럴텐데 동전 무제한이라
    /// ㄱㄱㄱ
    /// 
    
    static int N,M;
    static int[] coin;
    static int[][] memo;    

    static int dfs(int idx, int money){
        if(money > M) return 0;
        if(money == M ) return 1;
        if(memo[idx][money] != -1) return memo[idx][money];

        int a = 0;
        for(int i = idx; i < N; i++){
            
            int b = dfs(i,money+coin[i]);
            a += b;
        }
        memo[idx][money] = a;
        return memo[idx][money];

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++){
            N = Integer.parseInt(br.readLine());
            coin = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) coin[i] = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(br.readLine());
            memo = new int[N][M+1];
            for(int i = 0; i < N; i++) Arrays.fill(memo[i], -1);
            sb.append(dfs(0,0) + " \n");
        }
        System.out.println(sb);
    }
}