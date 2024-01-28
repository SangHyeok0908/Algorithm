//
//  1924.c
//  backjoon
//
//  Created by 서상혁 on 1/28/24.
//

#include <stdio.h>

int main(void) {
    int month, day;
    char week[7][4] = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
    
    scanf("%d %d", &month, &day);
    
    switch (month) {
        case 1: // 1월 1일 월요일
            printf("%s\n", week[day % 7]);
            break;
        case 2: // 2월 1일 목요일
            printf("%s\n", week[(day + 3) % 7]);
            break;
        case 3: // 3월 1일 목요일
            printf("%s\n", week[(day + 3) % 7]);
            break;
        case 4: // 4월 1일 일요일
            printf("%s\n", week[(day + 6) % 7]);
            break;
        case 5: // 5월 1일 화요일
            printf("%s\n", week[(day + 1) % 7]);
            break;
        case 6: // 6월 1일 금요일
            printf("%s\n", week[(day + 4) % 7]);
            break;
        case 7: // 7월 1일 일요일
            printf("%s\n", week[(day + 6) % 7]);
            break;
        case 8: // 8월 1일 수요일
            printf("%s\n", week[(day + 2) % 7]);
            break;
        case 9: // 9월 1일 토요일
            printf("%s\n", week[(day + 5) % 7]);
            break;
        case 10: // 10월 1일 월요일
            printf("%s\n", week[day % 7]);
            break;
        case 11: // 11월 1일 목요일
            printf("%s\n", week[(day + 3) % 7]);
            break;
        case 12: // 12월 1일 토요일
            printf("%s\n", week[(day + 5) % 7]);
            break;
            
        default:
            break;
    }
    
    
    
    return 0;
}
