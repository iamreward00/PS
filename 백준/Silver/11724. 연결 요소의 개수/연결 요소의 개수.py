import sys


N,M = list(map(int, sys.stdin.readline().strip().split()))

arr = [i for i in range(N+1)]

uv = []

for i in range(1,M+1):
  uv.append(list(map(int, sys.stdin.readline().strip().split())))


uv.sort()

for i in uv:
  u = i[0]
  v = i[1]

  if( u > v ):
    tmp = u
    u = v
    v = tmp
  
  if(arr[v] != v):
    arr[u] = arr[v]
  else:
    arr[v] = arr[u]


cnt = []

for num in arr:
  if num not in cnt:
    cnt.append(num)

print(len(cnt)-1)

