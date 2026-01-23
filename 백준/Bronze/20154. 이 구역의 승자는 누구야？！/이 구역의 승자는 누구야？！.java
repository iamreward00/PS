import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        
        int[] arr = {3, 2, 1, 2, 3, 3, 3, 3, 1, 1, 3, 1, 3, 3, 1, 2, 2, 2, 1, 2, 1, 1, 2, 2, 2, 1};
        
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += arr[s.charAt(i) - 'A'];
        }

        if (sum % 2 != 0) {
            System.out.println("I'm a winner!");
        } else {
            System.out.println("You're the winner?");
        }
    }
}