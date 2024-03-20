import sys

def function(string_list, len_string):
    count = 0
    for i in range(len_string // 2):
        if string_list[i] == string_list[len_string - 1 - i]:
            count += 1
    if count == len_string // 2:
        return True
    return False

T = int(sys.stdin.readline())
for _ in range(T):
    input_string = list(sys.stdin.readline().rstrip())
    length = len(input_string)
    is_print = False

    for i in range(length):
        if input_string[i] == input_string[length - 1 - i]:
            continue
        is_print = True
        start = i
        end = length - 1 - i
        deleted_front_list = input_string[start + 1:end + 1]
        deleted_back_list = input_string[start:end]
        length = len(deleted_front_list)

        if function(deleted_front_list, length):
            print(1)
            break
        elif function(deleted_back_list, length):
            print(1)
            break
        else:
            print(2)
            break       
         
    if not is_print:
        print(0)