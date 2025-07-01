import sys

input = sys.stdin.readline

R, C, T = map(int, input().split())
board = []
cleaner_pos = []

for i in range(R):
    row = list(map(int, input().split()))
    board.append(row)
    if (-1 in row):
        cleaner_pos.append((i, 0))

def spread_dust():
    new_board = [[0] * C for _ in range(R)]
    dr = [-1, 1, 0, 0]
    dc = [0, 0, -1, 1]

    for r in range(R):
        for c in range(C):
            if (board[r][c] > 0):
                dust_amount = board[r][c]
                spread_per_direction = dust_amount // 5
                spread_count = 0

                for i in range(4):
                    nr, nc = r + dr[i], c + dc[i]

                    if (0 <= nr < R and 0 <= nc < C and board[nr][nc] != -1):
                        new_board[nr][nc] += spread_per_direction
                        spread_count += 1
                
                new_board[r][c] += (dust_amount - (spread_per_direction * spread_count))
            elif (board[r][c] == -1):
                new_board[r][c] = -1
    return new_board

def clean_air():
    air_cleaner_up_r = cleaner_pos[0][0]
    
    prev_dust = 0
    for c in range(1, C):
        temp_dust = board[air_cleaner_up_r][c]
        board[air_cleaner_up_r][c] = prev_dust
        prev_dust = temp_dust

    for r in range(air_cleaner_up_r - 1, -1, -1):
        temp_dust = board[r][C-1]
        board[r][C-1] = prev_dust
        prev_dust = temp_dust

    for c in range(C - 2, -1, -1):
        temp_dust = board[0][c]
        board[0][c] = prev_dust
        prev_dust = temp_dust

    for r in range(1, air_cleaner_up_r):
        temp_dust = board[r][0]
        board[r][0] = prev_dust
        prev_dust = temp_dust
    
    air_cleaner_down_r = cleaner_pos[1][0]

    prev_dust = 0
    for c in range(1, C):
        temp_dust = board[air_cleaner_down_r][c]
        board[air_cleaner_down_r][c] = prev_dust
        prev_dust = temp_dust

    for r in range(air_cleaner_down_r + 1, R):
        temp_dust = board[r][C-1]
        board[r][C-1] = prev_dust
        prev_dust = temp_dust

    for c in range(C - 2, -1, -1):
        temp_dust = board[R-1][c]
        board[R-1][c] = prev_dust
        prev_dust = temp_dust

    for r in range(R - 2, air_cleaner_down_r, -1):
        temp_dust = board[r][0]
        board[r][0] = prev_dust
        prev_dust = temp_dust
    
for _ in range(T):
    board = spread_dust()
    clean_air()

total_dust = 0
for r in range(R):
    for c in range(C):
        if (board[r][c] > 0):
            total_dust += board[r][c]

print(total_dust)