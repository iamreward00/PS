import sys
import heapq

N = int(sys.stdin.readline())
M = int(sys.stdin.readline())
graph = [[] for _ in range(N+1)]

for i in range(M):
  a, b, c = list(map(int,sys.stdin.readline().split()))
  graph[a].append((b,c))

start, end = list(map(int,sys.stdin.readline().split()))

res = [int(sys.maxsize) for _ in range(N+1)]

def dijkstar(x):
  que = []
  heapq.heappush(que, (0,x))
  res[x] = 0

  while que:
    dist, now = heapq.heappop(que)

    if( res[now] < dist ):
      continue
    for i in graph[now]:
      cost = dist + i[1]
      if( cost < res[i[0]] ):
        res[i[0]] = cost
        heapq.heappush(que, (cost, i[0]))



dijkstar(start)
print(res[end])
