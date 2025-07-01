n = int(input())
k = int(input())
apples = set()
for _ in range(k):
    r, c = map(int, input().split())
    apples.add((r - 1, c - 1))

l = int(input())
moves = []
for _ in range(l):
    t, d = input().split()
    moves.append((int(t), d))

board = [[0] * n for _ in range(n)]
snake = [(0, 0)]
board[0][0] = 1  
direction = 0  
dr = [0, 1, 0, -1]
dc = [1, 0, -1, 0]
time = 0
move_index = 0

while True:
    time += 1
    head_r, head_c = snake[0]
    next_r, next_c = head_r + dr[direction], head_c + dc[direction]


    if (not (0 <= next_r < n and 0 <= next_c < n and board[next_r][next_c] == 0)):
        break

    snake.insert(0, (next_r, next_c))
    board[next_r][next_c] = 1

    if( (next_r, next_c) in apples ):
        apples.remove((next_r, next_c))
    else:
        tail_r, tail_c = snake.pop() 
        board[tail_r][tail_c] = 0

    if (move_index < l and time == moves[move_index][0]):
        if (moves[move_index][1] == 'L'):
            direction = (direction - 1) % 4
        else:
            direction = (direction + 1) % 4
        move_index += 1

print(time)
