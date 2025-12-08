import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;

    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        
        int adx = 1;
        int bdx = 1;

        int[] asum = new int[n+1];
        int[] bsum = new int[n+1];


        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            int cur = Integer.parseInt(st.nextToken());
            if(i%2==0){
                asum[adx] = asum[adx-1] + cur;
                adx++;
            }
            else{
                bsum[bdx] = bsum[bdx-1] + cur;
                bdx++;
            }
        }
        // System.out.println(Arrays.toString(asum));
        // System.out.println(Arrays.toString(bsum));
        //정훈 sum [i-1] + 상대sum[n] - 상대 sum[i-1];
        int max = asum[n/2];
        for(int i = 1; i <= n/2; i++){
            //System.out.println(asum[i-1] + " " + ( bsum[n/2] - bsum[i-1]));
            int a = asum[i-1] + ( bsum[n/2] - bsum[i-1]);
            int b = asum[i] + (bsum[n/2-1] - bsum[i-1]);
            max = Math.max(a,max);
            max = Math.max(b,max);
        }
        System.out.println(max);

    }
}

/*
14:36 시작 문제집 
동작그만
밑장뺴기냐?

N개의 카드와 2명의 플레이어가 있다
플레이어가 자신과 상대방에게 번갈아 가며 카드의 윗장부터 한 장씩 분배한다.
카드는 분배한 사람부터 받는다.
카드에 적힌 수의 합이 더 큰 사람이 이긴다
밑장 빼기는 최대 한번 할 것이다
정훈이가 최대 한번 밑장 빼기를 할 때 얻을 수 있는 최대 카드의 합을 구하여라.

정훈이 부터 받는데
밑장빼기 언제 할건지 인가봐요 ?

이기고 지는건 관심없고
정훈이가 얻을 수 있는 최대 카드의 합이네요 ? 
밑장빼기를 결국
1 2 3 4 5 6 있으면
1, 6 바뀌거나 
3, 6 바뀌거나 
5, 6 바뀌거나 인데 

최대카드합이라 

3 2 5 2 1 3

3
5
1 -> 3 
해서 11 인데요 

n 은 10만
카드 수는 1만 
흠
내 카드 목록중에서 맨밑장이랑 차이가 가장 클때 하면 되는거 아닌가 ?
내 카드 목록 합 이랑
min 값 가지고 있으면
맨밑장이랑 비교해서 그거만큼 더하면 되는거 아님 ?
뭐 없는거같은데

아
잠만
밑장을 빼면
순서가 바뀐ㄷ ㅏ
쉬운게 아니였네

그러니까

3 2 1 4 5 6 이면

정훈 3 6 4
상대 2 1 5

이렇게 순서가 바뀌네 
밑장을 빼는 순간 내가 얻을 카드랑 상대 카드랑 뒤바뀌네요 ?
그러면 n 번째 카드에서 밑장을 뺏을때
그 뒤는 상대의 i ~ n 번째 합을 가져가는거네요 ? 
밑장을 안뺏다면

3 1 5
2 4 6  인데 

2번째에서 밑장 뺴니까 그뒤는 다 상대꺼 선택하네요 ?
예제를 늘려볼까요

13 2 5 6 8 7 9 17

밑장안빼면 
13 5 8 9
2 6 7 17 
인데
밑장을 만약 5에서 뺀다고 치면 ?

13 17 6 7
2  5 8 9
5 8 9  가 상대한테 가네 맞네
와 신기하다 

그러면 누적합 을 일단 다 만들어 두고
i 번째에서 빼는거 해서 최대값 찾으면 될거같은데 ?
그러면 o ( N ) 일텐데

일단 누적합을 만들어정훈 sum [i-1] + 상대sum[n] - 상대 sum[i-1];

i 번째에서 카드를 바꾼다면 ?

내 합은 
정훈sum[0~i] + 상대sum[i~n]; 

하면서 최대값 찾기 하면 될거같아요 

잠깐잠깐잠깐잠깐잠깐잠깐잠깐잠깐잠깐잠깐잠깐잠깐
상대패도
밑장빼기가 가능하다....
순서를 바꾸는거니까 

100 70 10 20  이면

100 70
20  10

100 10
70  20
이 된다는거다 ..

100 70 10 40 30 20 50 60

100 10 30 50 
70 40 20 60

100 10 40 20
70  60 30 50


이거는 어떻게 바뀐거지 ? 
근데 상대때 밑장빼기한게 

상대에게 맨 마지막 값을 주고 내 뒤에껄 다준거네 ?
상대에서 밑장뺴기하면 
i 번쨰에서 했다고 하면 
상대의 i~ n/2-1 까지 의 핪이
내 arr[i] 부터인거네 ?
이걸 식으로 표현하면

asum[i-1] + (bsum[n/2-1] - bsum[i-1])

100 70 50 10

100 50
70 10

1    2
100 70
50 10

1 번쨰에서 상대 밑장뺴기했다면?





13 2 5 6 8 7 9 17

밑장x
13 5 8 9
2 6 7 17

5-> 17 밑장빼기했을때 
13 17 6 7
2  5  8 9



*/