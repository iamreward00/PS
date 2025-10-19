import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        
        int n = Integer.parseInt(br.readLine());


        int[] arr = new int[n+5];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) arr[i] = Integer.parseInt(st.nextToken());
        arr[0] = -1999999999;
        arr[n+1] = 1999999999;
        arr[n+2] = 1999999999;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i =1; i < n; i++){
            if(arr[i] > arr[i+1]){
                list.add(i);
            }
        }

        if(list.size() == 0){
            System.out.println(n);
            return;
        }
        if(list.size()>=2){
            System.out.println(0);
            return;
        }
        int cnt = 0;
        int idx = list.get(0);
        int left = arr[idx-1];
        if(left <= arr[idx+1]) cnt ++;

        int right = arr[idx+2];
        if(right >= arr[idx]) cnt++;
        System.out.println(cnt);


    }
}
