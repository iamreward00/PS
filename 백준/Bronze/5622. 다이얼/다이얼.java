import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int n[] = {3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,8,8,8,8,9,9,9,10,10,10,10};
		int sum = 0;
		String str;
		Scanner scan = new Scanner(System.in);
		str = scan.next();
		scan.close();
		for(int i = 0; i<str.length();i++) {
			sum = sum+n[str.charAt(i)-65];
		}
		System.out.println(sum);
	}

}
