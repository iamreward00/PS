import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {



    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String target = br.readLine();

        int cnt = 0;
        
        for(int i = 0; i < str.length(); i++){
            int len = 0;
            for(int j = 0; j < target.length(); j++){
                if(i+j >= str.length() ) continue;
                if(str.charAt(i+j) == target.charAt(j)) len++;
            }
            if(len == target.length()) cnt++;
            

        }

        System.out.println(cnt);


    }
}

/*

*/