import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{
	
	
	public static void main(String[] args)  throws Exception{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] memo = new int[N+3];
		memo[1] = 1;
		memo[2] = 2;
		for(int i = 3; i <= N; i++) {
			memo[i] = (memo[i-1] + memo[i-2])%10007;
		}
		
		System.out.println(memo[N]);
		
	}
}
/// 9 를 채우기위해서는 8 채우는방식에 세로 하나 하거나  7채우는 방식에 가로가로 하거나 ( 세로세로안하는이유는 7에 세로하는순간 8이되어버려서 8이랑중복이기때문)



