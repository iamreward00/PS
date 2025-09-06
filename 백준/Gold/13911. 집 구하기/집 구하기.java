import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
    
    static int V,E;
    static ArrayList<int[]>[] list;
    static ArrayList<Integer> mlist;
    static ArrayList<Integer> slist;
    static int INF = 1999999999;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        list = new ArrayList[V+1];
        for(int i = 1; i<= V; i++) list[i] = new ArrayList<>();
        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new int[] {b,c});
            list[b].add(new int[] {a,c});
        }
        st = new StringTokenizer(br.readLine());
        int mcnt = Integer.parseInt(st.nextToken());
        int mblock = Integer.parseInt(st.nextToken());
        int[] marr = new int[mcnt];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < mcnt; i++){
            marr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int scnt = Integer.parseInt(st.nextToken());
        int sblock = Integer.parseInt(st.nextToken());
        int[] sarr = new int[scnt];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < scnt; i++) sarr[i] = Integer.parseInt(st.nextToken());

        boolean[] vism = new boolean[V+1];
        int[] mminD = new int[V+1];
        Arrays.fill(mminD, INF);
        PriorityQueue<int[]> mpq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // TODO Auto-generated method stub
                return Integer.compare(o1[1], o2[1]);
            }
        });

        for(int i = 0; i < mcnt; i++){
            mminD[marr[i]] = 0;
            mpq.add(new int[] { marr[i], mminD[marr[i]]});
        }

        while(!mpq.isEmpty()){
            int[] cur = mpq.poll();
            int a = cur[0];
            int p = cur[1];
            if(vism[a]) continue;
            vism[a] = true;

            for(int[] i : list[a]){
                int aa = i[0];
                int pp = i[1];
                if(vism[aa]) continue;
                if(mminD[aa] > p + pp){
                    mminD[aa] = p + pp;
                    mpq.add(new int[] {aa, mminD[aa]});
                }

            }
        }



        boolean[] viss = new boolean[V+1];
        int[] sminD = new int[V+1];
        Arrays.fill(sminD, INF);

        PriorityQueue<int[]> spq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1],o2[1]));

        for(int i = 0; i < scnt; i++){
            sminD[sarr[i]] = 0;
            spq.add(new int[] { sarr[i], sminD[sarr[i]]});
        }

        while(!spq.isEmpty()){
            int[] cur = spq.poll();
            int a = cur[0];
            int p = cur[1];
            if(viss[a]) continue;
            viss[a] = true;

            for(int[] i : list[a]){
                int aa = i[0];
                int pp = i[1];
                if(viss[aa]) continue;
                if(sminD[aa] > p + pp){
                    sminD[aa] = p + pp;
                    spq.add(new int[] {aa, sminD[aa]});
                }

            }
        }
        
        long ans = INF;
        for(int i = 1; i<= V; i++){
            int m = mminD[i];
            int s = sminD[i];
            if(m>mblock || m == 0) continue;
            if(s>sblock || s == 0) continue;
            ans = Math.min(ans, m+s);
        }

        if(ans == INF) System.out.println(-1);
        else System.out.println(ans);


    }
}

/* 
 * 2 6
 * 1 5
 * 1 4
 * 8
 * 
 * 이거 2 6
 * 2 - M 개수 6 거리제한
 * 1 맥도날드1 / 5 맥도날드2
 * 
 * 1 s 개수 4 거리제한
 * 8 스타벅스
 * 
 * 아니 이거 이해하기 힘들었음 ㅋㅋ
 */