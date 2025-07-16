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
		int arr[] = new int[11];
		arr[0] = 0;
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 4;
		arr[4] = 7;
		for(int i = 5; i < 11; i++) {
			arr[i] = arr[i-1] + arr[i-2] + arr[i-3];
		}
		for(int i = 0; i< N; i++) {
			System.out.println(arr[quest[i]]);
		}
	}

}
//왜 점화식이 저런것인가?
//1 = 1
//2 = 1+1 , 2
//3 = 1+1+1, 2+1, 1+2, 3
//4일때 
//1 + 3
//2 + 2
//3 + 1
//
//일때 + 3, +2 ,+1 이것을 arr[3], arr[2] , arr[1] 로 표현할수있다
//왜냐? N-1 에서 1더하기 N-2에서 2더하기 N-3 에서 3더하기 이기 때문이다
//		