import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
boj.ma/2873
롤로코스터
*/
public class Main {



    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];

        int tidx = 0;
        int tjdx = 0;
        int tmin = 199999999;

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                int a = Integer.parseInt(st.nextToken());
                map[i][j] = a;
                
                if((i%2==1 && j%2==0) || ( i%2==0 && j%2==1)){
                    if(tmin > a){
                        tmin = a;
                        tidx = i;
                        tjdx = j;
                    }
                }
            }
        }
        

        /// tidx tjdx 이제 정했으니까 
        /// tidx가 홀수면 -1 위치까지 
        if(tidx%2==1){
            tidx = tidx-1;
        }
        // 이제 t 행 바로 전까지 가야하는게 목표임 

        if(n%2==1){  /// 3 4 또는 3 3 같은게 옴 여기는 가로로 ㄹ 로

            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    for (int j = 0; j < m - 1; j++) {
                        sb.append("R");
                    }
                    if (i != n - 1) sb.append("D");
                } 
                else {
                    for (int j = 0; j < m - 1; j++) {
                        sb.append("L");
                    }
                    if (i != n - 1) sb.append("D");
                }
            }
        }

        else if(m%2==1){ /// 4 3 여기는 ㄹ이 기울어져서 세로로 
            
            for (int j = 0; j < m; j++) {
                if (j % 2 == 0) {
                    for (int i = 0; i < n - 1; i++) {
                        sb.append("D");
                    }
                    if (j != m - 1) sb.append("R");
                } 
                else {
                    for (int i = 0; i < n - 1; i++) {
                        sb.append("U");
                    }
                    if (j != m - 1) sb.append("R");
                }
            }
        }
        else{/// 여기는 짝짝
            // 여기선 3단계 우선 tidx -1 까지 ㄹ 자로 가기
            for(int i = 0; i < tidx; i++){
                if(i%2==0){
                    for(int j = 0; j < m-1; j++){
                        sb.append("R");
                    }
                }
                else{
                    for(int j = 0; j < m-1; j++){
                        sb.append("L");
                    }
                }
                sb.append("D");
            }

            // 그리고 이제 아래 오른쪽 위 오른쪽 하는데 만약 아래 or 위 쪽에서 금지칸이면 그냥 오른쪽 가고 다시 아까 하려던 아래나 위 하기

            String[] di = {"D","R","U","R"};
            int didx = 0;
            int curjdx = 0;
            

            for(int i = 0; i < 2*m-2; i++){
                if(curjdx == tjdx){
                    sb.append("R");
                    curjdx++;
                }
                else{
                    sb.append(di[didx%4]);
                    if(di[didx%4].equals("R")){
                        curjdx++;
                    }
                    didx++;
                }
            }

            
            // 그리고 이제 남은게 한칸 아래 갔다가 왼쪽 쭉 아래 오른쪽 쭉 반복 하기 
            
            for(int i = tidx+2; i < n; i++){
                if(i==tidx+2) sb.append("D");
                
                if(i%2==0){
                    for(int j = 0; j < m-1; j++){
                        sb.append("L");
                    }                    
                }
                else{
                    for(int j = 0; j < m-1; j++){
                        sb.append("R");
                    }   
                } 
                if(i != n-1) sb.append("D");
            }

        }

        
        System.out.println(sb);


    }
}

/*

한칸은 한번밖에 못지나가고
방문하지 않은 칸이 있어도 된다.
값은 1000보다 작은 양의 정수이다.

구해야하는건
어떻게 지나가면
최대가되는지 인데

그럼그먄
모든칸 다 가면되는거아님?


이게 예제가 일단
3 3
5 1 3
2 4 8
1 1 2

이거는 모든칸을 지날수있음 

2 2
2 1
3 4
이거는 모든칸을 지나지 못함


뭔가 한붓그리기 느낌나네
홀홀말고
홀짝은?
32
23

보면

2 3
5 1 3
2 4 8

3 2
5 1
2 4
3 8

이거는 둘다
한붓그리기가 가능함
i 가 짧으면 아래부터
j 가 짧으면 오른쪽부터 가는식으로 

그러면
5 4는?

3 2
5 1 4 5 
2 4 4 4
3 8 3 4
5 1 2 3
5 1 1 2

이것도 위랑 같다면
j가 짧으니까 오른쪽부터가면 되겠죠?
쭉끝까지

그러면 한붓그리기 가능

ㅇㅋ
홀짝이나
홀홀은
한쪽으로 쭉 가면도니다

근데
짝짝은?

6 6 해볼까

6 6
1 2 3 4 5 6
2 2 3 4 5 6
3 2 3 4 5 6
4 2 3 4 5 6
5 2 3 4 5 6
6 2 3 4 5 6

이거는 몇개의 칸을 최대한 지날수있을까
그림판 ㄱㄱ

쭉쭉 가고 

맨오른쪽 줄이랑
맨아래줄 줄
둘중하나를 완전히 날린다거나

지그재그해서 우측위에꺼만 날린다거나
지그재그해서 좌측아래 날린다거나

1,0 껄 날린다거나
0,1 껄 날린다거나 


아니 이게 경우가 좀 많은데

경우가 좀 많은데요...


이게 그러니까 
6 6 인데
66 안에 44 따로 보면
또 그 44 시작점까지는
다 탐색하면서 갈수있긴한데 ? 

진짜 딱 1개만
뺄수있을꺼같은데?

6 8으로 다시 ?
6 8
1 2 3 4 5 6 7 8
2 2 3 4 5 6 7 8
3 2 3 4 5 6 7 8
4 2 3 4 5 6 7 8
5 2 3 4 5 6 7 8
6 2 3 4 5 6 7 8

이게 결국
단 1칸만 뺄 방법이
무조건 존재하는가?

4 2 도 결국
2 2 가 되는구나 ?

그러니까 이건 그거네 
2 2 로 모두다 쪼개고
거기서 뺄수있는것만 있네

흠 그러면 이제
1칸을 뺄수있는데 그칸의 위치는 

홀수행의 경우에는 0번부터 한다카면 홀수칸
짝수행은 0번부터 한다면 짝수칸의 위치는 
다 뺼수가 있는걸 알았어 
그러면 이제 이걸 어떻게 구현해 ?

난 이제 구현이 문제같은데

근데 그게 꼭 정답인가 ?
음
한칸만 빼는게 정답이 아닐려면
모든 그 한칸짜리위치가 
다 높아야하는데
근데 그러면 결국
한줄쭉 빼는 그런거 
했을때
결국 걸러지니까

괜찮다고생각해!

잊제 진짜
구현을 어떻게 하지...?

다시 그림판....

이것도 더 짧은쪽을 먼저 가야하는거같은데
그려보니까

단계가 나눠질거같은데

그러니까 음

2,1 을 삭제한다고 쳐
그러면 그전까지는 쭉 가는걸로 완탐해

근데 이제 
2행이랑 3행? 쪽은 무조건 지그재그로 ? 

그러고 이제 그 안되는칸만나면
가던방향 한칸 더 가고
그다음이제 위나 아래로 가고 
이게 결국
2,2 블록이고
이건 2행단위로 짤려있으니까 

그러면 될거같은데 ? 

그러니까 

2,1 이라면

RRRRRRRRRRRRRRRRRRRRRR
D
LLLLLLLLLLLLLLLLLLLL
D
이제 중요
여기서 이제 
오른쪽 지그재그 하는데 안된다 ? 그러면 
이전 방향 한칸 더 가고 좌우 갈수있는칸으로? 지그재그 하면되나 

만약 지금이 삭제해야하는 세로 라인이 아니면 
아래 오른쪽 위 오른쪽 인ㄷ ㅔ

근데 2,1 이면 처음ㅇ ㅔ이제

아래 오른쪽 위 (여기서막힘)
그러면 이제 이전에 했던 오른쪽을 다시 하고
다시 위 로 하나보네  ?
3,2 면 ?

여ㅑ기도 이제 
2 번 행부터
아래 오른쪽 위 오른쪽 하는데 지금이 만약 삭제해야할곳이면 
그냥 이전에 했떤거 반복 인거같은데 

그냥 오른쪽으로
보내면될거같은데
아래 오른쪽 위 오른쪽 하다가
만나는게 결국
아래로갈때랑 위로갈때인데 

근데 2,2 일땐 안되는거아님 ?
2,2 일떈 그냥 하나 예외로 빼두나  내가직접계산하나
아 그냥
그

o o
x o  일때
나는
d r u r 이거 반복인데 원래 
처음에 이제 같은 열이니까
rd 를 하네 

결국 그 
삭제해야할거랑 같은 열이면 

어짜피 그냥 오른쪽으로 가니까 ?

그리고 이제 도착위치에서
한칸 아래 가고
왼쪽 쭉우우우욱
다시 아래   
오른쪽 쭈우우욱 하는
그런거겠네 ?
ㅇㅋㅇㅋ
그림 참
많이그렸다 그죠


그러면 단계가 3개인가 
1삭제해야하는 그 행 홀수면 -1 까지 가기
거기서 이제 
아래 오른쪽 위 오른쪽 하는데 
만약 아래나 위 에서 걸린단말이야 
그러면 그땐 그냥 오른쪽 하나 하고 다시 이어서 진행 
그리고 이제 도착위치가 
그 첨에 행 + 1 이랑 마지막 열 이니까 
거기서부턴 한칸아래 가고
쭉 반복


그림참....많이 그렸어요 ... 

*/