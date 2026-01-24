import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    /*
     * 16:17 시작
     * 쿠키가있구나
     * 
     * 빨간곳이 심장임
     * 머리는 심장 윗칸 1칸크기
     * 신체가 주어졌을때
     * 심장의 위치
     * 팔
     * 다리
     * 허리
     * 길이를 구하는거
     * 
     * 심장 x,y
     * 
     * 왼팔
     * 오른팔
     * 허리
     * 왼쪽다리
     * 오른다리
     * 
     * 처음나오는 * -> 머리
     * 그 바로 아래 -> 심장
     * 심장부터 왼쪽으로 쭉 -> 왼팔
     * 심장부터 오른쪽 쭉 -> 오른팔
     * 심장에서 아래까지 - > 허리
     * 허리 대각선왼쪽 -> 왼다리 시작
     * 허리 대각선 오른쪽 아래쭉 -> 오른다리 시작 
     * 
     */

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        char[][] map = new char[n][n];

        int hidx = -1;
        int hjdx = -1;

        for(int i = 0; i < n; i++){
            String str = br.readLine();
            for(int j = 0; j < n; j++){
                map[i][j] = str.charAt(j);
                if(map[i][j]=='*' && hidx == -1){
                    hidx = i;
                    hjdx = j;
                }
            }
        }

        int heart_i = hidx + 1;
        int heart_j = hjdx ;

        System.out.println(heart_i + 1 + " " + ( heart_j + 1));

        int left_arm = 0;
        for(int i = 0; i < heart_j; i++){
            if(map[heart_i][i] == '*'){
                left_arm++;
            }
        }
        System.out.print(left_arm + " ");
        int right_arm = 0;
        for(int i = heart_j+1; i<n; i++){
            if(map[heart_i][i] == '*'){
                right_arm++;
            }
        }
        System.out.print(right_arm + " ");
        
        int hurry = 0;
        for(int i = heart_i+1; i < n; i++){
            if(map[i][heart_j] == '*'){
                hurry++;
            }
        }
        System.out.print(hurry + " ");

        int left_leg_idx = heart_i + hurry;
        int left_leg_jdx = heart_j - 1;

        int left_leg_cnt = 0;
        for(int i = left_leg_idx; i < n; i++){
            if(map[i][left_leg_jdx] == '*'){
                left_leg_cnt ++;
            }
        }
        
        System.out.print(left_leg_cnt + " ");
        
        int right_leg_idx = heart_i + hurry;
        int right_leg_jdx = heart_j + 1;

        int right_leg_cnt = 0;
        for(int i = right_leg_idx; i < n; i++){
            if(map[i][right_leg_jdx] == '*'){
                right_leg_cnt ++;
            }
        }
        
        System.out.print(right_leg_cnt + " ");

    }
}