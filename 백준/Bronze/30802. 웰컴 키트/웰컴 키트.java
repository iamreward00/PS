import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[6];
        for (int i = 0; i < 6; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int t_cnt = 0;
        int p_cnt = 0;
        int p_cnt2 = 0;
        for (int i = 0; i < arr.length; i++) {
            t_cnt += arr[i]/T ;
            if(arr[i]%T > 0){
                t_cnt+=1;
            }
        }

        p_cnt = N/K;
        p_cnt2 = N%K;

        System.out.println(t_cnt);
        System.out.println(p_cnt + " " + p_cnt2);
        
        br.close();

    }
}