import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception { // 'throw' 대신 'throws'로 수정
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //선언
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[301];
        for(int i = 1; i < N+1; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        int dp[] = new int[301];
        dp[1] = arr[1];
        dp[2] = arr[2]+arr[1];
        dp[3] = Math.max(arr[1],arr[2]) + arr[3];
        for(int i = 4; i < N+1; i++){
            dp[i] = Math.max( dp[i-3] + arr[i-1], dp[i-2]) + arr[i];
        }
        System.out.println(dp[N]);
	}
}