import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;


public class Main {
		static int N,M;
		static HashSet<String> set = new HashSet<>();
		
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		find(1,"");
		ArrayList<String> list = new ArrayList<>(set);
		Collections.sort(list);
		for (String ans : list) {
			for(int i = 0; i < ans.length(); i++) {
				System.out.print(ans.charAt(i) + " ");
			}
			System.out.println();
		}
		br.close();
	}
	public static void find(int idx, String str) {
		if(idx > N+1) {
			return;
		}
		if(set.contains(str)) {
			return;
		}
		if(str.length() == M) {
			set.add(str);
		}

		
		find(idx +1,str + (idx+""));
		find(idx +1, str);
		
	}
	

}
