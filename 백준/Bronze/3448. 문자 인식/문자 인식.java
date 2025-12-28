import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {



    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        
        String s = "1";
        for(int i = 0; i < n; i++){

            int total = 0;
            int cnt = 0;
            
            
            while((s = br.readLine()) != null && !s.isEmpty()){
                for (int j = 0; j < s.length(); j++) {
                    total++;
                    if (s.charAt(j) != '#') cnt++;
                }
            }

            double ans = (double) cnt / total * 100;
            
            ans = Math.round(ans * 10) / 10.0;

            System.out.print("Efficiency ratio is ");
            if (ans % 1 == 0) System.out.print((int) ans);
            else System.out.print(ans);
            System.out.println("%.");
        
        }


    }
}

/*

*/