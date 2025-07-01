N, S = map(int,input().split())
arr = list(map(int,input().split()))

left = 0
right = 0
temp_sum = 0
lower = float('inf')

while ( left < N ):
    
    while(right < N and temp_sum < S):
        temp_sum += arr[right]
        right += 1
        
        
    if( temp_sum >= S ):
        lower = min(lower,right-left)

    temp_sum -= arr[left]
    left += 1
        


print(0) if (lower == float('inf')) else print(lower)