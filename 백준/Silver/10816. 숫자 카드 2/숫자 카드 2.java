
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    int m = Integer.parseInt(br.readLine());
    StringTokenizer st2 = new StringTokenizer(br.readLine());
    
    int ans1[] = new int[10000001];
    int ans2[] = new int[10000001];
    
    for (int i = 0; i < n; i++) {
		int temp = Integer.parseInt(st.nextToken());
		if(temp < 0) {
			temp = temp * -1;
			ans2[temp]++;
		}
		else {
			ans1[temp]++;
		}
	}
    
    for (int i = 0; i < m; i++) {
    	int temp2 = Integer.parseInt(st2.nextToken());
    	if(temp2<0) {
    		temp2 = temp2 * -1;
    		System.out.print(ans2[temp2]+" ");
    	}
    	else {
    		System.out.print(ans1[temp2]+" ");
    	}
    }
    
  }

}