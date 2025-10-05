
//https://www.acmicpc.net/problem/17479

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    /*
     * A개의 일반메뉴
     * B개의 특별메뉴
     * C개의 서비스메뉴
     * 
     * 특별메뉴는 일반에서 20,000 이상 주문해야 주문가능
     * 서비스는 일반메뉴+특별메뉴 >= 50,000 일때 가능
     * 서비스는 단 하나만 가능
     * 
     * 첫줄 A B C개의
     * A 개만큼 일반메뉴,가격
     * B 개만큼 특별메뉴, 가격
     * C 개만큼 서비스 메뉴
     * 
     * 주문 N 번 최대 150,000
     * 그리고 음식 나옴
     * 같은음식 여려번 가능
     * 아파벳은 소문자
     * 
     * 일반메뉴,특별메뉴,서비스메뉴 모두 이름 다름
     * 
     * long 써야하나
     * 가격 1,000,000    * 150,000
     * 150,000,000,000
     * 써야하네
     * 이거 안쓰다가 막 int 랑 비교하다가
     * 일반메뉴합 오버플로우 나서 
     * 특별메뉴 주문가능? 여기 if 문에서 삒날듯 ㅋㅋ
     */


    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        HashMap<String,int[]> map = new HashMap<>();
        for(int i = 0; i < A; i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            int p = Integer.parseInt(st.nextToken());
            map.put(str, new int[]{1,p});
        }

        for(int i = 0; i < B; i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            int p = Integer.parseInt(st.nextToken());
            map.put(str, new int[]{2,p});
        }

        for(int i = 0; i < C; i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            map.put(str, new int[]{3,0});
        }

        int N = Integer.parseInt(br.readLine());
        long onesum = 0;
        long allsum = 0;
        int scnt = 0;
        for(int i = 0; i < N ;i ++){
            String str = br.readLine();
            int[] cur = map.get(str);
            if(cur[0]==1){
                onesum = onesum + cur[1];
                allsum = allsum + cur[1];
            }
            else if(cur[0] == 2){
                allsum = allsum + cur[1];
            }
            else if(cur[0] == 3){
                scnt++;
            }
        }

        if(scnt > 1){
            System.out.println("No"); 
            return;
        } 
            

        if(allsum < 50000 && scnt != 0){
            System.out.println("No");
            return;
        }

        if(onesum < 20000 && allsum-onesum != 0){
            System.out.println("No");
            return;
        }
        System.out.println("Okay");
    }
}