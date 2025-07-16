import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main{

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long arr[] = new long[N+5];
		arr[0] = 0;
		arr[1] = 1;
		arr[2] = 3;
		
		for(int i = 3; i<= N; i++) {
			arr[i] = ( arr[i-1] + arr[i-2] * 2 )%10007;
		}
		
		System.out.println(arr[N]);
		
		
		
	}

}

// 이문제는 이전에 풀었던 1,2,3 으로 합을 표현하라랑 비슷한데
// 결국 4는 3에서 1칸더한거 2에서 2칸짜리 더한거 이기 때문에
// 이전 문제에서는 1 + 3 , 2 + 2, 3 + 1 이였던게 이게 그냥 3+1, 2+2 인거지 왜? 3칸짜리는 의미없으니까 왜? 2+1 이니까 +1, +2 만 계산하는거지
// 이게 맨앞에있다고 생?각? 해서 하면될듯 ㅇㅇ? 그래서 1+arr[i-1] + 2+arr[i-2] 한거지 ㅇㅇ
// 근데 여기서 2x2 타일 자체가 추가된다? 그러면 그냥 그거 없는셈쳐 그러니까 내가 현재 2x2 추가해서 2x6 을만든다면 2x4 << 이거 뒤에 그냥 2x2 붙인다고생각해 그러니까
// i-2를 한번더 더해서 총 두번 하니까 *2 가 되는거야 이해했지?