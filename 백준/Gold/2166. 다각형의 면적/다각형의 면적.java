import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException  {

    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int N;
    long right = 0L;
    long left = 0L;
    double sum = 0;
    
    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    
    int x[] = new int[N+1];
    int y[] = new int[N+1];

    for(int i = 0; i < N; i++){
    st = new StringTokenizer(br.readLine());
    x[i] = Integer.parseInt(st.nextToken());
    y[i] = Integer.parseInt(st.nextToken());
    }
    
    br.close();

    x[N]=x[0];
    y[N]=y[0];

    for(int i = 0; i < N; i++){
      right +=  Long.valueOf(x[i]) * y[i+1];
      left +=  Long.valueOf(x[i+1]) * y[i];
    }
    
    sum = Math.abs(right-left)/2.0;
    
    System.out.printf("%.1f",sum);

  }
  

}
