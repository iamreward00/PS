import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int white = 0; 
    static int blue = 0;  
    static int[][] paper; 

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        paper = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 분할 정복 함수 호출
        find(0, 0, N);

        System.out.println(white);
        System.out.println(blue);
    }

    public static void find(int row, int col, int size) {
        // 현재 영역의 색상이 모두 같은지 확인
        if (isColorSame(row, col, size)) {
            if (paper[row][col] == 0) {
                white++;
            } else {
                blue++;
            }
            return; // 재귀 종료
        }

        // 색상이 같지 않다면, 4분할하여 재귀 호출
        int newSize = size / 2;

        find(row, col, newSize);                           // 1사분면
        find(row, col + newSize, newSize);                 // 2사분면
        find(row + newSize, col, newSize);                 // 3사분면
        find(row + newSize, col + newSize, newSize);       // 4사분면
    }

    public static boolean isColorSame(int row, int col, int size) {
        int color = paper[row][col]; // 첫 번째 칸의 색상을 기준으로 삼음

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (paper[i][j] != color) {
                    return false; // 기준 색상과 다른 색이 발견되면 즉시 false 반환
                }
            }
        }
        return true; // 모든 칸의 색상이 같으면 true 반환
    }
}