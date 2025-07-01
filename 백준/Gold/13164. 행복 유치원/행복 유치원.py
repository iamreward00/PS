import sys

N, K = list(map(int,sys.stdin.readline().split()))

arr = list(map(int,sys.stdin.readline().split()))

minus_arr = []
ans = 0

for i in range(1,N):
  minus_arr.append(arr[i]-arr[i-1])

minus_arr.sort()

for i in range(N-K):
  ans += minus_arr[i]

print(ans)
