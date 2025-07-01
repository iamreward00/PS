import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int N = 0;
		int k = 0;
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		k = scan.nextInt();
		int v[] = new int[N];
		for(int i = 0; i < N; i++) {
			v[i] = scan.nextInt();
		}
		scan.close();
		
	    PriorityQueue<Integer>    maxheap=new PriorityQueue<Integer>();
	    for(int i = 0; i < k; i++) {
	    	maxheap.add(v[i]);
	    }
	    
	    for(int i = k; i < N; i++) {
	    	if(maxheap.peek() < v[i]) {
		    		System.out.print(maxheap.remove()+" ");
		    		maxheap.add(v[i]);
	    	}
	    	else {
	    		System.out.print(v[i]+" ");
	    	}
	    }
	    for(int i = 0; i < k; i++) {
	    	System.out.print(maxheap.remove()+" ");
	    	
	    }
	}
}