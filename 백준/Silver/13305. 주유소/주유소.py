N = int(input())
road = list(map(int, input().split()))
gas = list(map(int, input().split()))

minGas = gas[0]
ans = 0
for i in range(N - 1):
    if minGas < gas[i]:
        minGas = gas[i]
    ans += minGas * road[i]
print(ans)