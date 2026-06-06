function solution(n)
{
    const str = String(n);
    let answer = Number(str.substring(0, 1));
    let i = 1;
    
    while(i < str.length) {
        answer += Number(str.substring(i, i + 1));
        i++;
    }

    return answer;
}