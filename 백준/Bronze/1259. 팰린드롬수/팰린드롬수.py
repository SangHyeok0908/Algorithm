import sys

while True:
    reverseNumber = []
    answer = True
    number = list(sys.stdin.readline().rstrip())
    if number[0] == '0':
        break

    for i in reversed(range(len(number))):
        reverseNumber.append(number[i])

    for i in range(len(number)):
        if reverseNumber[i] != number[i]:
            answer = False
            print("no")
            break
    if answer:
        print("yes")