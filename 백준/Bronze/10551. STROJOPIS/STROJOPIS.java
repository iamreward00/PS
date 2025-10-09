import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    /// 이거 해쉬맵 해서 하면 될꺼같은데
    /// 8개니까 
    /// 1 Q A Z
    /// 2 W S X
    /// 3 E D C
    /// 4 R F V 5 T G B
    /// 
    /// 6 7 Y U H J N M
    /// 8 I K ,
    /// 9 O L .
    /// 0 - =  P [ ] ; ' /

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int len = str.length();
        int[] cnt = new int[9];

        for(int i = 0; i < len; i++){
            char ch = str.charAt(i);
            if(ch == '1' || ch == 'Q' || ch == 'A' || ch=='Z') cnt[1] ++;
            else if(ch=='2' || ch=='W' || ch=='S' || ch=='X') cnt[2] ++;
            else if(ch=='3' || ch== 'E' || ch=='D' || ch=='C') cnt[3] ++;
            else if(ch=='4' || ch=='R' || ch=='F' || ch=='V' || ch=='5' || ch=='T' || ch=='G' || ch=='B') cnt[4] ++;
            else if(ch=='6' || ch=='7' || ch=='Y' || ch=='U' || ch=='H' || ch=='J' || ch=='N' || ch=='M') cnt[5] ++;
            else if(ch=='8' || ch=='I' || ch=='K' || ch==',') cnt[6] ++;
            else if(ch=='9' || ch=='O' || ch=='L' || ch=='.') cnt[7] ++;
            else cnt[8] ++;
        }
        for(int i = 1; i <= 8; i++){
            System.out.println(cnt[i]);
        }

        
    }
}
    /// 8 I K ,
    /// 9 O L .
    /// 0 - =  P [ ] ; ' /