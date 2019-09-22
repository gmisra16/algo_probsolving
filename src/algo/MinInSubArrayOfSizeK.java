package algo;

import java.io.*;
import java.util.*;
public class MinInSubArrayOfSizeK {
    public static void main(String args[] ) throws Exception {

        //Write code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] a = new int[n];
        int min = Integer.MAX_VALUE;
        int min_index=0;
        for(int i=0; i<n; i++){
            a[i] = scanner.nextInt();
        }
        Deque<Integer> queue = new LinkedList<>();
        for(int i=0; i<k; i++){
            while(!queue.isEmpty() &&a[i]<=a[queue.peekLast()]){
                queue.removeLast();
            }
            queue.addLast(i);
        }

        for(int i=k; i<n; i++){
            System.out.print(a[queue.peek()]+" ");
            while(!queue.isEmpty() && i-k >= queue.peek())queue.removeFirst();
            while(!queue.isEmpty() && a[i]<=a[queue.peekLast()])queue.removeLast();

            queue.addLast(i);
        }
        System.out.print(a[queue.peek()]);
    }
}