import sys

parenthesis = sys.stdin.readline().rstrip()
stick = []
result = 0

for i in range(len(parenthesis) - 1):
    if parenthesis[i] == '(' and parenthesis[i + 1] == ')':
        if stick:
            for i in range(len(stick)):
                stick[i] += 1
    elif parenthesis[i] == '(':
        stick.append(1)
    elif parenthesis[i - 1] != '(' and parenthesis[i] == ')':
        result += stick.pop()
if stick:
    result += stick.pop()
print(result)