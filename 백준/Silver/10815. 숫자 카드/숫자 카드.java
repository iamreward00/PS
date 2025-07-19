import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main{
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int M;
	static int[] arr;

	public static boolean check(long num){
		long sum = 0;
		for(int i = 0; i < N; i++){
			if(arr[i] >= num){
				sum += arr[i] - num;
			}
		}
		if( sum >= M ){
			return true;
		}
		return false;
	}

	public static void main(String[] args) throws Exception{
		
		N = Integer.parseInt(br.readLine());
		HashMap<Integer, Integer> map = new HashMap<>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++){
			map.put(Integer.parseInt(st.nextToken()), null);
		}
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		for(int i = 0; i < M; i++){
			int temp = Integer.parseInt(st.nextToken());
			if(map.containsKey(temp)){
				sb.append(1 + " ");
			}
			else{
				sb.append(0 + " ");
			}
		}
		System.out.println(sb.toString());
		br.close();

		
	}
}
