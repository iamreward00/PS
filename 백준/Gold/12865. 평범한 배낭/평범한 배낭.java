import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	

	
	static int N,M;
	static int[][] arr;
	static int[][] memo;
	
	static int dfs(int idx, int kg) {
		if(kg<0) return -1999999999;
		if(idx == -1) return 0;
		if(memo[idx][kg] != -1) return memo[idx][kg];
		
		memo[idx][kg] = Math.max( dfs(idx-1,kg-arr[idx][0])+arr[idx][1] , dfs(idx-1,kg)); 
				
		return memo[idx][kg];
		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][2];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken()); /// 무게
			arr[i][1] = Integer.parseInt(st.nextToken()); /// 가치
		}
		memo = new int[N][M+1];
		for(int i = 0; i < N; i++) Arrays.fill(memo[i], -1);
		dfs(N-1,M);
		
		System.out.println(memo[N-1][M]);
	}
}
