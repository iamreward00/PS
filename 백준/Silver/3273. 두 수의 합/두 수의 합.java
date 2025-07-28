import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int [] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int target = Integer.parseInt(br.readLine());
        int s = 0;
        int e = N-1;
        Arrays.sort(arr);
        int cnt = 0;

        
        while(s < e ){
            int temp = arr[s] + arr[e];

            if(temp == target){
                cnt++;
                s++;
            }
            else if(temp > target){
                e--;
            }
            else{
                s++;
            }
        }
        System.out.println(cnt);
    }
}
