import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        char c = s.charAt(0);

        if (c == 'F') {
            System.out.println("Foundation");
        } else if (c == 'C') {
            System.out.println("Claves");
        } else if (c == 'V') {
            System.out.println("Veritas");
        } else if (c == 'E') {
            System.out.println("Exploration");
        }
    }
}