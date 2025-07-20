import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] tails = new int[N];
        int len = 0;

        for (int num : arr) {
            int i = 0;
            while (i < len && tails[i] < num) {
                i++;
            }

            tails[i] = num;

            if (i == len) {
                len++;
            }
        }

        System.out.println(len);

        br.close();
    }
}