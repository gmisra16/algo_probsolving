package algo;
/*
 * Enter your code here. Read input from STDIN. Print your output to STDOUT.
 * Your class should be named CandidateCode.
 */

import java.util.*;

public class KadaneModified {
    public static void main(String args[]) throws Exception {
        //Write code here
        Scanner scanner = new Scanner(System.in);
        int tc = scanner.nextInt();
        for (int i = 0; i < tc; i++) {
            int size = scanner.nextInt();
            int[] arr = new int[size];
            for (int j = 0; j < size; j++) {
                arr[j] = scanner.nextInt();
            }
            getNonContMaxSum(arr);
            System.out.println();
        }
        scanner.close();

    }
    //better way to
    static class SubSeq {
        private final int index;
        private final SubSeq parentSubSeq;
        SubSeq(int data, SubSeq parent) {
            this.index = data;
            this.parentSubSeq = parent;
        }
        public int getIndex(){
            return this.index;
        }
        public SubSeq getParentSubSeq(){
            return this.parentSubSeq;
        }
    }

    /*
    without adjacent elements being included . required answer being {0, 3}
    here the list is a sequence such as {4, 3, 3, 4} for which you want the indices of highest answer
    */
    static List<Integer> getNonContMaxSum(int[] list) {
        SubSeq includeIndices = new SubSeq(0, null);
        SubSeq excludeIndices = null;
        int incl = list[0];
        int excl = 0;
        //start from element at index = 1 //0 based indexing
        for (int i = 1; i < list.length; i++) {
            if (incl > excl) {
                /* current max excluding i */
                int temp = incl;
                SubSeq tempIndex = includeIndices;
                /* current max including i */
                includeIndices = new SubSeq(i, excludeIndices);

                excludeIndices = tempIndex;

                incl = excl + list[i];
                excl = temp;
            } else {
                /* current max excluding i */
                //no change required here
                /* current max including i */
                includeIndices = new SubSeq(i, excludeIndices);
                incl = excl + list[i];
            }
        }

        SubSeq ansSubSeq = (incl > excl) ? includeIndices : excludeIndices;
        //print return path
        LinkedList<Integer> ans = new LinkedList<>();
        while (ansSubSeq != null) {
            ans.addLast(ansSubSeq.index);
            ansSubSeq = ansSubSeq.parentSubSeq;
        }
        ans.forEach(i->System.out.print(list[i]));
        return ans;
    }
}

