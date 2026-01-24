import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());

        for (int y = x + 1; y <= 9999; y++) {
            int a = y / 100;
            int b = y % 100;

            if ((a + b) * (a + b) == y) {
                System.out.println(y);
                return;
            }
        }

        System.out.println(-1);
    }
}