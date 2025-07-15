import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int arr[] = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int sum_num = 0;
		int cnt = 0;
		int idx = N-1;
		while(idx >= 0) {
			if(sum_num == M) {
				System.out.println(cnt);
				break;
			}
			if(sum_num + arr[idx] > M ) {
				idx--;
				continue;
			}
			else {
				sum_num += arr[idx];
				cnt++;
			}
			
		}
		
	}
}