package algo;

import java.util.Scanner;

public class DistributeApples {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int tc = scanner.nextInt();
            for (int i = 0; i < tc; i++) {
                String  S = scanner.next();
                int faceUp = 0;
                for (int j = 0; j < S.length(); j++) {
                    faceUp += (S.charAt(j)-'0');
                }
                if(S.length() <= 2){
                    if(faceUp==1){
                        System.out.println("WIN");
                    }else{
                        System.out.println("LOSE");
                    }
                }else{
                    if(faceUp%2!=0){
                        System.out.println("WIN");
                    }else{
                        System.out.println("LOSE");
                    }
                }

            }
        }
    }

}
