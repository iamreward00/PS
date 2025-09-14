import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N+1][M+1];
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] map = new int[N+1][M+1];
        for(int i = 1; i<= N; i++){
            for(int j = 1; j <= M; j++){
                map[i][j] = map[i-1][j] + map[i][j-1] - map[i-1][j-1] + arr[i][j];
            }
        }

        int min = 1999999999;
        // (i, j)  (i+a-1, j+b-1)    (i, j+b)  (i+a-1, j+b+c-1)
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                if (i + a - 1 > N || j + b + c - 1 > M) break;
                int aa = map[i + a - 1][j + b - 1] - map[i - 1][j + b - 1] - map[i + a - 1][j - 1] + map[i - 1][j - 1];
                int bb = map[i + a - 1][j + b + c - 1] - map[i - 1][j + b + c - 1] - map[i + a - 1][j + b - 1] + map[i - 1][j + b - 1];

                min = Math.min(aa+bb, min);
            }
        }

        
        // (i, j)  (i+a-1, j+c-1)   (i+a, j+c) (i+a+b-1, j+a+c-1)
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                if (i + a + b - 1 > N || j + a + c - 1 > M) break;
                int aa = map[i + a - 1][j + c - 1] - map[i - 1][j + c - 1] - map[i + a - 1][j - 1] + map[i - 1][j - 1];
                int bb = map[i + a + b - 1][j + a + c - 1] - map[i + a - 1][j + a + c - 1] - map[i + a + b - 1][j + c - 1] + map[i + a - 1][j + c - 1];
                min = Math.min(aa+bb, min);
            }
        }

        //  (i, j)  (i+a-1, j+b-1)    (i+a, j+b)  (i+a+c-1, j+a+b-1)
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                if (i + a + c - 1 > N || j + a + b - 1 > M) break;
                int aa = map[i + a - 1][j + b - 1] - map[i - 1][j + b - 1] - map[i + a - 1][j - 1] + map[i - 1][j - 1];
                int bb = map[i + a + c - 1][j + a + b - 1] - map[i + a - 1][j + a + b - 1] - map[i + a + c - 1][j + b - 1] + map[i + a - 1][j + b - 1];
                min = Math.min(aa+bb, min);
            }
        }




        System.out.println(min);   
    }
}