import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int K;
	static int[][] arr;
	static StringBuilder sb = new StringBuilder();
	static ArrayList<Integer> list;

	public static void find(int idx, int sum, int weight){
		if(weight > K){
			return;
		}
		if(idx == N){
			list.add(sum);
			return;
		}
		find(idx+1,sum, weight);
		find(idx+1,sum+arr[idx][0], weight + arr[idx][1]);

	}
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case<= T; test_case++ ){
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			arr = new int[N][2];
			for(int j = 0; j < N; j++){
				st = new StringTokenizer(br.readLine());
				arr[j][0] = Integer.parseInt(st.nextToken());
				arr[j][1] = Integer.parseInt(st.nextToken());
			}
			list = new ArrayList<>();
			find(0,0,0);
			Collections.sort(list);
			sb.append("#" + test_case + " " + list.get(list.size()-1) +"\n");
		}

		System.out.println(sb.toString());
        br.close();
    }
}