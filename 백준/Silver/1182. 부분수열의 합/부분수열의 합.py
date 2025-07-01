import sys


N, S = list(map(int,sys.stdin.readline().split()))

arr = list(map(int, sys.stdin.readline().split()))

def find(idx, sum, check):
  if( idx == N ):
    if( sum == S and check):
      return 1
    else:
      return 0
  
  return find(idx+1,sum, check) + find(idx+1,sum+arr[idx], True)

ans = find(0,0,False)

print(ans)
