import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    
    /*
     * 
     * 지금 사거나 
     * 미뤄서 wmax * emax 로 사거나
     * 
     * 그러면 넘기는 값에는
     * 값은 return 해서 + 해주면 될거같고
     * 
     * idx 하나면 되나
     * idx 를 
     * 
     */

    
    static int N;
    static int[][] arr;
    static HashMap<String, Long> map;
    static long dfs(int idx, int state, int wmax, int emax ){

        if(idx == N) {
            
            if(state==1){
                return (long)wmax*emax;
            }
            else{
                return 0;
            }
            
        }
        String key = idx + "," + state + "," + wmax + "," + emax;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        long min = Long.MAX_VALUE;
        if(state == 1 ){ /// 한꺼번에 사는거 했으면 여기서 계산해서 넘기거나 해야될거같은데
            min = Math.min(min, dfs(idx+1,0,0,0) +(long) Math.max(wmax, arr[idx][0]) * Math.max(emax, arr[idx][1]));
            /// 위에거는 여기서 구매했을경우 뭉친거
            min = Math.min(min, dfs(idx+1, 1, Math.max(wmax, arr[idx][0]), Math.max(emax, arr[idx][1]))); /// 넘긴거
        }
        else{
            min = Math.min(min, dfs(idx+1, 0, 0,0) +(long) arr[idx][0] * arr[idx][1]); // 그냥 구매한거
    
            min = Math.min(min, dfs(idx+1, 1, Math.max(wmax, arr[idx][0]), Math.max(emax, arr[idx][1]))); /// 넘긴거

        }
        map.put(key, min);
        return min;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) arr[i][0] = Integer.parseInt(st.nextToken()); // 무게 w
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) arr[i][1] = Integer.parseInt(st.nextToken()); // 에너지 e
        map = new HashMap<>();
        System.out.println(dfs(0, 0, 0, 0));

    }
}
