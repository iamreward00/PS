import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		int check = 0;
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(bf.readLine());
		int a =Integer.parseInt(str.nextToken());
		int b =Integer.parseInt(str.nextToken());
		int v =Integer.parseInt(str.nextToken());
		check = (int) (Math.ceil((double)(v-a)/(a-b)) +1);
		
		System.out.println(check);
	}


}


