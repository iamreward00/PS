import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        

        int n = Integer.parseInt(br.readLine());

        String st = br.readLine();

        int num_arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            num_arr[i] = st.charAt(i) - 'a' + 1;
        }
        long sum_num = 0;

        for (int i = 0; i < n; i++) {
            long temp_num = (long) (num_arr[i] * Math.pow(31, i) ) % 1234567891  ;
            sum_num = sum_num +  temp_num;
        }

        System.out.println(sum_num);
        br.close();


    }
}