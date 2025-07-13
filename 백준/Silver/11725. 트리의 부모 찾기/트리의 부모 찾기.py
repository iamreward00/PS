import sys
sys.setrecursionlimit(10**6)
N = int(sys.stdin.readline())

tree = [[] for _ in range(N + 1)] 
ans = [0 for _ in range(N+1)]

for i in range(N-1):
  a,b = list(map(int,sys.stdin.readline().split()))
  tree[a].append(b)
  tree[b].append(a)
  
visited = [ False for _ in range(N+1) ]

def dfs(idx):
  visited[idx] = True

  for i in tree[idx]:
    if( visited[i] == False ):
      ans[i] = idx
      dfs(i)

dfs(1)
for i in ans:
  if( i != 0 ):
    print(i)


'''
7
1 6
6 3
3 5
4 1
2 4
4 7

4
6
1
3
1
4

'''