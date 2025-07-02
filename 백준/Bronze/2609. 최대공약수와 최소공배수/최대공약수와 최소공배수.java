import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());


        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Integer> brr = new ArrayList<>();
        
        if (a > b) {
            int temp = b;
            b = a;
            a = temp;
        }

        for ( int i = 1; i <= b/2+1; i++){
            if(a%i==0){
                arr.add(i);
                arr.add(a/i);
            }
            if (b%i==0) {
                brr.add(i);
                brr.add(b/i);
            }
        }
        int max_num = 0;


        for(int i = 0; i < arr.size(); i++){
            for(int j = 0; j < brr.size(); j++){
                int a_num = arr.get(i);
                int b_num = brr.get(j);
                if( a_num == b_num ){
                    if(max_num < arr.get(i)){
                        max_num = arr.get(i);
                    }
                }
            }
        }


        long a_cnt = a;
        long b_cnt = b;

        while (a_cnt!=b_cnt) {
            if(a_cnt > b_cnt){
                b_cnt += b;
            }
            else if (a_cnt < b_cnt) {
                a_cnt += a;
            }
        }

        System.out.println(max_num);
        System.out.println(a_cnt);
        br.close();


    }
}