import sys

def binarySerarch(array, target, start, end):
    mid = (start + end) // 2
    if start > end:
        return 0
    elif array[mid] == target:
        return countCard.get(target)
    elif array[mid] < target:
        return binarySerarch(array, target, mid + 1, end)
    return binarySerarch(array, target, start, mid - 1)
    
N = int(sys.stdin.readline())
cardN = list(map(int, sys.stdin.readline().split()))
cardN.sort()
M = int(sys.stdin.readline())
cardM = list(map(int, sys.stdin.readline().split()))
countCard = {}

for card in cardN:
    if card in countCard:
        countCard[card] += 1
    else:
        countCard[card] = 1

for card in cardM:
    print(binarySerarch(cardN, card, 0, len(cardM) - 1), end= ' ')
print()