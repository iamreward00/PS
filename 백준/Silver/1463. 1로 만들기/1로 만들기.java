import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    
    static int[] dp;

    static int dfs(int num) {
        if (num == 1) {
            // System.out.println(cnt);

            return 0;
        }
        if (dp[num] != 0) {
            return dp[num];
        }

        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        int c = Integer.MAX_VALUE;

        if (num % 3 == 0) {
            a = dfs(num / 3) + 1;
        }
        if (num % 2 == 0) {
            b = dfs(num / 2) + 1;
        }
        c = dfs(num - 1) + 1;

        dp[num] = Math.min(a, Math.min(b, c));

        return dp[num];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        if( n == 1){
            System.out.println(0);
            return;
        }
        int m = dfs(n);

        System.out.println(m);
    }
}