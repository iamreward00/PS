import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer line2 = new StringTokenizer(br.readLine()," ");
        int arr[] = new int[n];
        int min = 0;
        int max = 0;

        for ( int i = 0 ; i < n; i++){
            arr[i] = Integer.parseInt(line2.nextToken());
            if(i == 0){
                min = arr[i];
                max = arr[i];
                continue;
            }
            if( min > arr[i] ){
                min = arr[i];
            }
            else if ( max < arr[i] ){
                max = arr[i];
            }
        }
        
        bw.write(String.valueOf(min) + " " + String.valueOf(max));

        br.close();
        bw.close();
    }
}