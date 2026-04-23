import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int s = Integer.parseInt(br.readLine());
        int f = Integer.parseInt(br.readLine());
        
        if (s <= f) {
            System.out.println("high speed rail");
        } else {
            System.out.println("flight");
        }
    }
}