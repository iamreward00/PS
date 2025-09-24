import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int bis(int num, int[] memo, int len){

        int left = 0;
        int right = len;    

        while(left <= right){
            int mid = (left+right)/2;
            if(num >= memo[mid]){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }

        return left;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());

        int[] memo = new int[N];
        int len = 1;
        memo[0] = arr[0];
        
        for(int i = 0; i < N; i++){
            if(memo[len-1] < arr[i]){
                memo[len++] = arr[i];
            }
            else if( memo[len-1] > arr[i]){
                int idx = bis(arr[i], memo,len);
                memo[idx] = arr[i];
            }
        }

        System.out.println(N-len);

    }
}