import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    
    static int[][] memo;
    static int[][] arr;

    
    public static int dfs(int st, int ed) {
        if (st == ed) {
            return 0;
        }

        if (memo[st][ed] != -1) {
            return memo[st][ed];
        }

        memo[st][ed] = Integer.MAX_VALUE;

        for (int k = st; k < ed; k++) {
            int cost = dfs(st, k) + dfs(k + 1, ed) +
                       arr[st][0] * arr[k][1] * arr[ed][1];
            
            memo[st][ed] = Math.min(memo[st][ed], cost);
        }

        return memo[st][ed];
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new int[N][2];
        memo = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            
            Arrays.fill(memo[i], -1);
        }

        System.out.println(dfs(0, N - 1));
    }

}