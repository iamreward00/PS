import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int m;
	static ArrayList<String> list = new ArrayList<>();
	static HashSet<String> set = new HashSet<>();
	public static void find(int idx, int len, String sum) {
		
		if(len == m) {
			set.add(sum);
			return;
		}
		
		if(idx > n) {
			return;
		}
		
		if(set.contains(sum)) {
			return;
		}
		
		find(idx, len+1, sum + idx);
		find(idx + 1, len, sum);
		find(idx + 1, len+1, sum + idx);
		
		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		find(1,0,"");
		
		list = new ArrayList<>(set);
		
		Collections.sort(list);
		for (String string : list) {
			for(int i = 0; i < string.length(); i++) {
				System.out.print(string.charAt(i) +" ");
			}
			System.out.println();
		}

	}

}
