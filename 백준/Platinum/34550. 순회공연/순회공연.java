import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    /*
     * 1~N 번까지 N 개의 도시 존재
     * 
     * 도시 -> 도시  하나씩 가지고 있음 일방통행임
     * 아 이거 나가는 길이하나! 일단 체크!
     * 
     * N명의 가수가 내일부터 순회 공연을 하는데
     * 특정 도시에서 시작해 매일 도로를 따라 이동하면서 공연을함
     * 순회공연을 하는 도중 어떤  도시에서 K 명 이상의 가수가공연을 하면 
     * 그날 그냥 밤새 공연하는거야
     * 
     * 밤샘공연을 하면 가장 빠른게 며칠차인지
     * 없으면 - 1
     * 
     * 입출력 보면
     * 첫째줄에 도시의수 N, 밤샘공연 최소 공연자수 K
     * N <= 100,000 
     * k <= N명의
     * 
     * 두번쨰줄 N 개의 정수
     * i 도시에서 ai 로가는 동로가 있음을 의미
     * 다음줄에 S1 인데
     * i 번째 가수는 Si 도시에서 순회 공연을 시작함을 의미
     * 4 3
     * 2 3 1 1
     * 2 3 4 4
     * 
     * 4 3 
     * 도시수 4 최소 공연인원 3명
     * 
     * 2 3 1 1 
     * 1번 -> 2번 존재
     * 2번 -> 3번 존재
     * 3번 -> 1번 존재
     * 4번 -> 1번 존재
     * 
     * 2 3 4 4
     * 1번사람 2번도시에서 시작
     * 2번사람 3번도시에서 시작
     * 3번사람 4번도시에서 시작
     * 4번사람 4번도시에서 시작
     * 
     * 예제 따라가보면
     * 
     * 1일차에
     * 1번사람은 2번도시
     * 2번사람은 3번도시 
     * 3번사람은 4번도시 
     * 4번사람은 4번도시 
     * 
     * 2일차에
     * 1번사람은 3번도시 
     * 2번사람은 1번도시 
     * 3번사람은 1번도시
     * 4번사람은 1번도시
     * 
     * 해서 2일차에 되는거임 ㅇㅇㅇㅇㅇㅇ
     * 
     * 
     * 근데 이거 N 명이고 도시가 N 개인데
     * 일일이 다 저거 하면서 하면
     * N * N 일텐데
     * 시간초과 나겠네
     * 그러니까 내말은 N번 반복 하는거지 저 이동을
     * 근데 그게 느리니까
     * 미리 알 수 없을까? x 일 뒤를?
     * 
     * 1 일차에 Si 번 도시에서 공연을 하면
     * x 일차 뒤에서 c번도시에서 공연을 했다면
     * x+1 일차에는 Ac ( c번도시에서 나가는 일방통행길) 에서 공연한다 잖아
     * 
     * 지금 예제가
     * 
     * 도시 예제가 
     * 1번 -> 2번 존재
     * 2번 -> 3번 존재
     * 3번 -> 1번 존재
     * 4번 -> 1번 존재
     * 2 3 1 1  이면 각 도시에서 공연했다면? 그다음 공연위치는
     * 3 1 2 2  가되는거지 ㅇㅇ  그다음은?
     * 1 2 3 3  그다음은 
     * 2 3 1 1  자 이거 보면 2 3 1 2 3 1 반복이긴 한데 이제
     * 
     * 이제 2일뒤는 내 다음 도시의 다음이지?
     * 근데 4일뒤는 내 2일뒤 도시의 2일뒤고
     * 근데 8일뒤는 내 4일뒤 도시의 4일뒤야
     * 이거 이용하면
     * log 만에
     * 2, 4, 8 , ...... 1024 ..... 2의 제곱꼴 날짜는 다 기록할수있음
     * 근데?
     * 내가만약에
     * 13일 뒤를 알고싶어
     * 이건뭐냐면
     * 1일뒤 + 4일뒤 + 8일뒤 이렇게
     * 찾을수있음
     * 이진분할 인거지
     * 이진수로 다 나태낼수있으니까
     * ㅇㅇ 그런거지
     * 해서 일단 저 희소 배열을 만들면
     * heso[i][j]   i 가 뜻하는건 i번 도시   뒤에 j 가 뜻하는건 j일 뒤
     * 즉
     * heso[1][0] = 없고
     * heso[1][1] = 1번도시 다음인 2를 뜻하고
     * heso[2][1] = 3번 도시인데
     * 
     * 그러면?
     * heso[1][2] = 2번도시의 1일뒤니까 3번인거지
     * 이런식으로 가는거지
     * 
     * ------------------------------------------
     * 희소배열 저렇게 만들면 10만 * 10만이여서 메모리 초과남
     * 그러니까 10만 * 20 해야함
     * 왜냐면 2^20 은 10만 언저리여서
     * 저거를 그러니까
     * 2^0 일 이떄의 위치 라고 봐야함
     * heso[1][4] 는 1번 에서 시작했을때 2^4 일 뒤 위치의 값을 가지고있는거임
     * 주의주의 
     * ----------------------------------------------
     * 
     * 그래 그러면 그렇게 만들었어 
     * log n 을 써서 저 2의거듭제곱 일에 어디서 공연하는지 기록을했고
     * 그걸 이용해서 모든 날짜에 공연위치를 알아
     * 그러면 이제?
     * 
     * 이제..
     * 자자자자자
     * 
     * 2일차에
     * 1번사람은 3번도시 
     * 2번사람은 1번도시 
     * 3번사람은 1번도시
     * 4번사람은 1번도시
     * 
     * 여기서 그럼
     * 3일차는?????????
     * 2,3,4 번 다같이 이동하겠죠? 그럼 또 밤샘 공연하겠죠?
     * 4일차는??????????? 
     * 또 
     * 2,3,4 번 다같이 이동하겠죠? 그럼 또 밤샘 공연하겠죠?
     * 
     * 이거 무슨꼴이야?
     * xxxxxxxoooooooooooooooooooooo 꼴인거잖아
     * 
     * 그러면 처음 o인 위치를 찾는 lowerbound 문제인거지
     * 
     * 그러면 우리는
     * 1. 저기 희소배열 2의 거듭제곱꼴 만든다
     * 2. check( mid) 해서 mid 일이 밤샘공연인지 확인한다
     * 3. 만약 그렇다면 right = mid - 1  아니라면 left = mid + 1
     * 해서 o 가 처음 나오는 위치를 출력한다
     * 
     */



    static int n,m;
    static int[][] heso;
    static int[] Ai;
    static int[] Si;


    static boolean check(int idx){

        int[] cnt = new int[n+1];

        for(int i = 1; i <= n; i++){ ///// n개 도시 모두 mid 일 뒤를 찾아야함
            int cur = Si[i];
            // 비트연산에서 애 많이 먹었습니다.....
            for(int j = 0; j < 22; j++){
                if((idx & (1<<j)) !=  0 ){ // 만약 0이 아니라면! 그러면 있다는거니까
                    cur = heso[cur][j];  // cur 을 cur 이 2^j 뒤 도시로 바꾸는거지
                }
            }
            cnt[cur] ++; // cur 도시에 공연인원 ++

        }

        for(int i = 1; i <=n; i++){
            if(cnt[i] >= m){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m  = Integer.parseInt(st.nextToken());

        Ai = new int[n+1];
        Si = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) Ai[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) Si[i] = Integer.parseInt(st.nextToken());
        
        heso = new int[n+1][30];

        for(int i = 1; i <= n; i++) heso[i][0] = Ai[i];

        for(int i = 1; i < 22; i ++){
            for(int j = 1; j <= n; j ++){
                heso[j][i] = heso[heso[j][i-1]][i-1]; // j 도시의 2^i 일뒤 위치는  j 도시의 2^(i-1)의 도시에  2^(i-1)일 뒤 도시
            }
        }
        /// 이제 이진탐색
        int left = 0;
        int right = n;

        while(left <= right){
            int mid = (left+right)/2;
            if(check(mid)){//lowerbound 니까 왼쪽으로 가야하니까 right  = mid -1;
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        
        if (left > n) {
            System.out.println(-1);
        } else {
            System.out.println(left+1);
        }

    }
}