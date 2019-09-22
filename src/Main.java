import java.io.IOException;
import java.util.*;
import java.math.*;
import java.text.*;


public class Main {

    public static void subArraySum(int[] arr, int sum) {
        int n = arr.length;
        //cur_sum to keep track of cummulative sum till that point
        int cur_sum = 0;
        int start = 0;
        int end = -1;
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            cur_sum = cur_sum + arr[i];
            //check whether cur_sum - sum = 0, if 0 it means
            //the sub array is starting from index 0- so stop
            if (cur_sum - sum == 0) {
                start = 0;
                end = i;
                break;
            }
            //if hashMap already has the value, means we already
            // have subarray with the sum - so stop
            if (hashMap.containsKey(cur_sum - sum)) {
                start = hashMap.get(cur_sum - sum) + 1;
                end = i;
                break;
            }
            //if value is not present then add to hashmap
            hashMap.put(cur_sum, i);

        }
        // if end is -1 : means we have reached end without the sum
        if (end == -1) {
            System.out.println("No subarray with given sum exists");
        } else {
            System.out.println("Sum found between indexes "
                    + start + " to " + end);
        }

    }

    // Driver code
    public static void main(String[] args) {
        int[] arr = {100, 10, 2, -2, -20, 10};
        int sum = -10;
        //subArraySum(arr, sum);
        System.out.println(test());
    }

    public static int test() {
        try {
            //return -1;
            int i=0;
            //int x= 10/i;
            return 1;
        }  catch (Exception e){
            //return -2;
        }finally {
            //return 0;
        }
        return 10;
    }
}
