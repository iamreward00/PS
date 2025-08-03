import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N, M, K;
    private static long[] tree;
    private static long[] nums;
    private static int leafSize; // N을 포함하는 가장 작은 2의 거듭제곱 (리프 노드의 시작 인덱스)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 수의 개수
        M = Integer.parseInt(st.nextToken()); // 변경 횟수
        K = Integer.parseInt(st.nextToken()); // 구간 합 횟수

        nums = new long[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Long.parseLong(br.readLine());
        }

        // N을 포함하는 가장 작은 2의 거듭제곱을 찾습니다.
        // 예를 들어 N=5이면 leafSize는 8 (2^3)이 됩니다.
        leafSize = 1;
        while (leafSize < N) {
            leafSize <<= 1; // leafSize = leafSize * 2
        }
        
        // 트리의 총 크기는 리프 노드 수의 2배입니다.
        // 1-based indexing을 사용하므로, tree[1]이 루트 노드입니다.
        // 리프 노드들은 tree[leafSize]부터 시작합니다.
        tree = new long[2 * leafSize];

        // 세그먼트 트리 구축 (반복문)
        build();

        StringBuilder sb = new StringBuilder();
        int totalOps = M + K; // 총 연산 횟수
        for (int i = 0; i < totalOps; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 연산 종류 (1: 변경, 2: 구간 합)
            int b = Integer.parseInt(st.nextToken()); // 시작 인덱스 또는 변경할 수의 인덱스
            long c = Long.parseLong(st.nextToken()); // 끝 인덱스 또는 변경할 값

            if (a == 1) {
                // b번째 수(원본 배열의 인덱스 b-1)를 c로 변경
                long diff = c - nums[b - 1]; // 변경될 값의 차이 (새로운 값 - 기존 값)
                nums[b - 1] = c; // 원본 배열의 값을 먼저 갱신
                update(b - 1, diff); // 세그먼트 트리 갱신
            } else if (a == 2) {
                // b부터 c까지의 구간 합 출력 (원본 배열의 인덱스 b-1부터 c-1)
                // 쿼리 함수는 0-based 인덱스를 받으므로 b-1, c-1로 전달합니다.
                sb.append(query(1, 0, leafSize - 1, b - 1, (int) c - 1)).append('\n');
            }
        }
        System.out.print(sb);
        br.close();
    }

    /**
     * 세그먼트 트리를 반복문 방식으로 구축합니다.
     * 1. 원본 배열의 값을 트리의 리프 노드에 직접 복사합니다.
     * 2. 리프 노드 바로 위 부모 노드부터 루트 노드까지 거슬러 올라가며 값을 계산합니다.
     */
    private static void build() {
        // 1. 리프 노드에 원본 배열 값 채우기
        // nums[i]는 tree[leafSize + i]에 저장됩니다.
        for (int i = 0; i < N; i++) {
            tree[leafSize + i] = nums[i];
        }

        // 2. 부모 노드 값 계산 (리프 노드 바로 위부터 루트까지)
        // tree[i]는 tree[2*i]와 tree[2*i+1]의 합입니다.
        // leafSize - 1은 마지막 리프 노드의 부모 노드 인덱스입니다.
        for (int i = leafSize - 1; i > 0; i--) {
            tree[i] = tree[2 * i] + tree[2 * i + 1];
        }
    }

    /**
     * 특정 인덱스의 값이 변경되었을 때 세그먼트 트리를 반복문 방식으로 갱신합니다.
     * @param idx   변경할 원본 배열의 0-based 인덱스
     * @param diff  변경될 값의 차이 (새로운 값 - 기존 값)
     */
    private static void update(int idx, long diff) {
        // 1. 원본 배열의 인덱스를 세그먼트 트리의 리프 노드 인덱스로 변환합니다.
        // 예를 들어 nums[0]은 tree[leafSize]에 해당합니다.
        int treeIdx = leafSize + idx;

        // 2. 해당 리프 노드의 값을 갱신합니다.
        tree[treeIdx] += diff;

        // 3. 부모 노드들을 따라 올라가며 값을 갱신합니다.
        // 현재 노드의 부모 노드 인덱스는 '현재 노드 인덱스 / 2' 입니다.
        for (int i = treeIdx / 2; i > 0; i /= 2) {
            tree[i] = tree[2 * i] + tree[2 * i + 1];
        }
    }

    /**
     * 주어진 구간의 합을 재귀 방식으로 계산합니다.
     * @param node  현재 트리의 노드 인덱스 (1-based)
     * @param start 현재 노드가 커버하는 구간의 시작 인덱스 (0-based, 원본 배열 기준)
     * @param end   현재 노드가 커버하는 구간의 끝 인덱스 (0-based, 원본 배열 기준)
     * @param left  쿼리할 구간의 시작 인덱스 (0-based, 원본 배열 기준)
     * @param right 쿼리할 구간의 끝 인덱스 (0-based, 원본 배열 기준)
     * @return      구간 합
     */
    private static long query(int node, int start, int end, int left, int right) {
        // Case 1: 쿼리 구간이 현재 노드의 구간과 전혀 겹치지 않는 경우
        if (left > end || right < start) {
            return 0;
        }

        // Case 2: 쿼리 구간이 현재 노드의 구간을 완전히 포함하는 경우
        if (left <= start && end <= right) {
            return tree[node];
        }

        // Case 3: 쿼리 구간이 현재 노드의 구간과 부분적으로 겹치는 경우
        // 현재 노드의 구간을 두 자식 노드로 나누어 재귀적으로 쿼리합니다.
        int mid = start + (end - start) / 2;
        long p1 = query(2 * node, start, mid, left, right); // 왼쪽 자식 쿼리
        long p2 = query(2 * node + 1, mid + 1, end, left, right); // 오른쪽 자식 쿼리
        return p1 + p2;
    }
}
