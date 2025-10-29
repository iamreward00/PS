import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {


    /*
     * 16:58 시작
     * 
     * 트위치 오랜만이네
     * 
     * 트위치 플레이 포켓몬 유명했구나
     * 
     * U D L R 움직임 맵빡으로 나가면 겜오버
     * P        캐릭터 위치한 칸에 아이템 주움 아이템없는데서 하면 바닥부서짐 게임오버
     * 
     * 왼쪽 위 시작
     * 모든칸에 아이템 하나씩 놓여 있고 각 아이템은 알파벳 하나씩 적혀있음
     * -> 순서대로 나열 -> ID 면 아이템 모두 업성지고 한단계 강화
     * 
     * 
     * 
     * 
     * 입력이 
     * N M S ( 아이디길이)
     * 맵타일
     * ...
     * ...
     * 
     * 아이디
     * 
     * 주는데
     * 이거 L 이 1000000 백반
     * 백만인데
     * 50 50 크기가 최대인데
     * 아이디가  최대 1000길이
     * 
     * 이거 그러면
     * 왼쪽 위에서 시작하니까
     * 흠
     * 
     * 해당위치까지 빠르게가기?
     * 그러니까 시작위치인거지
     * id 첫글자 시작위치는 아니까
     * 그거 리스트형태로 저장해둘까?리스트리스트로
     * 그뒤좌표까지 싹 적는거지
     * 해서 거기 보내는거지
     * 
     * 보드게임에서 사다리타고 올라가듯이 미리 경로를 지정해둔다음에
     * 시작 위치에오면 끝위치로 보내고 그 동안에 그걸 저장해두면되겠는데!
     * 백만 이하에 들어오는게 확정일까 흠
     * 칸이 2500인데
     * 아 이게 될지 진짜 모르겠다
     * 증명이 안되는데
     * 2500 칸에 100만번이려면
     * 이거 뻉뺑이를 
     * 400바퀴 해야하네?
     * 400바퀴는 좀 어려운데
     * 아니아니 근데
     * 결국 내가 하려는건
     * id가 이어지는 그 글자들만 가는거잖아
     * 100만번 이동은 안하겠다
     * id위치들 
        인덱스로 연결해서 표현할까? 좋아
        근데 그 시작위치에서 한번만 해야하네? 겹치면 안되는구나
        아 이게 근데 그거네
        그 아이디에 포함된 글자들 위치만 가지고 있으면 되겠네
        ucpc 면 u 위치 짝
        c 위치짝
        p 위치짝
        c 위치 짝 해가지고 i,j 쌍 가지고 있으면 다음이거,이거,이거 이렇게 가면 되겠는데?
        근데 이러면 배열로만 할 수 있겠네 하나라도 null 이면 그냥 탈출구가면되는거니까
     * 알파뱃 배열이니까
     * 얼추 [30] 으로 하고 하면 되겠넹
     * 
     * 그러면 while 문을 해야겠고
     * 그안에 for문을 넣어야겠네 이 포문은
     * S 만큼 반복하고 그 과정동안 remove 하면서 하면 되겠는데? -> 이거 해쉬로 할까 아니면 진짜 지울까
     * 트리셋으로 가지고 있는 다음 진짜 지우자 뭐 시간얼마나된다고 왜 정렬하냐면
     * remove 를 flag 세워서하면 음 그래도 될듯?
     * 어짜피 길어봤자 2500이니까 뭐 매번 그래도 뭐 음 괜찮을지도
     * 아 근데 맨앞에꺼 지우는데
     * 어짜피 정렬되어있는데
     * 그냥 큐 쓰자 
     * 링크드 리스트 드가즈아~
     * 
     * 왜냐면 어짜피 add 하는게 오름차순대로 탐색하기 때 문 에 
     * 
     * 1. 알파뱃 배열들 만든다 
     * [0] -> A 가있는 위치들 전부다
     * list[0].add new int[] { i , j } 하면 되겠다
     * 
     * 이게 또
     * 2500 거리인데
     * 그래서 100만번 안됨
     * 거리가 계속 줄어듬
     * 
     * 
     * 
     * 
     * 
     */


    static int n,m,s;
    static int[][] map;
    static String id;
    static LinkedList<int[]>[] list;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        
        list = new LinkedList[26];
        for(int i = 0; i < 26; i++) list[i] = new LinkedList<>();
        
        for(int i = 0; i < n ;i++){
            String str = br.readLine();
            for(int j = 0; j < m; j++){
                char c = str.charAt(j);
                map[i][j] = c;

                list[(int)(c-'a')].add(new int[]{ i,j});
            }
        }
        id = br.readLine();


        /// 입력 다 받았음 
        /// id 왔다갔다 왔다갔다!
        int lastidx = 0;
        int lastjdx = 0;
        int idx = 0;
        String memo = "";
        String ans = "";
        int levelcnt = 0;
        int reallastidx = 0;
        int reallastjdx = 0;
        while(true){
            int curidx = id.charAt(idx)-'a';
            if(list[curidx].isEmpty()){
                memo = "";
                break;
            }
            // System.out.println((char)(id.charAt(idx)) + " " + idx);
            int[] cur = list[curidx].poll();
            int nix = cur[0];
            int njx = cur[1];
            // System.out.println("이전좌표 : " + lastidx + " " + lastjdx);
            // System.out.println("다음좌표 : " + nix + " " + njx);
            if(nix > lastidx){ // down
                for(int i = 0; i < nix-lastidx; i++){
                    memo += "D";
                }
            }
            if(lastidx > nix){ // up
                for(int i = 0; i < lastidx-nix; i++){
                    memo += "U";
                }
            }
            
            if(njx > lastjdx ){ // r
                for(int i = 0; i < njx-lastjdx; i++){
                    memo += "R";
                }
            }
            if(lastjdx > njx){ // l
                for(int i = 0; i < lastjdx-njx; i++){
                    memo += "L";
                }
            }
            // System.out.println(" 현재 MEMO :  " + memo + " 입니다");
            lastidx = nix;
            lastjdx = njx;

            memo+="P";
            idx = (idx+1)%s;
            if(idx==0){
                ans += memo;
                //System.out.println(ans);
                memo = "";
                levelcnt++;
                reallastidx = lastidx;
                reallastjdx = lastjdx;
            }

        }

        int nix = n-1;
        int njx = m-1;
        lastidx = reallastidx;
        lastjdx = reallastjdx;
        if(nix > lastidx){ // down
                for(int i = 0; i < nix-lastidx; i++){
                    memo += "D";

                }
            }
        else if(lastidx > nix){ // up
            for(int i = 0; i < lastidx-nix; i++){
                memo += "U";

                }
            }

        if(njx > lastjdx ){ // r
            for(int i = 0; i < njx-lastjdx; i++){
                memo += "R";
            
            }
        }
        else if(lastjdx > njx){ // l
            for(int i = 0; i < lastjdx-njx; i++){
                memo += "L";
            }
        }

        ans += memo;
        
        System.out.println(levelcnt + " " + ans.length());
        System.out.println(ans);
    }
}