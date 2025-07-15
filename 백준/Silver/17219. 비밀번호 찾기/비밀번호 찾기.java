import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<String, String> hmap = new HashMap<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String str1 = st.nextToken();
			String str2 = st.nextToken();
			hmap.put(str1, str2);
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++) {
			String key = br.readLine();
			sb.append(hmap.get(key) + "\n");
		}
		System.out.println(sb.toString());
	}
}