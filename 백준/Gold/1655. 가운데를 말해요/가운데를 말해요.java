import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	//// 매번 입력바다 정렬하고 중간값 출력 -> 이거 터짐 그러면 다른방법? 
	/// 자료구조 우선순위큐 2개 써서 중간값 찾기 ㄱㄱ
	/// 최대힙, 최소힙 해서 최대힙peek 하면 최대힙중에서 가장 큰값 나오는데 이게 중간값임 - > 최대힙은 중간보다 작거나 같은놈 최소힙은 중간보다 큰놈
	/// 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        // 최대 힙 (중간값보다 작거나 같은 값들 저장)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        // 최소 힙 (중간값보다 큰 값들 저장)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            /// maxHeap과 minHeap의 크기를 맞춰서 번갈아 가며 값 추가
            if (maxHeap.size() == minHeap.size()) {
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }

            /// 두 힙의 균형 맞추기 (maxHeap의 top은 항상 minHeap의 top보다 작거나 같아야 함)
            /// minHeap이 비어있지 않고, maxHeap의 루트가 minHeap의 루트보다 크면 두 값을 교환
            if (!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
                int temp1 = maxHeap.poll();
                int temp2 = minHeap.poll();
                maxHeap.add(temp2);
                minHeap.add(temp1);
            }

            /// 중간값(maxHeap의 루트)을 StringBuilder에 추가
            sb.append(maxHeap.peek() + "\n");
        }

        System.out.print(sb);
    }
}