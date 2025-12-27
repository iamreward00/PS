import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    static int n,m,q;
    static ArrayList<Integer>[] list;
    static int[] arr;
    static HashMap<Integer, Integer> map = new HashMap<>();


    static boolean check(int idx){

        for(int i : list[idx]){
            if(!map.containsKey(i)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n+3];
        for(int i = 0 ;i < n+3; i++) list[i] = new ArrayList<>();
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        q = Integer.parseInt(br.readLine());
        arr = new int[q];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < q; i++)  {
            int a = Integer.parseInt(st.nextToken());
            arr[i] = a;
            map.put(a, 0);
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < q; i++){
            int cur = arr[i];
            //if(map.get(cur) == 1) continue;
            if(check(cur)){ // 여기도 터트려도 ㅇㅋ 면 주변꺼 다 터트리기 ? ㅇㅋ
                //System.out.println(cur + " 은 터트리기가능");
                for(int b : list[cur]){
                    map.put(b, 1);
                }
                
                ans.add(cur);
                map.put(cur, 1);
            }

        }
        Collections.sort(ans);
        boolean ck = true;
        for(int i = 0; i < q; i++){
            int cur = arr[i];
            if(map.get(cur)!=1)ck = false;
        }


        if(!ck) System.out.println(-1);
        else{
            System.out.println(ans.size());
            for(int i : ans){
                System.out.print(i + " ");
            }
        }


    }
}

/*

아 그러니까
파괴된거에서
더파괴되면 안되는거네 ? 
그러면 결국
5 3
1 2
3 2
5 4
4
1 2 4 5

이 있을대
1에서 터트렸는데
저 4개중에 다른게 터지면 2에서 터트리면 안된다는거네  ?
그러면 그냥 넘어가야겠네  ?
1터트리는거네 ? 
음 그러니까 내말은
일단 1에서 터트려보고 
다른게 터진다 ? 하면 
1에서 터트리지 않고 넘어가 그런식인거지 
어짜피 터져야하는것들은 명단에있으니까
예를들어 1 - 2    1 - 3    2 - 3 인데
1 2 만 터트려야한다고
3에서 터트리면 안된다는거지
ㅇㅋ ㄱㄱ

야근데
10만인데
간선개수가
N 은 2000 이고

20000000
아 안터지네
완탐해도되겠다




*/