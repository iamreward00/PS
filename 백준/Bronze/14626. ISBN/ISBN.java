import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String st = br.readLine();
        int sum = 0;
        int temp[] = {1,3};
        int check = 0;
        for (int i = 0; i < st.length(); i++) {

            if( st.charAt(i) == '*' ){
                check = temp[i%2];
                }
            else{
                sum += (temp[i%2] * Integer.parseInt(st.charAt(i)+"") );
                sum = sum%10;
            }
        }
        if(sum== 0){
            System.out.println(0);
        }
        else{
            for (int i = 0; i < 10; i++){
                if( 0 == (( check * i ) %10 + sum )%10){
                    System.out.println(i);
                    break;
                }
            }
        }
        
        br.close();
    }
}