import sys

N = int(sys.stdin.readline())
parenthesis_list = list(sys.stdin.readline().rstrip())
open_list = []
continue_list = []
count = 0
max_count = 0

for index, parenthesis in enumerate(parenthesis_list):
    if parenthesis == '(':
        open_list.append(index)
    elif open_list:
        continue_list.append(open_list.pop())
        continue_list.append(index)
continue_list.sort()

for i in range(1, len(continue_list)):
    if continue_list[i - 1] + 1 == continue_list[i]:
        count += 1
    else:
        count = 0
    
    if max_count < count:
        max_count = count

if max_count < 1:
    print(0)
else:
    print(max_count + 1)