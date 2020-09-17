package algo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ThatIsMyScore {
  public static void main(String[] args) throws java.lang.Exception {
    try (Scanner scanner = new Scanner(System.in)) {
      int T = scanner.nextInt();

      while (T-- > 0) {
        Map<Integer, Integer> probMap = new HashMap<>();
        int N = scanner.nextInt();
        for (int i = 0; i < N; i++) {
          int p = scanner.nextInt();
          int s = scanner.nextInt();
          if(p<=8){
            if(probMap.containsKey(p)){
              if(probMap.get(p)<s){
                probMap.put(p,s);
              }
            }else{
              probMap.put(p,s);
            }
          }
        }

        System.out.println(probMap.values().stream().mapToInt(Integer::intValue).sum());
      }
    }
  }

}
