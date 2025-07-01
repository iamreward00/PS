import sys

N = int(sys.stdin.readline())

for i in range(N):
    A, B = map(int,sys.stdin.readline().split())
    st = A
    ed = B
    k = 1
    cnt = 1

    arr = []
    
    arr.append(0)
    while (True):
        arr.append(arr[-1]+k)
        arr.append(arr[-1]+k)
        k += 1
        if(arr[-2] + st >= ed):
            print(len(arr)-2)
            break
        if(arr[-1] + st >= ed):
            print(len(arr)-1)
            break


"""
1 1
2 11
4 121
6 1221
9 12321


"""