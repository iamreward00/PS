import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
boj.ma/15686
치킨 배달
*/
public class Main {


    static int n,m;
    static int[][] house;
    static int[][] chicken;
    static int[][] map;
    static int cdx,hdx;

    static ArrayList<int[]> list = new ArrayList<>();
    static int[] arr;
    static void init(int idx,int start){
        
        if(idx==m){
            int[] temp = arr.clone();
            list.add(temp);
            return;
        }
        
        for(int i = start; i < cdx; i++){
            arr[idx] = i;
            init(idx+1 ,i+1);
        }


    }

    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //System.out.println((13 * 12 * 11 * 10 * 9 * 8 )/ (6 * 5 * 4 * 3 * 2 * 1));

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        house = new int[n*2+1][2]; // 번호 x y 
        chicken = new int[14][2]; // 번호 x y 

        map = new int[n][n];

        hdx = 0;
        cdx = 0;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                int a = Integer.parseInt(st.nextToken());
                map[i][j] = a;
                if(a==1){
                    house[hdx][0] = i;
                    house[hdx][1] = j;
                    hdx++;
                }
                else if(a==2){
                    chicken[cdx][0] = i;
                    chicken[cdx][1] = j;
                    cdx++;
                }
            }
        }
        

        arr = new int[m];
        init(0,  0);

        // for(int[] i : list){
        //     System.out.println(Arrays.toString(i));
        // }

        
        int ans = 1999999999;
        for(int[] clist : list){
            int sum = 0;
            
            int len = clist.length;
            
            for(int i = 0; i < hdx; i++){ // 사람선택
                int hx = house[i][0];
                int hy = house[i][1];
                
                int min = 1999999999;
                
                for(int j = 0; j < len; j++){ /// 살아남은 치킨집 만큼 반복 
                    /// 현재 사람이랑 모든 치킨집중에서 가장가까운거 찾기 min 
                    int cx = chicken[clist[j]][0];
                    int cy = chicken[clist[j]][1];

                    int a = Math.abs(cx-hx);
                    int b = Math.abs(cy-hy);
                    min = Math.min(a+b, min);
                }
                sum += min;

            }
            ans = Math.min(ans, sum);
        }
        System.out.println(ans);

    }
}

/*
치킨먹고싶다

치킨 거리는 집과 가장 가까운 치킨집 사이의 거리이다.
치킨 거리는 집을 기준으로 정해지며
각각의 집은 치킨 거리를 가지고 있다

도시의 치킨 거리는 모든 집의 치킨 거리의 합

이걸 최소로 하라
두 칸 (r1, c1)과 (r2, c2) 사이의 거리는 |r1-r2| + |c1-c2|로 구한다.

집의 개수는 2N개를 넘지 않으며, 적어도 1개는 존재한다. 치킨집의 개수는 M보다 크거나 같고, 13보다 작거나 같다.

흠
집의 개수가 많아봤자 100개
치킨집은 많아봤자 13개 

그러면 
13C6은 얼마지 

(13 * 12 * 11 * 10 * 9 * 8 )/ (6 * 5 * 4 * 3 * 2 * 1)
1716

경우의 수는 총 많아봤자 1716 개인데 

이거 마다

근데 이제 집이 많아봤자 100 개니까
이거 다 돌아가면서 가장 가까운 치킨거리 찾으면 될거같은데  ?

그러니까 이제 집 번호가있고
치킨집 번호가 있어야겠지 ? 

흠
치킨집 번호 리스트를 미리 1716 경우의수를 다 뽑아놓자 ㅇㅇ 그게 맞다
그러고 이제
for 1716
    for 100
    해서 여기서 가장 가까운 그거 총 합들 다 해서 최소인거 출력하면 될듯 ?




*/