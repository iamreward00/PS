import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    /*
     * 와 주헌이는 취업성공했구나 부럽다....
     * 
     * 판자로 덮인 좌표는 자유롭게 건너갈 수 있음
     * 
     * 판자없는건 점프해야함
     * 정확한 위치여야함
     * 판자 양끝점 사이 아무데나 ㅏㅊㄱ지가능
     * 내가 마지막으로 점프하고 걸어온만큼 점프할수있음
     * 
     * 이거 무조건 앞쪽으로 뛰는게 맞는거같은데?
     * 이어지는지 확인하고 
     * 다음꺼 처음 뛸수있음??? 하는거네
     * 정렬되어들어오나? 아니네
     * 맨앞에거 기준으로 정렬하면 되겠네
     * 아 근데 두번쨰 예제에서
     * 만약 11 12라면?
     * 그냥 15가는게 이득이거잖아
     * 점프 뛸쑤있는곳 전부다 뛰어봐야겠는데?
     * 근데 다 뛴다기보단
     * 그냥 그 앞까지 뛰어봐야할거같은데?
     * 아니면 그 계산도 한번에 해버려도 될꺼같은데
     * 그러니까 일단 널려있는것들은
     * 0 - 9 이렇게 바꿔 보는거지
     * 그리고 이제
     * 큐에다가 넣어볼까
     * 분기 갈리는게 있으니까
     * 만약 저기 다음꺼 뛸수이쓴ㄴ걸 모두 넣는거지
     * 큐에 이제 어떻게 넣어보냐면
     * 마지막좌표, 점프가능값 , idx
     * 넣고 idx 부터 탐색하는거지 맨앞에거만 그리고 그게 된다면 큐에 이제
     * 그거의 마지막좌표, 그거의 점프가능값, idx 넣는거지
     * ㅇㅋ 좋다 가자
     * 근데 점프 가능값은 idx 에 있는데 넣을 필요가 있나 그래도 
     * 그리고 마지막 좌표도 idx 에있는데?
     * 이거 일차원으로 되겠네?
     * idx 에 다 있잖아
     * 마지막좌표, 점프가능값, 내 번호
     * 이거 그러면
     * 재귀돌릴떄 메모이제이션이 되는가!
     * 된다!!!!
     * 1차원 DP 로가자!!!
     * 
     * 
     * 
     * 
     * 
     */


    static int n;
    static int[][] arr;
    static int[][] map;
    static int[] memo;


    static int dfs(int idx){

        
        int start = map[idx][0];
        int end = map[idx][1];
        int jump = end - start;
        int max = end;
        
        if(memo[idx] != -1) return memo[idx];

        for(int i = idx+1; i < n; i++){
            int st = map[i][0];
            int ed = map[i][1];
            if(ed ==  0) break;
            if(st <= end + jump){
                max = Math.max(max,dfs(i));
            }
            else{
                break;
            }
        }

        memo[idx] = max;
        return memo[idx];
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n][2];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[i][0] = a;
            arr[i][1] = b;
        }
        
        Arrays.sort(arr, (o1 , o2) -> Integer.compare(o1[0], o2[0]));
        map = new int[n][2];
        map[0][0] = arr[0][0];
        map[0][1] = arr[0][1];
        int idx = 0;
        for(int i = 1; i < n; i++){
            if(map[idx][1] >= arr[i][0]){
                map[idx][1] = Math.max(map[idx][1], arr[i][1]);
            }
            else{
                idx++;
                map[idx][0] = arr[i][0];
                map[idx][1] = arr[i][1];
            }
        }
        
        //// 데이터 전처리 까지 끝 이제 찾아봅시다
        memo = new int[n+2];
        Arrays.fill(memo, -1);
        int ans = dfs(0);
        System.out.println(ans);
        
    }
}