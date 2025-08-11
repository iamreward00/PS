/// 수정완료 1045
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	
	
	static int N,M,T,K;
	static int max = 0;
	static int[][] trr;

	
	public static void main(String[] args) throws FileNotFoundException, Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		//// 높이가 M 너비가 N 임
		// arr = new int[M+1][N+1];
		trr = new int[T][2]; // 침입자 담을 배열임
		for(int i = 0; i < T; i++) { // 여기서 그거 점들 입력받기 침입자들
			st = new StringTokenizer(br.readLine());
//			System.out.println(st);
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			trr[i][0] = b;
			trr[i][1] = a;
			//arr[b][a] = 1;
			
		}
		
		/// 여기서 출력해보니까 상하 반대로 나오네? 아마 문제는 밑에서부터 0 이여서 그렇겠지 일단 해볼까
//		for(int i = 0; i < M+1; i++) {
//			for(int j = 0; j < N+1; j++) {
//				System.out.print(arr[i][j] + " ");
//			}
//			System.out.println();
//		}
		/// 
//		for(int i = 0; i < M+1 - K; i++) { // 이거 완탐이라 시초 뜰텐데 최적화 어떻게 하지..? 지금 4중 포문인데 
//			for(int j = 0; j < N+1 - K; j++) {
//				int temp = check(i,j);
//				if(temp > max) {
//					max = temp;
//					midx = i;
//					mjdx = j;
//				}
//			}
//		}
		
// T 위치놈들만 돌려본건데 이거 아닌거같은데 3,5 같은 경우가 -> 현재위치가 침입자가아닌경우 정답일수도있을꺼같은데 최적화방법이 떠오르지않아요...
    for (int[] p1 : trr) { /// 와 그래서 x 좌표 전체 y 좌표 전체야?????????????????????와 미쳤다
        // Loop 2: 모든 침입자의 x좌표를 사각형의 기준선으로 사용
        for (int[] p2 : trr) {
            
            // 기준점 (왼쪽 아래 꼭짓점) 설정
            int startY = p1[0];
            int startX = p2[1];

            // 현재 기준점으로 만들어진 사각형에 포함되는 침입자 수
            int currentCount = 0;
            
            // Loop 3: 모든 침입자를 돌며, 위에서 만든 사각형 안에 들어가는지 확인
            for (int[] target : trr) {
                int targetY = target[0];
                int targetX = target[1];

                if (targetX >= startX && targetX <= startX + K &&
                    targetY >= startY && targetY <= startY + K) {
                    currentCount++;
                }
            }
            
            max = Math.max(max, currentCount);
        }
    }		
		
		
		//System.out.println((midx) +" " + (mjdx+K)); // 출력 형식은 이게 맞는데 이제 최적화 어떻게 하지?
		System.out.println(T - max);
		
		
		
	}

}


/*
현재시간 09:38
4번 마지막 문제 하기전에
서술형 , 2번 3번 돌아보고 올것
테케도 여러번 하고 올것
09:43 4번 시작
뭐야이거
아아아아아아아
이거 그거네 아닌가
시간많으니 문제 천천히 읽어 침착해
입출력 분석해보면
첫번째줄에
N M T K
N 지도너비 최대 1,000,000
M 지도 높이 최대 1,000,000 -> N * M 크기겠네 그러면 O ( N * M ) 은 시간 터지겠네 일단 ㅇㅋ
너비가 N 이고 높이가 M 이면 M * N 이 맞겠다
T 침입자수 -> 이걸로 밑에 입력 쭉 받는거네
K 감시 범위 한변 길이네
그리고 밑에 이제 T 개의 좌표가 들어오는거고
완탐안하고 어떻게 할 수 있지? 파리잡기 처럼 누적합을 쓸 수 있나?-> 안될거같은데
이거 침입자 수가 100개니까
침입자 좌표에서 돌려버리자
침입자 좌표가 왼쪽 아래 꼭지점이라 생각하고 돌려보는거지 
이거다 이거다
ㅇㅋ 가보자
이거 아닌거같은게 3,5 같은 경우가 답일수도있잖아 3,5 에는침입자가없는데말이야
최적화 어떻게 하지~
방법을 모르겠네
슬라이딩 윈도우로 해도 결국 N * M 아닌가?
1,000,000,000,000 이거 무조건 터지는데
N 이나 M 으로 딱 한번에 될수가있나?
현재 10:20
일단 현재꺼 저장 -> 완탐형식
테케만 돌리는걸로 해볼까? 그 T 개수대로 일단?
ㅇㅋ ㄱㄱ -> 이거 했음 테케는 일단 잘 나옴
현재 10:32 일단 환시기킬겸 앞에꺼 다시 보고 오자 
다시보고왔는데 그래도 최적화 방법이 생각이 안남
슬라이딩 윈도우? 이것도 결국 싹 다 뒤지는거잖아
투포인터? 이것도 
누적합 -> 이건 안될거같은게 누적되면안됨 그 부분에만 있어야함

T 놈들로 돌린다 치면
100 * K*K 인데
이것도 터지긴하는거같은데 일단 20분남았으니까 저장 한번할까
아이거 테케만 맞을거같은데
뭔가 뭔가 꼬인거같은데
테케만 맞는거같은데
1. 테케만 맞을듯
2. 최적화 방법을 못찾겠음
자료구조
스택
큐
힙
아
관계?
관계가 의미가있나?
저게 만약 T가 서로 관계를 뜻한다면
깊이 K 까지 가는 그걸로 하면되나? bfs 나 dfs 로 풀리는 문제인가?
2,5 에서 어떻게 찾아가게? 관계는 아닌가
아닌거같음

아 10분남았는데 일단 저장하자


*/






/*


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Test4_본인이름 {

	
	
	static int N,M,T,K;
	static int[][] arr;
	static int max = 0;
	static int midx = 0;
	static int mjdx = 0;
	static int check(int idx, int jdx) {
		int sum = 0;
		for(int i = idx; i <= idx+K; i++) {
			for(int j = jdx; j<= jdx+K; j++) {
				if(arr[i][j] == 1) {
					sum++;
				}
			}
		}
		
		
		return sum;
	}
	
	public static void main(String[] args) throws FileNotFoundException, Exception {
//		System.setIn(new FileInputStream("Test4.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		//// 높이가 M 너비가 N 임
		arr = new int[M+1][N+1];
		int[] trr = new int[T]; // 침입자 담을 배열임
		for(int i = 0; i < T; i++) { // 여기서 그거 점들 입력받기 침입자들
			st = new StringTokenizer(br.readLine());
//			System.out.println(st);
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[b][a] = 1;
			
		}
		
		/// 여기서 출력해보니까 상하 반대로 나오네? 아마 문제는 밑에서부터 0 이여서 그렇겠지 일단 해볼까
//		for(int i = 0; i < M+1; i++) {
//			for(int j = 0; j < N+1; j++) {
//				System.out.print(arr[i][j] + " ");
//			}
//			System.out.println();
//		}
		/// 
		for(int i = 0; i < M+1 - K; i++) { // 이거 완탐이라 시초 뜰텐데 최적화 어떻게 하지..?
			for(int j = 0; j < N+1 - K; j++) {
				int temp = check(i,j);
				if(temp > max) {
					max = temp;
					midx = i;
					mjdx = j;
				}
			}
		}
		
		System.out.println((midx) +" " + (mjdx+K)); // 출력 형식은 이게 맞는데 이제 최적화 어떻게 하지?
		System.out.println(max);
		
		
		
	}

}


/*
현재시간 09:38
4번 마지막 문제 하기전에
서술형 , 2번 3번 돌아보고 올것
테케도 여러번 하고 올것
09:43 4번 시작
뭐야이거
아아아아아아아
이거 그거네 아닌가
시간많으니 문제 천천히 읽어 침착해
입출력 분석해보면
첫번째줄에
N M T K
N 지도너비 최대 1,000,000
M 지도 높이 최대 1,000,000 -> N * M 크기겠네 그러면 O ( N * M ) 은 시간 터지겠네 일단 ㅇㅋ
너비가 N 이고 높이가 M 이면 M * N 이 맞겠다
T 침입자수 -> 이걸로 밑에 입력 쭉 받는거네
K 감시 범위 한변 길이네
그리고 밑에 이제 T 개의 좌표가 들어오는거고
완탐안하고 어떻게 할 수 있지? 파리잡기 처럼 누적합을 쓸 수 있나?-> 안될거같은데
이거 침입자 수가 100개니까
침입자 좌표에서 돌려버리자
침입자 좌표가 왼쪽 아래 꼭지점이라 생각하고 돌려보는거지 
이거다 이거다
ㅇㅋ 가보자
이거 아닌거같은게 3,5 같은 경우가 답일수도있잖아 3,5 에는침입자가없는데말이야
최적화 어떻게 하지~
방법을 모르겠네
슬라이딩 윈도우로 해도 결국 N * M 아닌가?
1,000,000,000,000 이거 무조건 터지는데
N 이나 M 으로 딱 한번에 될수가있나?
현재 10:20
일단 현재꺼 저장 -> 완탐형식
*/
