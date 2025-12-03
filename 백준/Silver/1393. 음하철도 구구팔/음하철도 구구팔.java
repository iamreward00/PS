
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    /*
    14:46시작
    은하철도

    문제는 구구팔의 기장인 조교 김재홍이 반쯤 미쳐서 열차를 멈추지 않는다는 것이다.
    그래서 최백준은 달리고 있는 열차에서 뛰어내려야 한다.
    헐 아프겠다
    그래서 철도가 정류장에 가장 많이 근접했을 때 뛰어내리고자 한다.

    정류장 위치
    nx ny

    현재위치
    sx sy

    증가량
    dx dy

    값이 작아지다가
    커지면
    그전값이 정답이겠네요?
    prv 해서 이전보다 크냐? 그러면 멈추고 하면 되겠네요


    답이근데
    1초에 뛰어내린게 아니네? 예제가?
    0.5초에 뛰어내렸네?
    이거 어떻게하지? 

    두숫자를 가장작은 그걸로 만들어 야하나?
    정수꼴 중에 가장작은 그걸로?
    2, 4 니까 이거를
    1, 2 로 바꿔야하네
    그러면 흠

    둘중 작은수까지 반복하면서
    나눠지냐? 하면 나누면 되겠네?

    아 0 이올수도있네요...?


    0 이오면 반대쪽은 무조건 1이네요?
    쫘와아아악 내린다고 가정하니까...

    설마 멘헤튼이 아닌가


    */

    static int dx,dy;
    static void find(){
        
        int ckx = 1;
        int cky = 1;
        if(dx < 0){
            ckx = -1;
            dx *= -1;
        } 
        if( dy < 0 ){
            cky = -1;
            dy *= -1;
        }

        if(dx==0){
            if(dy==0) return;
            dy = 1;
            
        }
        if(dy==0){
            if(dx==0) return;
            dx = 1;
            
        }
        int minnum = Math.min(dx,dy);

        for(int i = 2; i <= minnum; i++){
            if(dx == 1 || dy == 1 ) break;
            if(dx % i == 0 && dy % i == 0){
                dx = dx / i;
                dy = dy / i;
                i--;
            }
        }

        dx *= ckx;
        dy *= cky;

    }


    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nx = Integer.parseInt(st.nextToken());
        int ny = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int sx = Integer.parseInt(st.nextToken());
        int sy = Integer.parseInt(st.nextToken());
        dx = Integer.parseInt(st.nextToken());
        dy = Integer.parseInt(st.nextToken());

        find();
        //System.out.println(dx + " " + dy);

        int prvx = sx;
        int prvy = sy;
        int prv = 2111111111;



        while(true){

            int cnt = (nx - sx) * (nx - sx) + (ny - sy) * (ny - sy);
            if(prv <= cnt){
                break;
            }

            prvx = sx;
            prvy = sy;
            prv = cnt;

            sx += dx;
            sy += dy;
            
        }
        System.out.println(prvx + " " + prvy);

    }
}
