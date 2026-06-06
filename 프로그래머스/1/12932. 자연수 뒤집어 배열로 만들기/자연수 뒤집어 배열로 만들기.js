function solution(n) {
    let temp = String(n).split('');
    temp = temp.map((o) => Number(o));
    
    let answer = Array(temp.length).fill(0);
    for (let i = 0; i < temp.length; i++) {
        answer[i] = temp[temp.length - 1 - i];
    }
    return answer;
}