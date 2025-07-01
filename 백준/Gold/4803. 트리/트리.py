import sys
sys.setrecursionlimit(10**6)
from collections import deque

def bfs(idx):
  cycle = False
  queue = deque([idx])

  while queue:
    v = queue.popleft()

    if(visited[v]):
      cycle = True
    
    visited[v] = True

    for i in tree[v]:
      if(visited[i]==False):
        queue.append(i)
    
  return cycle


cnt = 0
while True:
  N, M = list(map(int, sys.stdin.readline().split()))
  
  if( N == 0 and M == 0 ):
    break
  tree = [[] for _ in range(N+1)]
  visited = [False for _ in range(N+1)]
  for _ in range(M):
    a, b = list(map(int,sys.stdin.readline().split()))
    tree[a].append(b)
    tree[b].append(a)

  tree_cnt = 0
  
  for i in range(1,N+1):
    if( visited[i] == False ):
      if(bfs(i) == False):
        tree_cnt += 1
      

  cnt += 1
  if(tree_cnt == 0):
    print(f"Case {cnt}: No trees.")
  elif(tree_cnt == 1):
    print(f"Case {cnt}: There is one tree.")
  else:
    print(f"Case {cnt}: A forest of {tree_cnt} trees.")
  