answer = []
visited = set()
def find(num_str,cnt,n):
    
    temp_list = list(num_str)
    if(temp_list[0] == "0"):
        return None
    if((num_str,cnt) in visited):
        return None
    if (cnt == n):
        if(int(num_str) not in answer):
            answer.append(int(num_str))
        return None
    visited.add((num_str,cnt))

    for i in range(len(temp_list)):
        for j in range(i+1,len(temp_list)):
            if(i!= j):
                temp_list[i] , temp_list[j] = temp_list[j], temp_list[i]
                temp_num = "".join(temp_list)
                find(temp_num,cnt+1,n)
                temp_list[i] , temp_list[j] = temp_list[j], temp_list[i]


a, n = input().split()
n = int(n)
find(a,0,n)

if(len(answer) > 0):
    answer.sort()
    print(answer[-1])
else:
    print(-1)