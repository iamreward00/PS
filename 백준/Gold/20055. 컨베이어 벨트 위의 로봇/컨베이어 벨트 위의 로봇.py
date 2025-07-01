N, K = map(int, input().split())

durability_belt = list(map(int, input().split()))
robots_on_belt = [0] * N

stage = 0
zero_durability_count = 0

while True:
    stage += 1
    durability_belt = [durability_belt[-1]] + durability_belt[:-1]
    robots_on_belt = [0] + robots_on_belt[:-1] 
    if (robots_on_belt[N - 1] == 1):
        robots_on_belt[N - 1] = 0

    for i in range(N - 2, -1, -1):
        if (robots_on_belt[i] == 1): 
            if (robots_on_belt[i + 1] == 0 and durability_belt[i + 1] >= 1):
                robots_on_belt[i + 1] = 1 
                robots_on_belt[i] = 0    
                durability_belt[i + 1] -= 1 

                if (durability_belt[i + 1] == 0):
                    zero_durability_count += 1
    

    if (robots_on_belt[N - 1] == 1):
        robots_on_belt[N - 1] = 0
    if (durability_belt[0] >= 1 and robots_on_belt[0] == 0):
        robots_on_belt[0] = 1   
        durability_belt[0] -= 1

        if (durability_belt[0] == 0):
            zero_durability_count += 1

    if (zero_durability_count >= K):
        print(stage)
        break