import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    
    /// 4^10 으로풀거같은데
    /// 근데 이제 백트래킹이 좀 가민된 ㅋㅋ
    /// 그리고 구현도 가미된 ㅋㅋ
    /// 그냥 맵을 만들어버려..?
    /// 보내고 2개이상이면 빠꾸 시키자 
    
    static ArrayList<Integer>[] list;
    static int[] arr;
    static int[] score = new int[50];
    static int[] map;
    static int max = 0;
    
    static int one = 0;
    static int two = 0;
    static int thr = 0;
    static int four = 0;
    
    static void dfs(int idx,int cnt) { /// 
        if(idx == 10) {
            max = Math.max(cnt, max);
            return;
        }

        
        int dice = arr[idx];
        
        int onego = go(one,dice);
        int twogo = go(two,dice);
        int thrgo = go(thr,dice);
        int fourgo = go(four,dice);
        
        int temp = 0;
        if(one < 33) {
            temp = one;
            one = onego;
			map[one] ++;
			map[temp]--;
            if(!end())dfs(idx+1,cnt +score[onego]);
			map[one] --;
			map[temp]++;
            one = temp;
        }
        
        if(two < 33) {
            temp = two;
            two = twogo;
			map[two]++;
			map[temp]--;
            if(!end())dfs(idx+1,cnt +score[twogo]);
			map[two]--;
			map[temp]++;
            two = temp;
        }
        
        if(thr < 33) {
            temp = thr;
            thr = thrgo;
			map[thr]++;
			map[temp]--;
            if(!end())dfs(idx+1,cnt +score[thrgo]);
			map[thr]--;
			map[temp]++;
            thr = temp;
        }

        if(four < 33) {
			temp = four;
            four = fourgo;
			map[four]++;
			map[temp]--;
            if(!end())dfs(idx+1,cnt + score[fourgo]);
			map[four]--;
			map[temp]++;
            four = temp;
        }
        
        
        
        
    }
	static boolean end(){
		for(int i = 1; i <= 31; i++){
			if(map[i] >=2) return true;
		}

		return false;
	}
    
    static int go(int idx, int dice) {
		if(idx==33) return 33;
        int next = list[idx].get(0);        
        if(list[idx].size()>=2) {
            next = list[idx].get(1);
        }

        dice--;
        for(int i = 0; i < dice; i++) {
			if(next==33) break;
            next = list[next].get(0);
        }
        
        return next;
    }
    
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[10];
        for(int i = 0; i < 10; i++) arr[i] = Integer.parseInt(st.nextToken());
        
        list = new ArrayList[35];
        for(int i = 0; i < 35; i++)    list[i] = new ArrayList<>();
        
        for(int i = 0; i < 20; i++) list[i].add(i+1);
        list[5].add(21);
        list[10].add(24);
        list[15].add(29);
        for(int i = 21; i < 23; i++) list[i].add(i+1);
        list[23].add(26);
        list[24].add(25);
        list[25].add(26);
        list[29].add(30);
        list[30].add(31);
        list[31].add(26);
        list[26].add(27);
        list[27].add(28);
        list[28].add(20);
        list[20].add(33);
        
        
        //for(int i = 1; i <= 33; i++) System.out.println( i +" ->"+list[i]);
        
        for(int i = 1; i <= 20; i++) score[i]=i*2;
        score[21] = 13;
        score[22] = 16;
        score[23] = 19;
        score[24] = 22;
        score[25] = 24;
        score[26] = 25;
        score[27] = 30;
        score[28] = 35;
        score[29] = 28;
        score[30] = 27;
        score[31] = 26;
        
        ///System.out.println(Arrays.toString(score));
        map = new int[35];
        
        dfs(0,0);
        
        System.out.println(max);
        
    }
}

