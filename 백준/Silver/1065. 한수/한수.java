import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static boolean check(String str){

        int size = str.length();
        
        if(size <= 2) return true;
        if(str.charAt(0) - str.charAt(1) == str.charAt(1) - str.charAt(2)) return true;
        
        return false;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        for(int i = 1; i<= N; i++){
            if(check(i+"")) cnt++;
        }
        System.out.println(cnt);

    }
}