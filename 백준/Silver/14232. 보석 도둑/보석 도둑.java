import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        long n = Long.parseLong(br.readLine());
        ArrayList<Long> list = new ArrayList<>();
        

        for (long i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                list.add(i);
                n /= i;
            }
        }
        if (n != 1) {
            list.add(n);
        }
        Collections.sort(list);
        if(list.size()==0){
            System.out.println(1);
            System.out.println(n);
        }
        else{
            for(int i = 0; i < list.size(); i++) sb.append(list.get(i) + " ");
            System.out.println(list.size());
            System.out.println(sb);
        }
    }
}