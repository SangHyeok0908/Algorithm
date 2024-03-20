import sys

T = int(sys.stdin.readline())
for _ in range(T):
    input_string = list(sys.stdin.readline().rstrip())
    length = len(input_string)

    if length == 1:
        print(0)
        continue
    else:
        is_print = False
        for i in range(length):
            if input_string[i] != input_string[length - 1 - i]:
                start = i
                end = length - 1 - i
                delete_front_list = input_string[start + 1:end + 1]
                delete_back_list = input_string[start:end]
                length_delete = len(delete_front_list)
                count_front = 0
                count_back = 0

                if length_delete < 2:
                    print(1)
                    is_print = True
                    break

                for j in range(length_delete // 2):
                    if delete_front_list[j] == delete_front_list[length_delete - 1 - j]:
                        count_front += 1
                
                for j in range(length_delete // 2):
                    if delete_back_list[j] == delete_back_list[length_delete - 1 - j]:
                        count_back += 1

                if count_front == length_delete // 2 or count_back == length_delete // 2:
                    print(1)
                    is_print = True
                    break
                else:
                    print(2)
                    is_print = True
                    break
                
        if not is_print:
            print(0)