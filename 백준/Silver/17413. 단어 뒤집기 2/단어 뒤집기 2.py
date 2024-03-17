import sys
from collections import deque

input_string = deque(sys.stdin.readline().rstrip())
reverse_string = deque()
output_string = ''
is_reverse = True

while input_string:
    character = input_string.popleft()
    if character == '<':
        while reverse_string:
            output_string += reverse_string.pop()
        is_reverse = False
        output_string += character
        continue
    elif character == '>':
        is_reverse = True
        output_string += character
        continue
    elif character == ' ' and is_reverse:
        while reverse_string:
            output_string += reverse_string.pop()
        output_string += character
        continue

    if is_reverse:
        reverse_string.append(character)
    else:
        output_string += character

while reverse_string:
    output_string += reverse_string.pop()
print(output_string)