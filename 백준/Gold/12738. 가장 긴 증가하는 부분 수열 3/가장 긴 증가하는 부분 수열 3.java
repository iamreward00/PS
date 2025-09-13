import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int len;
    static int[] memo;
	static int bs(int num) {
		int left =0;
		int right = len;
		
		while(left <= right) {
			int mid = (left+right)/2;
			
			if(memo[mid] >=num) {
				right = mid - 1;
			}
			else {
				left = mid +1;
			}
		}
		return left;
				
	}
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        memo = new int[N];
        len = 0;
        memo[0] = arr[0];

        for(int i = 0; i < N; i++){
            if(memo[len] < arr[i]){
                memo[++len] = arr[i];
            }
            else if(memo[len] > arr[i]){
                int idx = bs(arr[i]);
                memo[idx] = arr[i];
            }

        }
        System.out.println(len+1);

    }
}