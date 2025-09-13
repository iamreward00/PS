import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while(true){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if((a | b) == 0) break;
            HashSet<Integer> aset = new HashSet<>();
            HashSet<Integer> bset = new HashSet<>();
            int[] arr = new int[100];
            int[] brr = new int[100];
            arr[1] = a;
            brr[1] = b;

            int aidx = 1;
            while(true){
                String temp = arr[aidx]+"";
                int sum = 0;
                for(int i = 0; i < temp.length(); i++){
                    int temp2 = temp.charAt(i)-'0';
                    sum += temp2*temp2;
                }
                if(aset.contains(sum)){
                    break;
                }
                aset.add(sum);
                aidx++;
                arr[aidx] = sum;
            }   
            int bidx = 1;
            while(true){
                String temp = brr[bidx]+"";
                int sum = 0;
                for(int i = 0; i < temp.length(); i++){
                    int temp2 = temp.charAt(i)-'0';
                    sum += temp2*temp2;
                }
                if(bset.contains(sum)){
                    break;
                }
                bset.add(sum);
                bidx++;
                brr[bidx] = sum;
            }  
            
            int min = 199999999;
            for(int i = 1; i <= aidx; i++){
                for(int j = 1; j <= bidx; j++){
                    if(arr[i] == brr[j]){
                        min = Math.min(Math.abs(i+j), min);
                    }
                }
            }
            if(min == 199999999) sb.append(a + " " + b + " " + 0 +"\n");
            else sb.append(a + " " + b + " " + min+"\n");
            

        }
        System.out.println(sb);

    }
}