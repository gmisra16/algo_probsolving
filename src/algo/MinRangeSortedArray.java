package algo;

import java.util.Arrays;

public class MinRangeSortedArray {
  public static int[] smallestRange(int[][] nums) {
    int minx = 0, miny = Integer.MAX_VALUE;
    for (int i = 0; i < nums.length; i++) { // 1
      for (int j = 0; j < nums[i].length; j++) { // 1
        for (int k = i; k < nums.length; k++) { //2
          for (int l = (k == i ? j : 0); l < nums[k].length; l++) { //2
            int min = Math.min(nums[i][j], nums[k][l]);
            int max = Math.max(nums[i][j], nums[k][l]);
            int n, m;
            for (m = 0; m < nums.length; m++) {
              for (n = 0; n < nums[m].length; n++) {
                if (nums[m][n] >= min && nums[m][n] <= max)
                  break;
              }
              if (n == nums[m].length)
                break;
            }
            if (m == nums.length) {
              if (miny - minx > max - min || (miny - minx == max - min && minx > min)) {
                miny = max;
                minx = min;
              }
            }
          }
        }
      }
    }
    return new int[] {minx, miny};
  }

  public static void main(String[] args) {

  }
}
