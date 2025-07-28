import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] =  Integer.parseInt(st.nextToken());
        }
        int min = Integer.MAX_VALUE;
        int min_left = 0;
        int min_right = 0;

        int s = 0;
        int e = N-1;

        Arrays.sort(arr);

        while(s < e){
            int temp = arr[s] + arr[e];

            if(Math.abs(temp) < Math.abs(min)){
                min = temp;
                min_left = s;
                min_right = e;
            }
            if(temp > 0){
                e--;
            }
            else if(temp < 0){
                s++;
            }
            else if(temp==0){
                min = temp;
                min_left = s;
                min_right = e;
                break;
            }
            
        }
        System.out.println(arr[min_left] + " " + arr[min_right]);

    }
}
