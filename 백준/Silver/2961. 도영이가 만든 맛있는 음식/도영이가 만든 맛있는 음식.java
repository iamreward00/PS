import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



/// 백준 2961 - 도영이가 만든 맛있는 음식
/// https://www.acmicpc.net/problem/2961
public class Main {
    /// 우리반장님이 짜파구리 요리사로 명성이 자자했다
    /// 새로운 요리를 도전하려고 하십니다 멋지힙니다 역시 우리 반장님 최고입니다
    /// N 개의 재료 신맛 S 쓴맛 B 
    /// 신맛은 곱
    /// 쓴맛은 합
    /// 신맛과 쓴맛의 차이가 적게
    /// 근데 하나이상은 선택해야함
    /// 이거 모든조합, 부분집합 powerset 에서 가장 작은 그 값 뽑으면 될듯?
    /// 가장 작은 신맛과 쓴맛의 차이가 정답이네 ㅇㅋ ㄱㄱ
    /// 선택하고안하고~ 솔직히 이게 젤 편한듯? 선택하고 안하고 
    /// N = 입력될 음식의 수 
    /// S B 가 한꼴로 N 개가 들어옴 -> 이차원 배열 ㄱㄱ[N][2]
    /// 두가자 ㄱㄱ
    /// 신맛 쓴맛 모두 1,000,000,000 보다 작은 양의정수임 이거 10억인가 int 써도 되겠네

    static int N;
    static int min = 1999999999; /// 모든비교에 같은 min 값이 쓰이니 여기서 초기화했음
    static int[][] food;
    
    static boolean[] vis;
    static int dfs(int idx){ // 여기서 idx 는 인덱스용도 + 살펴본 음식개수들 dfs(1) 이면 현재 살펴본 음식은 1개다
        if(idx == N){ // N개 음식 다 살펴봤으면 종료해야지
            int sin = 1; //// 이거 곱이니까 초기값 1로 해줘햐ㅑㅁ
            int dal = 0;
            boolean check = false; //  이거 하나도 안뜰어왔을때 대비 체크용임
            for(int i = 0; i < N; i++){
                if(vis[i]){
                    sin *= food[i][0];
                    dal += food[i][1];
                    check = true;
                }
            }
            int temp = Math.abs(sin-dal);
            if( check && temp < min ){ // 여기서 확인용 
                min = temp;
            }

            return 0 ;
        }

        vis[idx] = true;
        dfs(idx+1);
        vis[idx] = false;
        dfs(idx+1);
        return 0;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        food = new int[N][2];
        
        vis = new boolean[N];
        
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            food[i][0] = Integer.parseInt(st.nextToken()); // 0 은 신맛 신맛은 곱
            food[i][1] = Integer.parseInt(st.nextToken()); // 1 은 쓴맛 쓴맛은 합
        }

        dfs(0);

        System.out.println(min);


    }
}