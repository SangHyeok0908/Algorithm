import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();
        String result = String.valueOf(A * B * C);

        for(int i = 0; i <= 9; i++) {
            int count = 0;
            for(char c : result.toCharArray()) {
                if (i == c - '0') {
                    count++;
                }
            }

            System.out.println(count);
        }
    }
}
