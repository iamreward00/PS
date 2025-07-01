import sys

N, M, Q = map(int,sys.stdin.readline().split())

arr = list(map(int, sys.stdin.readline().split()))

Q_list = []
max_ed = 0
for i in range(Q):
    A, B = map(int, sys.stdin.readline().split())
    if(max_ed < B):
        max_ed = B
    Q_list.append([A,B])    

one_arr = [0] * (N+1)
for i in range(N):
    one_arr[i+1] = one_arr[i] + arr[i]


two_arr = [0]*(N+1)
check = [[0]*2 for _ in range(N)]
cnt = 0

for i in range(N):

    cnt -= check[i][0] 

    two_arr[i+1] = check[i][1] + cnt * M 

    idx = i + 2 + arr[i] // M 

    if ( idx <= N ) :
        check[idx-1][0] += 1
        check[idx-1][1] += arr[i] % M

    cnt += 1

for i in range(1, N+1) :
    two_arr[i] += two_arr[i-1]


for num in Q_list:
    if(num[0] == 1):
        print((one_arr[num[1]] - two_arr[num[1]]))
    else:
        print(two_arr[num[1]] - two_arr[num[1]-1])