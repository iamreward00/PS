import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String str = "";
		int count = 0;
		Scanner scan = new Scanner(System.in);
		str = scan.next();
		scan.close();
		str = str + " ";
		for (int i = 0; i < str.length() -1 ; i++) {
			if (str.charAt(i) == 'c') {
				if (str.charAt(i + 1) == '=') {
					count++;

				}
				if (str.charAt(i + 1) == '-') {
					count++;

				}
			}
			 
			if (str.charAt(i) == 'd' && str.length()-i >=1) {
				if (str.charAt(i + 1) == 'z'&& str.length()-i >=2) {
					if (str.charAt(i + 2) == '=') {
						count = count+2;
					}
				}
				if (str.charAt(i + 1) == '-') {
					count++;

				}
			}

			if (str.charAt(i) == 'l') {
				if (str.charAt(i + 1) == 'j') {
					count++;

				}
			}
			if (str.charAt(i) == 'n') {
				if (str.charAt(i + 1) == 'j') {
					count++;

				}
			}
			if (str.charAt(i) == 's') {
				if (str.charAt(i + 1) == '=') {
					count++;

				}
			}
			if (str.charAt(i) == 'z' ) {
				if (i==0) {
					if (str.charAt(i + 1) == '=') {
						count++;

					}
				}
				else if(i>0){
					if(str.charAt(i-1) != 'd') {
						if(str.charAt(i+1)=='=')
						count++;
					}
				}
			}
			

		}

		System.out.println(str.length()-count-1);

	}

}
