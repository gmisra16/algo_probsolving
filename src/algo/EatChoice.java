package algo;


import java.util.*;

public class EatChoice {


    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int tc = scanner.nextInt();

            for (int i = 0; i < tc; i++) {
                int N = scanner.nextInt();
                int M = scanner.nextInt();
                int max = 0;
                int max2 = 0;
                Map<Integer,Integer> map = new HashMap();
                for (int j = 0; j < N; j++) {

                    int D = scanner.nextInt();
                    int V = scanner.nextInt();
                    if(!(D>=1&&D<=M))continue;
                    if(map.containsKey(D)){
                        if(map.get(D)<V)map.put(D,V);
                    }else map.put(D,V);

                }
                for(int k :map.values()){
                    if (k > max) {
                        max2 = max;
                        max = k;
                    } else if (k > max2) {
                        max2 = k;
                    }
                }
                System.out.println(max + max2);
            }
        }
    }
}
