import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {

    public static int count(String[][] arr, int idx, int jdx) {
        
        int cnt1 = 0;
        int cnt2 = 0;
        String temp1[][] = new String[8][8];
        String temp2[][] = new String[8][8];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 0) {
                    temp1[i][j] = "W";
                    temp2[i][j] = "B";
                } else {
                    temp1[i][j] = "B";
                    temp2[i][j] = "W";
                }
            }
        }

        for (int x = idx; x < idx + 8; x++) {
            for (int y = jdx; y < jdx + 8; y++) {
                if (!arr[x][y].equals(temp1[x - idx][y - jdx])) {
                    cnt1++;
                }
                if (!arr[x][y].equals(temp2[x - idx][y - jdx])) {
                    cnt2++;
                }
            }
            
        }
        return Math.min(cnt1, cnt2);
    }
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String arr[][] = new String[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j) + "";
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N-7; i++){
            for (int j = 0; j < M-7; j++){
                int cnt = count(arr, i,j);
                min = Math.min(min, cnt);
            }
        }
        System.out.println(min);
        br.close();
    }
}