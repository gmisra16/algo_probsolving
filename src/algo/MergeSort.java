package algo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MergeSort {

    private static Integer[] sortArr;
    private static Integer[] temp;

    public static int msort(List<Integer> a) {
        sortArr = new Integer[a.size()];
        temp = new Integer[sortArr.length];
        a.toArray(sortArr);
        return msort(0, sortArr.length - 1);
        //return Arrays.asList(sortArr);
    }

    public static int msort(int start, int end) {
        //System.out.println(start +"-"+end);
        if (start == end) return 0;
        //prevent overflow
        int mid = start + (end - start) / 2;
        int leftCount = 0, rightCount = 0;
        if (start < end) {
            //sort left half
            leftCount = msort(start, mid);
            //sort right half
            rightCount = msort(mid + 1, end);
        }
        return leftCount + rightCount + merge(start, mid, end);
    }

    public static int merge(int start, int mid, int end) {
        //System.out.println(start+"-"+mid+"-"+end);
        int inverseCount = 0;
        int lstart = start;
        int rstart = mid + 1;
        int k = start;
        while (lstart <= mid && rstart <= end) {
            if (sortArr[lstart] <= sortArr[rstart]) {
                temp[k++] = sortArr[lstart++];
            } else {
                temp[k++] = sortArr[rstart++];
                inverseCount += (mid + 1 - lstart);
            }
        }

        while (lstart <= mid) {
            temp[k++] = sortArr[lstart++];
            //inverseCount++;
        }

        while (rstart <= end) {
            temp[k++] = sortArr[rstart++];
        }
        int l = start;
        while (l <= end) {
            sortArr[l] = temp[l];
            l++;
        }
        return inverseCount;
    }

    public static int sort(List<Integer> a) {
        int inverseCount = 0;
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            for (int j = i + 1; j < a.size(); j++) {
                int itemi = a.get(i);
                int itemj = a.get(j);
                if (itemi > itemj) {
                    //a.set(i,itemj);
                    //a.set(j,itemi);
                    inverseCount++;
                }
            }
        }
        return inverseCount;
    }

    public static void main(String[] args) {
        Integer[] ints = {31, 51, 31, 51, 31, 31, 31, 31, 31, 31, 51, 31, 31};
        //Integer[] ints = {7,7,8,8,9,10,6};
        //System.out.println(msort(Arrays.asList(ints)));
        //System.out.println(sort(Arrays.asList(ints)));
        //ArrayList<Integer> intList = new ArrayList<Integer>();
        for (int i = 1; i < 7; i++) {
            List<Integer> intList = IntStream.rangeClosed(0, (int) Math.pow(10, i))
                    .boxed().collect(Collectors.toList());
            intList.set(0, (int) Math.pow(10, i + 1));
            long start = System.currentTimeMillis();
            System.out.print(msort(intList) + "--");
            System.out.printf("Time for %d is %d sec  ", (int) Math.pow(10, i) + 1, (System.currentTimeMillis() - start));
            start = System.currentTimeMillis();
            System.out.print(sort(intList) + "--");
            System.out.printf(" and  %d sec", (System.currentTimeMillis() - start));
            System.out.println();
        }
    }
}

