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
        

        while (true) {
            String n = br.readLine();
            if (n.equals("0")) {
                break;
            }
            int left = 0;
            int right = n.length() - 1;
            while (true) {
                if(left >= right){
                    System.out.println("yes");
                    break;
                }
                if(n.charAt(left) != n.charAt(right)){
                    System.out.println("no");
                    break;
                }
                left += 1;
                right -= 1;
            }


        }

        br.close();


    }
}