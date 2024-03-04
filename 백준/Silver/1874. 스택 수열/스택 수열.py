import sys

N = int(sys.stdin.readline())
operand_list = []
opcode_list = []
rank_list = [i for i in range(1, N + 1)]
rank_list.sort(reverse= True)
isPossible = True

for _ in range(N):
    temp = int(sys.stdin.readline())

    if operand_list and operand_list[-1] > temp:
        isPossible = False

    while rank_list:
        if temp < rank_list[-1]:
            break
        operand_list.append(rank_list.pop())
        opcode_list.append('+')

    operand_list.pop()
    opcode_list.append('-')

if isPossible:
    for o in opcode_list:
        print(o)
else:
    print("NO")