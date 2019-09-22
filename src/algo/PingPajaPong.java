package algo;

import java.util.Scanner;

public class PingPajaPong {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int tc = scanner.nextInt();
            for (int i = 0; i < tc; i++) {
                int X = scanner.nextInt();
                int Y = scanner.nextInt();
                int K = scanner.nextInt();
                long games = X+Y;
                long divident = games/K;
                if(divident%2==0){
                    System.out.println("Chef");
                }else{
                    System.out.println("Paja");
                }
            }

        }
    }
}
