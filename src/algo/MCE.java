package algo;

import java.util.Scanner;

public class MCE {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int T = scanner.nextInt();

            for (int tc = 0; tc < T; tc++) {
                int N = scanner.nextInt();
                scanner.nextLine();
                String S = scanner.nextLine();
                String U = scanner.nextLine();
                int result = 0;
                boolean discard = false;
                for (int i = 0; i < N; i++) {
                    if (discard ) {
                        discard = false;
                        continue;
                    }
                    if(U.charAt(i) == 'N'){
                        continue;
                    }
                    if (U.charAt(i) == S.charAt(i)) result++;
                    else discard = true;
                }
                System.out.println(result);

            }
        }
    }
}
