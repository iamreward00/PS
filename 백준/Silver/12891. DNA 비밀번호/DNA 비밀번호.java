import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;



/// 백준 12891 - DNA 비밀번호
/// https://www.acmicpc.net/problem/12891
public class Main { 
    
    /// 문자열이 오는데 이게 A C G T 만 있다
    /// 각 문자마다 최소 출현 개수가있음
    /// 그래서 전체 문자열에서 DNA 비밀번호 몇개 나오나? 가문제인데
    /// 이게 첨에 볼때 조합인줄알았는데 그냥 문자열 오른쪽으로 밀면서 가는
    /// 슬라이딩 윈도우네? 역시 문제를 끝까지 봐야합니다
    /// N개의 문자열길이 비밀번호조건은 M글자 이상
    /// 그리고 그다음으로 최소 개수가 나온다 
    /// ㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱ

    static int N,M;
    static String str;
    static int[] arr = new int[4]; // A C G T 4 고정 최소개수숫자입력받을배열
    static char[] chs = {'A','C','G','T'};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        str = br.readLine();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] strarr = new int[4]; // 내가 문자열 움직이면서 체크할 숫자

        for(int i = 0; i < M; i++){ // 여기서 0~ M-1 까지 체크 함
            for(int j = 0; j < 4; j++){
                if(str.charAt(i) == chs[j]){
                    strarr[j] ++;
                    break;
                }
            }
        }
        int cnt = 0;
        boolean check = true;

        for(int i = 0; i < 4; i++){
            if(arr[i] > strarr[i]){
                check = false;;
                break;
            }
        }
        if(check){
            cnt++;
        }
        /// 여기까지 한번 초기값세팅겸해준거


        for(int i = 1; i <= N-M; i++){ // 여기가 중요 맨처음꺼 빼고 새로운거 추가해줘야함
            for(int j = 0; j < 4; j++){
                if(str.charAt(i-1) == chs[j]){
                    strarr[j] --;
                    break;
                }
            }
            
            for(int j = 0; j < 4; j++){
                if(str.charAt(i+M-1) == chs[j]){
                    strarr[j] ++;
                    break;
                }
            }

            check = true; /// 여기서부터 반복하기
            for(int  j = 0; j < 4; j++){
                if(arr[j] > strarr[j]){
                    check = false;;
                    break;
                }
            }
            if(check){
                cnt++;
            }
            
        }
        System.out.println(cnt);

        }
    
}
