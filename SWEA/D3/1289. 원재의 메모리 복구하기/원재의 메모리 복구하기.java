import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {
	static char[] arr;
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
        for(int test_case = 1; test_case<= T; test_case++ ){
			String str = br.readLine();
			arr = new char[str.length()];
			
			for(int i = 0; i < str.length(); i++){
				arr[i] = str.charAt(i);
			}
			int cnt = 0;
			for(int i = 0; i< arr.length; i++){
				if(arr[i] == '1'){
					cnt ++;
					for(int j = i; j < arr.length; j++){
						if(arr[j] == '1'){
							arr[j] = '0';
						}
						else{
							arr[j] = '1';
						}
					}
				}
			}
			sb.append("#" + test_case + " " + cnt + "\n");


		}
		System.out.println(sb.toString());
        br.close();
    }
}