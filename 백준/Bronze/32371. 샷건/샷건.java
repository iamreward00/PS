import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static char[][] arr = new char[4][10];
    static String str;

    static boolean check(int r, int c) {
        String tmp = "";
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                tmp += arr[r + i][c + j];
            }
        }

        char[] sub = tmp.toCharArray();
        Arrays.sort(sub);
        
        return str.equals(new String(sub));
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for (int i = 0; i < 4; i++) {
            String s = br.readLine();
            for (int j = 0; j < 10; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        char[] t = br.readLine().toCharArray();
        Arrays.sort(t);
        str = new String(t);

        for (int i = 1; i < 3; i++) {
            for (int j = 1; j < 9; j++) {
                if (check(i, j)) {
                    System.out.println(arr[i][j]);
                    return;
                }
            }
        }
    }
}

/*

*/