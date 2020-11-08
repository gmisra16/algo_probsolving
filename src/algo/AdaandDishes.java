package algo;

import java.util.Arrays;
import java.util.Scanner;

public class AdaandDishes {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int tc = scanner.nextInt();
            for (int t = 0; t < tc; t++) {
                int N = scanner.nextInt();
                int[] c = new int[N];
                for (int j = 0; j < N; j++) {
                    c[j] = scanner.nextInt();

                }
                Arrays.sort(c);
                int time=0;
                if(N==1){
                    time=c[0];
                }else if(N==2){
                    time =Math.max(c[0],c[1]);
                }else if(N==3){
                    time =Math.max(c[0]+c[1],c[2]);
                }else if(N==4){
                    if(c[1]+c[2] <=c[3]){
                        time = Math.max(c[3],c[0]+c[1]+c[2]);
                    }else {
                        time = Math.max(c[0]+c[3],c[1]+c[2]);
                    }
                }else if(N==5){
                    if(c[4] == c[3]){
                      time = c[4] + Math.max(c[0]+c[1],c[2]);
                    }else {
                        if(c[2] + c[3] >= c[4]){
                            if(c[2] + c[3] >= c[4] + c[0]){
                                time = Math.max(c[2]+c[3],c[4] + c[1] + c[0]);
                            }else{
                                time = Math.max(c[1] + c[2]+c[3],c[4] + c[0]);
                            }
                        }else{
                            if(c[2] + c[3] + c[1]>=c[4]){
                                time = Math.max(c[2]+c[3]+c[1],c[4] + c[0]);
                            }else{
                                time = Math.max(c[2]+c[3]+c[1]+c[0],c[4]);
                            }
                        }
                    }
                }
                System.out.println(time);
            }
        }
    }
}
