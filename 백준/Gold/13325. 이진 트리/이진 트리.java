import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    
    /*
     * 제목이 이진트리네요
     * 저는 일진트리에요
     * 할래말래할래말래할래말래
     * 
     * 가중치는 양수래요
     * 높이가 k 인 포화이진트리래요 -> 이거 꽉찬거 2^n -1 개수인거 1번노드부터 시작한다면
     * 가장 왼쪽의 노드번호가 그 라인의 개수랑 같음
     * 
     * 
     * 어떤 에지들에서 가중치를 증가시켜서
     * 루트에서 모든 리프까지 거리가 같게하면서
     * 에지 가중치들의 총합이 최소가 되도록 하는 거
     * 
     * 아 루트에서 모든 리프노드까지네요
     * 리프노드 꺼들을 바꾸면 그게 정답인데
     * 그러면 최소가 아닐꺼니까
     * 
     * 예를들어
     * 내 자식 2명다 가중치가 같아! 그러면 날 증가시키면 되는거죠?
     * 
     * 그리고 증가시키는 최대값은 dfs로 찾을수있네요? 그거 에 맞춰서 다 하면 되겠죠?
     * 
     * 내 자식 2명의 가중치가 같다! 나를 증가시킨다? 얼마만큼? 이게중요한데 흠
     * 자식 가중치 총합 이랑 이제 되기위해 필요한 만큼 이겠네요
     * 아뇨아뇨아뇨 1씩 증가해야할거같은데요?
     * 근데 2^21 이면 꽤많은데 시간터질거같은데
     * 그러니까 1씩 증가는 아니에요
     * 
     * 이거는
     * 위에서 내려가는거
     * 아래에서 올라오는거
     * 둘다 필요하네요
     * 
     * 배열로 트리만들죠 뭐
     * 
     * 2^(k+1) 만큼길이 만들면 딱이쥬
     * 
     * 가중치가 근데
     * 흠
     * 어렵네
     * 노드에 넣을까 그냥
     * 노드의 합이라고 바꿔버리는거지
     * 
     * 아 최대값인 얘들의 노드를 저장해둬야하나
     * 
     * 내가 최대값인 애들의 노드중 하나가 아니라면
     * 나는 무조건 바꿔도됨
     * 
     * 이거 값을 미리 전처리 해두면 편할려나
     * 
     * 아 아니면
     * 루트노드까지갔을때
     * 필요한값이있는데
     * 그걸 가지고 리턴하면서 하면 안되나
     * 이제 루트노드까지갔을때 내가 전체로 필요한 값! 이게 이제
     * 1, 2 인데 이걸 위로 올리는거지
     * 그러면 그중 작은거를 나한테 더하고  그리고 남은거를 그 자식한테 더해주면 될거같은데요
     * 그리고 나한테 더하는게 아니네 나도 리턴하는거네 ㅋㅋㅋ
     * 자식한테만 더해주고 나는 리턴하나봐요?
     * 이거다 이거다
     * 이제 차이 만큼을 자식한테 더해주고
     * 그중 작은거 리턴 ㄱㄱ
     * 그림 그려보면 편하게 나옴
     * 
     * 
     */


    static int n,max,size;
    static int[] tree;
    

    static int findmax(int idx){
        if(idx >= size) return 0;
        return Math.max(findmax(idx*2)+tree[idx], findmax(idx*2+1)+tree[idx]);
    }


    static int dfs(int idx, int prvcnt){
        if(idx >= size) {
            //System.out.println(max - prvcnt +" 입니다");
            return max - prvcnt;
        }

        int a = dfs(idx*2, prvcnt+tree[idx]);
        int b = dfs(idx*2+1, prvcnt+tree[idx]);

        int res = 0;

        if(a<b){
            res = b - a;
            if(res!=0)tree[idx*2+1] += res; 
        }
        else{
            res = a - b;
            if(res!=0)tree[idx*2] += res;
            
        }

        return Math.min(a,b);

    }


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        size = 1<<(n+1);
        tree = new int[size<<1];

        st = new StringTokenizer(br.readLine());
        for(int i = 2; i < size; i++){
            tree[i] = Integer.parseInt(st.nextToken());
        } 
        //System.out.println(Arrays.toString(tree));

        max = findmax(1);
        //System.out.println(max);

        /// 내 자식2개가 가중치가 의 합들이 둘다 같다면 내가 커지고
        /// 그게 아니면 자식이 커지고
        dfs(1,0);
        //System.out.println(Arrays.toString(tree));
        long sum = 0;
        for(int i = 0; i < size; i++){
            sum += 1L*tree[i];
        }
        System.out.println(sum);
    }
}