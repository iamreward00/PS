import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    //// 14:19 가 답이 14:79 니까 (1,4) ( 4,7) (7,9) 합이 더 작았나보지? 그러면 이거 될수있는게 100은 못넘기니까
    /// 이중포문돌리는데 처음포문은 + 24 하고 뒤에포문은 + 60 해서 쫙 돌리면될꺼같은데? 그때  min 기록하고 출려ㅕㄱ
    /// 1 2 3
    /// 4 5 6
    /// 7 8 9
    ///   0
    static int[][] phone ;
    static int find(int i, int j){
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;

        if(i < 10){
            b = i;
        }
        else{
            a = i/10;
            b = i%10;
        }
        if(j<10){
            d = j;
        }
        else{
            c = j/10;
            d = j%10;
        }
        return sum(a,b) + sum(b,c) + sum(c,d);
    }

    static int sum(int a, int b){
        
        return Math.abs(phone[a][0] - phone[b][0]) + Math.abs(phone[a][1] - phone[b][1]);
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        phone = new int[10][2];
        phone[0][0] = 3;
        phone[0][1] = 1;
        int cnt = 1;
        for(int i = 0; i <3; i++){
            for(int j = 0; j < 3; j++){
                phone[cnt][1] = j;
                phone[cnt][0] = i;
                cnt++;
            }
        }

        String str = br.readLine();
        int a = str.charAt(0)-'0';
        int b = str.charAt(1)-'0';
        int c = str.charAt(3)-'0';
        int d = str.charAt(4)-'0';

        int ab = a*10 + b;
        int cd = c*10 + d;
        int min = 999999999;

        int aa = 0;
        int bb = 0;
        for(int i = ab; i <100; i+=24){
            for(int j = cd; j< 100 ; j+=60){
                int f = find(i,j);
                
                if( min > f){
                    min = f;
                    aa = i;
                    bb = j;
                }
            }
        }
        
        String ea = "";
        String eb = "";
        String ec = "";
        String ed = "";
        if(aa < 10){
            ea = "0";
            eb = aa+"";
        }
        else{
            ea = aa/10+"";
            eb = aa%10+"";
        }
        if(bb < 10){
            ec ="0";
            ed = bb+"";
        }
        else{
            ec = bb/10 +"";
            ed = bb%10 + "";
        }

        System.out.println(ea+eb + ":" + ec+ed);
        
    }
}