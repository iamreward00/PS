import sys
sys.setrecursionlimit(10**6)

N = int(sys.stdin.readline())

arr = []

alparr = [5,3,4,1,2,0]

for i in range(N):
  arr.append(list(map(int,sys.stdin.readline().split())))


def fourmax(arr_max,alpidx):
  max_value = 0
  topidx = alpidx
  botidx = alparr[alpidx]

  for i in range(6):
    if( max_value < arr_max[i] and i != topidx and i != botidx ):
      max_value = arr_max[i]
  return max_value


# 시작주사위 하나 정하고 거기 맞춰서 계속 찾아간다 언제까지 idx 5까지 top 값이랑 idx 넘기면 될거같은데
def find(top,idx):
  if( idx == N ):
    return 0
  for i in range(6):
    if( arr[idx][i] == top ):
      alpidx = i
      break

  newtop = arr[idx][alparr[alpidx]]
  


  return find(newtop, idx+1) + fourmax(arr[idx],alpidx)
  

max_ans = 0
for i in range(6):
  start = arr[0][i]
  temp_ans = find(start,1)+fourmax(arr[0],i)
  if( max_ans < temp_ans ):
    max_ans = temp_ans

print(max_ans)


'''
5
2 3 1 6 5 4
3 1 2 4 6 5
5 6 4 1 3 2
1 3 6 2 4 5
4 1 6 5 2 3
a b c d e f

29

alparr = 
[5,3,4,1,2,0]
 a b c d e f
a - f / 0 - 5
b - d / 1 - 3
c - e / 2 - 4

'''