import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[226];
		int dp[] = new int[50011];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;
		int idx = 2;
		int min_cnt = 0;

		for(int i = 3; i <= N; i++) {
			min_cnt = Integer.MAX_VALUE;
			if(i == idx*idx) {
				dp[i] = 1;
				idx++;
				continue;
			}
			
			for(int j = 1; j*j <= i; j++) {	

				int temp_num = dp[i-j*j]+dp[j*j] ;
				if(min_cnt > temp_num) {
					min_cnt = temp_num;
				}
			}
			dp[i] = min_cnt;
			 
			
		}
		
		System.out.println(dp[N]);

		
		br.close();
	}
	

}

// dp 1은 진짜 1표시한거임 ㅇㅇ 
// 그러니까 n 은 dp[n] 의값이겍ㅆ지?
// dp[2] 는 2임 1 1
// dp 3 은 3임 1 1 1
// dp4는 1임 2* 2
// dp5 는 dp[4] + 1 = 2이겠네?
// dp 6 = dp[5] + 1 = 3
// dp 7 = dp[6] + 1 = 4
// dp 8 = 2^2 + 2^2 해서 2 나옴
// dp 9 = 3^3 = 1 나옴
// dp 10 = 2
// dp 11 = 3
// dp 12 = 
// 규칙이 머지
// 1 + N-1 을 쭈우우우욱 해봐야할거같은데? min 하면서 ㅇㅇ  dp[i] + dp[N-i] 이거 min 쭉하면될듯?이거랑 이전꺼 +1한거 쭉하면될듯?
// 이전꺼 +1은 안해도되는게 dp[1] + dp[N-1] 이니까 dp 만돌려도 될듯?


//for(int j = 1; j < i/2+1; j++) {	
//	all_cnt ++;
//	int temp_num = Math.min( dp[i-1] + 1, dp[i-j]+dp[j] );
//	if(min_cnt > temp_num) {
//		min_cnt = temp_num;
//	}
//}