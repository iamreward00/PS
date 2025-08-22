import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int a[][] = new int[n][2];
		int base[][] = new int[100][100];
		int x = 0, y = 0;
		int num = 0;
		
		for(int i = 0; i<n; i++) {
			for(int j = 0; j <2; j++) {
					a[i][j] = scan.nextInt();
				}
		}
		for(int i = 0; i < n; i++) {
			x = a[i][0];
			y = a[i][1];
			find(x,y,base);
		}
		for(int i = 0; i<100; i++) {
			for(int j = 0; j <100; j++) {
					if(base[i][j]>0) {
						num++;
					}
					
				}
		}
		
		System.out.println(num);
		
	}
	public static void find(int x, int y, int base[][]) {
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				base[x+i][y+j]++;
			}
		}
	}
}
