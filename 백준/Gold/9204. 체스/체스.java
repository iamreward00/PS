import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*

*/
public class Main {


    static boolean dbg = false;


    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(st.nextToken());

        HashMap<Character,Integer> mapping = new HashMap<>();
        HashMap<Integer,Character> mapping2 = new HashMap<>();
        for(int i = 1; i <= 8; i++){
            mapping.put((char)('I'-i), i);
            mapping2.put(i,(char)('I'-i) );
        }
        if(dbg){
            for(char c : mapping.keySet()){
            System.out.println(c + " " + mapping.get(c));
            }
        }
        int[] dx = {-1, -1, 1, 1};
        int[] dy = {-1, 1, -1, 1};

        while(t-->0){

            st = new StringTokenizer(br.readLine());

            int stx = mapping.get(st.nextToken().charAt(0));
            int sty = Integer.parseInt(st.nextToken());

            int edx = mapping.get(st.nextToken().charAt(0));
            int edy = Integer.parseInt(st.nextToken());

            if((stx+sty)%2 != (edx+edy)%2 ) {
                sb.append("Impossible\n");
                continue;
            }
            

            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[] {stx,sty,0});
            Queue<String> strqueue = new LinkedList<>();
            strqueue.add(mapping2.get(stx)+" "+sty);

            boolean[][] vis = new boolean[9][9];
            vis[stx][sty] = true;

            while(!queue.isEmpty()){
                int[] cur = queue.poll();
                String path = strqueue.poll();
                int x = cur[0];
                int y = cur[1];
                int cnt = cur[2];

                if(x == edx && y == edy){
                    sb.append(cnt).append(" ").append(path).append("\n");
                    break; 
                }
                if(cnt >= 4) continue;
                for(int i = 0; i < 4; i++){
                    int nx = x;
                    int ny = y;
                    
                    while(true){
                        nx += dx[i];
                        ny += dy[i];

                        if(nx < 1 || ny < 1 || nx > 8 || ny > 8) break;
                        if(!vis[nx][ny]){
                            vis[nx][ny] = true;
                            queue.add(new int[] {nx, ny, cnt + 1});
                            strqueue.add(path + " " + mapping2.get(nx) + " " + ny);
                        }
                    }
                }


            }




        }

        System.out.println(sb);
    }
}

/*

4번의 제한이 있네요
체스판을
거꾸로 보면편할거같은데

H 를 1부터 시작하는거지 
그럼 편할듯

4번 이동이면
일단 갈수있는데 다 넣고
하면 될듯 ?
방문체크하면서 하면 될듯
기록은 스트링으로 하고
카운트도 하나 필요하겠네




*/