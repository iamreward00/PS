import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        long[][] arr = new long[2][N];

        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Long.parseLong(st.nextToken());
            }
        }

        long[][] dp = new long[2][N];

        // 초기값
        // 시작점(0,0)에만 있으면 arr[0][0]
        // 시작점에서 아래로 갔다가 다시 위로 올 수도 있으므로 둘 중 최댓값
        dp[0][0] = Math.max(arr[0][0], arr[0][0] + arr[1][0]);
        // 시작점에서 아래로만 가면 무조건 두 칸을 다 밟음
        dp[1][0] = arr[0][0] + arr[1][0];

        // 2. 반복문을 이용해 점화식 계산 (j = 1부터)
        for (int j = 1; j < N; j++) {
            // 위쪽 칸(0, j)에 도착하는 경우
            // 1 (0, j-1)에서 옴 -> (0,j)만 먹음
            long a = dp[0][j - 1] + arr[0][j];
            
            // 2 (0, j-1)에서 옴 -> (0,j), (1,j) 둘 다 먹음
            long b = dp[0][j - 1] + arr[0][j] + arr[1][j];
            
            // 3 (1, j-1)에서 옴 -> (0,j), (1,j) 둘 다 먹음
            long c = dp[1][j - 1] + arr[0][j] + arr[1][j];

            dp[0][j] = Math.max(a, Math.max(b, c));
            

            
            // 아래쪽 칸(1, j)에 도착하는 경우
            // 1 (1, j-1)에서 옴 -> (1,j)만 먹음
            long aa = dp[1][j - 1] + arr[1][j];
            
            // 2 (1, j-1)에서 옴 -> (0,j), (1,j) 둘 다 먹음
            long bb = dp[1][j - 1] + arr[0][j] + arr[1][j];
            
            // 3 (0, j-1)에서 옴 -> (0,j), (1,j) 둘 다 먹음
            long cc = dp[0][j - 1] + arr[0][j] + arr[1][j];
            
            dp[1][j] = Math.max(aa, Math.max(bb, cc));
        }
        System.out.println(dp[1][N - 1]);
    }
}