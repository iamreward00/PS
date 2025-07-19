import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static int M;
	static int[] arr;

	public static int check(long num){
		int sum = 0;
		for(int i = 0; i < N; i++){
			sum += arr[i]/num;
		}
		return sum;
	}

	public static void main(String[] args) throws Exception{
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		long end = 0;

		for(int i = 0; i < N; i++){
			arr[i] = Integer.parseInt(br.readLine());
			if(end < arr[i]){
				end = arr[i];
			}
		}
		
		long left = 1;		
		long mid;
		
		while ( left <= end ){
			mid = (left+end)/2;
			
			if(check(mid) >= M){
				left = mid + 1;
			}
			
			else{
				end = mid - 1;
			}
			
		}
		
		System.out.println(left - 1);
		br.close();

		
	}
}
