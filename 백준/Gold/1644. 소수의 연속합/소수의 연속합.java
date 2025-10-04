import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {




    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        ArrayList<Integer> list = new ArrayList<>();
        
        int size = 4000100;
        boolean[] arr = new boolean[size+100]; 

        for(int i = 2; i*i <= size; i++){
            if(!arr[i]){
                for(int j = i*i; j<= size ; j+=i){
                    arr[j] = true;
                }
            }
        }
        for(int i = 2; i <= size; i++){
            if(!arr[i]){
                list.add(i);
            }
        }
        int end = list.size();
        int left = 0;
        int right = 0;
        int sum = 0;
        int cnt = 0;
        while(true){
            if(right == end) break;
            if(sum >= N){
                sum -= list.get(left);
                left ++;
            }
            else{
                sum += list.get(right);
                right++;
            }

            if(sum == N){
                cnt ++;
            }
        }
        
        System.out.println(cnt);

    }
}