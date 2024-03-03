import sys

N = int(sys.stdin.readline())
operand_list = []
opcode_list = []
rank_list = [i for i in range(1, N + 1)]
isPossible = True

for _ in range(N):
    temp = int(sys.stdin.readline())

    if temp in rank_list:
        while rank_list and temp >= rank_list[0]:
            operand_list.append(rank_list.pop(0))
            opcode_list.append('+')
    elif temp != operand_list[-1]:
        isPossible = False

    if isPossible:
        operand_list.pop()
        opcode_list.append('-')
    # print(operand_list, opcode_list, rank_list)

if isPossible:
    for o in opcode_list:
        print(o)
else:
    print("NO")