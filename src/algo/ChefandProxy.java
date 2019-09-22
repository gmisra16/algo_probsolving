package algo;

import java.util.Scanner;

public class ChefandProxy {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int tc = scanner.nextInt();

            for (int i = 0; i < tc; i++) {
                int days = scanner.nextInt();
                int present=0;
                String attendence = scanner.next();
                for (int j = 0; j< days; j++) {
                    if ("P".equalsIgnoreCase(String.valueOf(attendence.charAt(j)))) present++;
                }
                System.out.println(solve(days, present, attendence));
            }
        }

    }

    public static int solve(int days, int present, String attendance) {
        //using ceil to get integer >= 75%
        int per75 = (int)Math.ceil(days*0.75);
        //System.out.println(per75);
        if(present>=per75)return 0;
        int canBeProxied = 0;
        for (int i = 2; i < attendance.length()-2; i++) {
            if('A'==attendance.charAt(i)){
                if((attendance.charAt(i-1)=='P'||attendance.charAt(i-2)=='P')&&(attendance.charAt(i+1)=='P'||attendance.charAt(i+2)=='P')){
                    canBeProxied++;
                    System.out.println(i+"--");
                }
            }
        }
        if(per75>canBeProxied+present) return -1;
        else return per75-present;
    }

}
