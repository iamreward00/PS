import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main{

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int quest[] = new int[N];
		for(int i = 0; i < N; i++) {
			quest[i] = Integer.parseInt(br.readLine());
		}
		long arr[] = new long[101];
		arr[0] = 0;
		arr[1] = 1;
		arr[2] = 1;
		arr[3] = 1;
		arr[4] = 2;
		arr[5] = 2;
		arr[6] = 3;
		arr[7] = 4;
		arr[8] = 5;
		arr[9] = 7;
		arr[10] = 9;
		
		for(int i = 11; i < 101; i++) {
			arr[i] =  arr[i-2] + arr[i-3];
		}
		for(int i = 0; i< N; i++) {
			System.out.println(arr[quest[i]]);
		}
	}

}

// 이거는 점화식이 그냥 보였어 i-2 + i-3  이거는 그냥 보였음 ㅇㅇ
