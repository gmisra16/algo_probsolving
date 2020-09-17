package algo;

import java.util.Scanner;

public class WeaponValue {
    public static void main(String[] args) throws java.lang.Exception {
        try (Scanner scanner = new Scanner(System.in)) {
            int tc = scanner.nextInt();
            String result = "";
            while(tc-- > 0){
                int N = scanner.nextInt();
                scanner.nextLine();
                result = scanner.nextLine();
                for (int i = 1; i < N; i++) {
                    String S = scanner.nextLine();
                    result = xor(result, S);
                }
            }
            int sum = 0;
            for (int i = 0; i < 10; i++) {
                sum += (result.charAt(i)-'0');
            }
            System.out.print(sum);
        }
    }

    public static String xor(String input1, String input2) {
        //System.out.println(input1+"-"+input2);
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            res.append((input1.charAt(i) - '0') ^ (input2.charAt(i) - '0'));
        }
        //System.out.println(res);
        return res.toString();
    }
}
