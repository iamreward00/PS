import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		String st1;
		String st2;
		for(int i = 0; i < N; i++) {
			int M = Integer.parseInt(br.readLine());
			HashMap<String, Integer> map = new HashMap<>();
			Set<String> set = new HashSet<>();
			
			for(int j = 0; j < M; j++) {
				st = new StringTokenizer(br.readLine());
				st1 = st.nextToken();
				st2 = st.nextToken();
				map.put(st2, map.getOrDefault(st2, 0) + 1);

				set.add(st2);
			}
			int sum = 1;
			String st_arr[] = set.toArray(new String[M]);
			for(int j = 0; j < map.size(); j++) {
				sum *= (map.get(st_arr[j]) +1 );
			}
			System.out.println(sum-1);
		}
		
		
	}

}
