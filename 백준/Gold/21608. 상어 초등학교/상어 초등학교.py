def one(like_arr):
    x1 = [1,-1,0,0]
    y1 = [0,0,1,-1]
    like_max = 0
    temp_score = 0
    like_temp = []

    for i in range(n):
        for j in range(n):
            temp_score = 0
            if(room[i][j] != 0 ):
                continue
            for k in range(4):
                ni = i+x1[k]
                nj = j+y1[k]
                if( 0<= ni < n and 0 <= nj < n):
                    if(room[ni][nj] in like_arr[1:]):
                        temp_score += 1
            if(like_max <= temp_score):
                like_max = temp_score
                like_temp.append((like_max,i,j))
    
    like_cnt = 0
    empty_temp_arr = []
    for i in range(len(like_temp)):
        if(like_temp[i][0] == like_max):
            like_cnt += 1
            empty_temp_arr.append((like_temp[i][1],like_temp[i][2],like_arr[0]))

    if(like_cnt == 1):

        room[like_temp[-1][1]][like_temp[-1][2]] = like_arr[0]
    else:
        two(empty_temp_arr)

def two(empty_arr):
    x1 = [1,-1,0,0]
    y1 = [0,0,1,-1]
    empty_score = 0
    empty_max = 0
    emtpy_temp = []
    for i in empty_arr:
        empty_score = 0
        for k in range(4):
            ni = i[0] + x1[k]
            nj = i[1] + y1[k]
            if( 0<= ni < n and 0 <= nj < n):
                if(room[ni][nj] == 0):
                    empty_score += 1
        if(empty_max <= empty_score):
            empty_max = empty_score
            emtpy_temp.append((empty_max,i[0],i[1]))
    empty_cnt = 0
    three_temp_arr = []
    for i in range(len(emtpy_temp)):
        if(emtpy_temp[i][0] == empty_max):
            empty_cnt += 1
            three_temp_arr.append((emtpy_temp[i][1],emtpy_temp[i][2]))

    if(empty_cnt == 1):
        room[three_temp_arr[-1][0]][three_temp_arr[-1][1]] = empty_arr[-1][2]
    else:
        three_temp_arr.sort()
        room[three_temp_arr[0][0]][three_temp_arr[0][1]] = empty_arr[-1][2]


n = int(input())

room = [[0 for _ in range(n)]for _ in range(n)]
stu = []
content = [0,1,10,100,1000]

for _ in range(n*n):
    stu.append(list(map(int,input().split())))

for i in range(n*n):
    one(stu[i])

#print("룸")
#print(room)

total_score = 0
for i in range(n):
    for j in range(n):
        st_id = room[i][j]
        x1 = [1,-1,0,0]
        y1 = [0,0,1,-1]
        like_list = []
        for ck in stu:
            if(ck[0] == st_id):
                like_list = ck
                break
        like_list = like_list[1:]
        total_cnt = 0
        for k in range(4):
            nx = i+x1[k]
            ny = j+y1[k]
            if( 0 <= nx < n and 0 <= ny < n):
                if(room[nx][ny] in like_list):
                    total_cnt += 1
        total_score += content[total_cnt]
print(total_score)