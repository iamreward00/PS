import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import javax.print.attribute.standard.PrintQuality;

public class Main {


    /*
    보석을 털어볼까!
    N 개의 보석이있음
    무게 M 가격 V 
    가방 K  가능무게 c
    한개의 보석만 넣을 수 있음
    최대가격은?

    보석 개수 N 30만
    가방 개수 K 30만
    무게 M 가격  V 100만
    가방무게 1억


    첫번째 줄에 N ,  K   보석개수 , 가방 개수 
    그다음 N 개의 줄에는 보석 정보  무게 , 가격  M, V
    그다음  K 줄에는 가방에 담을 수 있는 최대 무게 C 

    예제를 봐볼까!
    2 1
    
    5 10
    100 100

    11

    보석 2개
    가방1개
    11 무게 담을수있음
    
    글면 5 10 짜리 담아야지 
    10원이네

    흠
    
    3 2
    
    1 65
    5 23
    2 99
    
    10
    2

    이거라면 
    가방 무게가 10, 2 인데
    10 가방에 99 담고
    2 가방에 65 담으면 되겠네

    근데 이게 만약에

    3 65 였다면?

    못담으니까

    작은가방에서 그 때 젤큰거부터하는건가

    흠
    아니면 그건가
    보석에
    m v 이거 v기준 정렬하고

    3 2
    3 65
    5 23
    2 99
    10
    2
    
    이러면?
    10가방에 2 담고
    2가방에 못담네?

    10가방에 3을 담아야하네?
    2가방에 99 담아야하니까 
    
    작은가방에 담는게 우선인가?
    작은 가방에서 그중 가장 큰거 먼저 채워가는 느낌
    
    내가 현재 무게 가방에서 담을수있는 가장 큰놈을담야아할거같은데

    무게 , v   순으로 정렬인데

    흠
    30만개 인데 가방이 이게 

    무게 v 둘다 쓰고  이제 

    아 일단 가방 무게 기준으로 오름차순 정렬하고

    보석 무게 , 가격 기준으로 정렬하고    

    아 그래도 다 버리면 안되네
    이중포문이 안되니까 흠
    한번 슥 지나가면서 풀수있나
    아니면 이제
    가격 기준 정렬하고
    거기서 2가 되는지 본다? 는 너무 
    에반데 
    가방무게 전부 1이면 안됨 ㅇㅇ 이중포문이잖아 


    3 2
    3 65
    5 23
    2 99
    10
    2


    작은가방부터 채워!

    무게순으로 계속 추가해가!
    내말은 그러니까

    처음가방이 2면
    보석 무게 2 까지인거 다 추가해가! 어디에? 우큐에
    다넣어썽? 그럼 거기서 하나 뽑아 우큐니까 바로 뽑지? 
    그리고 그 큐에 계속 추가해가!!!!
    그다음 10 이면 10까지 다 추가해!
    와
    이거였네
    

    그러면 정렬을 보석무게로 하고 
    우큐에 넣으면 알아서 정렬이니까

    처음 가방 젤 작은게 2네?
    2이전까지 다 넣어
    거기서 하나 뽑아 우큐니까

    이ㅣ렴ㄴ 각가방 무게보다 낮은것 중에 최고치 뽑을 수 이썽

    자료형 long 봐야하나?
    V가 100만 인데
    이거 30만개있음ㄴ
    에이 터지겠지~ 
    합은 long 으로 세릴께
    


     */

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        // 보석
        int[][] arr = new int[n][2];
        for(int i = 0; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[i][0] = a;// 보석 무게
            arr[i][1] = b;// 가격 
        }

        // 가방
        int[] bag = new int[m];
        for(int i = 0; i < m; i++){
            bag[i] = Integer.parseInt(br.readLine());
        }

        // 가방 오름차순 ㄱㄱ
        Arrays.sort(bag);

        // 보석 무게 기준 ㄱㄱ
        Arrays.sort(arr, (o1, o2) -> Integer.compare(o1[0], o2[0]));

        // 큐 만들기
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        
        int idx = 0;
        long sum = 0;
        for(int i = 0; i < m; i++){
            int curbag = bag[i];
            while(idx < n  && arr[idx][0] <= curbag){
                pq.add(arr[idx++][1]);
            }
            if(pq.isEmpty()){
                continue;
            }
            sum = sum + pq.poll();
        }
        System.out.println(sum);
    }
}
