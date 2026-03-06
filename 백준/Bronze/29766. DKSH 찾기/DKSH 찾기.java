import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        
        int count = 0;
        
        for (int i = 0; i <= str.length() - 4; i++) {
            if (str.substring(i, i + 4).equals("DKSH")) {
                count++;
            }
        }
        
        System.out.println(count);
    }
}