import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++){

			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			int[] list_num = new int[N];
			int len = 0;
			

			for (int i = 0; i < N; i++) { 
				
				int j = 0;
				for (j = 0; j < len; j++) {
					if (list_num[j] >= arr[i]) { 
						break; 
					}
				}
				
				list_num[j] = arr[i];
				
				if (j == len) {
					len++;
				}
			}
			sb.append("#" + test_case + " " + len + "\n");
			
		}


		System.out.println(sb.toString()); 
		br.close();
	}
}