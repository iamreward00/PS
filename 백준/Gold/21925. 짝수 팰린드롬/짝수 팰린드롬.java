import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    /*
     * 일요일 15시 17분
     * 커피와 알고리즘
     * 드가자
     * 
     * 짝수 팰린드롬
     * 팰린드롬이머지
     * 
     * 아
     * 
     * 2 2   뒤집이도 22 다
     * 흠
     * 
     * 수열 나누었을때 모든 부분이 펠린드롬이여야함
     * 숫자 길이 짝수
     * 
     * 1 1 5 6 7 7 6 5 5 5
     * (1, 1), (5, 6, 7, 7, 6, 5), (5, 5)
     * 
     * 
     * 1 1 1 1 1 1
     * (1, 1), (1, 1), (1, 1)
     * 
     * 수열이니까
     * 앞에서부터 가야겠네요?ㅣ
     * 
     * 팰린드롬이 무조건 많아야하네요?
     * 팰린드롬이면 무조건 짤라야하나요?
     * 내말은
     * 
     * 7 7 56 65 였도도
     * 짜르네요
     * 
     * 펠린드롬이 많아야해요
     * 
     * idx는 늘어나기만하네요
     * 
     * N은 5천
     * Ai 는 1만
     * 
     * 안될경우 -1 인데
     * 
     * 왼쪽-> 오른쪽 탐색하면서
     * 팰린 탐색 매번 해주면 안되나?
     * 
     * N 5000 이자나
     * 이제
     * 2칸일때 체크
     * 4칸일떄 체크
     * 맞네? 그럼 그 다음칸붙 ㅓ체크
     * 
     * 이거 이중포문 느낌이니가
     * N^2 이니까 시간 ㄱㅊ은데
     * 드가자~
     * 
     * while 문을해도될꺼같고
     * idx 하나로 관리해도 될꺼같은데
     * 체크하다가
     * 마지막때 체크? 하고
     * 한번더 체크해주면될듯
     * 
     * 아 펠린드롬 체크 잘못했나봐요
     * 반짤라서 하는게 아닌가봐요
     * 
     * 2 1 1 2 같은거면
     * 아니 맞지않나
     * 반짤라서 하는거 맞는데 흠
     * 
     * 
     */

    static boolean find(ArrayList<Integer> list){
        int size = list.size();
        for(int i = 0; i< size/2; i++){
            int a = list.get(i);
            int b = list.get(size-i-1);/// 설마 Integer 이여서 int 로 바꿔보고 다시
            if(a!= b) return false;
        }
        
        return true;
        
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)arr[i] = Integer.parseInt(st.nextToken());

        int idx = 0;
        ArrayList<Integer> list = new ArrayList<>();

        boolean check = false;
        int cnt = 0;
        while(idx+1 < n ){
            list.add(arr[idx++]);
            list.add(arr[idx++]);
            if(find(list) ){
                check = true;
                list = new ArrayList<>();
                cnt++;
            }
            else{
                check = false;
            }

            
        }
        if(list.size()>0){
            System.out.println(-1);
        }
        else{
            System.out.println(cnt);
        }

    }
}