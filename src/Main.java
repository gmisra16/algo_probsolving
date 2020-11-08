import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


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
    //int[] arr = {100, 10, 2, -2, -20, 10};
    //int sum = -10;
    //subArraySum(arr, sum);
    //System.out.println(test());
    //test1();
    //numberCycle();
    //System.out.printf(""+findDuplicate());
    //coupan();
        /*String[] array = new String[]{"aaa","aab","aac","aba","abb","abc","aca","acb","acc",
          "baa","bab","bac","bba","bbb","bbc","bca","bcb","bcc","caa","cab",
          "cac","cba","cbb","cbc","cca","ccb","ccc"};
          Arrays.stream(array).forEach(i->nextPerm(i,new char[]{'a','b','c'}));*/
    //nextPerm("ayy",new char[]{'a','y'});
    //testSum();

    /*int x= (int)(1000000000-1000000);
    int y= (int)(1000000000);
    System.out.println(findPrime(1,13));*/
    //System.out.println(compress("BCBCA"));
    /*HashSet<Long> set = new HashSet<>(1000);
    for (int i = 1; i < 1000_000_000; i++) {
      long sum =(i*(i+1l))/2l;
      long x= (long)(Math.sqrt(1l+4*sum)-1l)/2l;
      if(x*(x+1) ==sum)System.out.println(i);

    }*/
    //System.out.println(triplet(Arrays.asList(1,2,2,2,4),8));
    /*ListNode l = new ListNode(1);
    l.next= new ListNode(2);
    l.next.next=new ListNode(3);
    TreeNode t = sortedListToBST(l);
    System.out.println(t);*/
    for (int i = 0; i < 10; i++) {
      System.out.println(minSteps(i));
    }

  }
  /****************/
  public static int minSteps(int n) {
    return calc(n,1,0);

  }

  public static int calc(int n, int buf, int res) {
    if(n==0)return res;
    if(n < 0)return Integer.MAX_VALUE;
    return Math.min(calc(n-buf,buf,res+1),calc(n-2*buf,2*buf,res+2));
  }
  /****************/

  private static ListNode head;

  public static TreeNode sortedListToBST(ListNode list) {
    if(list == null){
      return null;
    }
    int size = countNode(list);
    //ListNode runner = list;
    head = list;
    return inorderHelper(0, size - 1);
  }

  public static int countNode(ListNode list) {
    int size=0;
    while(list != null){
      list = list.next;
      size ++;
    }
    return size;
  }

  public static TreeNode inorderHelper(int start, int end){
    if(start > end){
      return null;
    }
    int mid = start + (end - start) / 2;
    TreeNode left = inorderHelper(start, mid - 1);
    TreeNode root = new TreeNode(head.val);
    root.left = left;
    head = head.next;
    TreeNode right = inorderHelper(mid + 1, end);
    root.right = right;
    return root;
  }

    //Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

  public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

  static void run_case( int[] A) {
    int N = A.length;
    int[] freq = new int[N*N];
    long total = 0;
    for (int j = N - 1; j >= 0; j--) {
      int k = j + 1;
      for (int l = k + 1; l < N; l++)
        freq[A[k] * N + A[l]]++;
      for (int i = 0; i < j; i++)
        total += freq[A[i] * N + A[j]];
    }
    System.out.println(total);
  }

  static long triplet(List<Integer> capacity, long desiredCapacity){
    Map<Integer,List<Integer>> cap = new HashMap<>();
    for (int i = 0; i < capacity.size(); i++) {
      int key = capacity.get(i);
      if(cap.containsKey(key)){
        cap.get(key).add(i);
      }else{
        List<Integer> indexes  = new ArrayList<>();
        indexes.add(i);
        cap.put(key, indexes);
      }
    }
    List<Long> doublet = new ArrayList<>();
    for (int i = 1; i < capacity.size(); i++) {
      long d = capacity.get(i-1)*capacity.get(i);
      doublet.add(d);
    }
    System.out.println(doublet);
    System.out.println(cap);
    //1 2 2 2 4
    //handle 2 4 4 8
    //4 2 2 1
    long res=0;
    for (int i = 0; i < doublet.size(); i++) {
      int left = (int)(desiredCapacity/doublet.get(i));
      if(left*doublet.get(i)==desiredCapacity
        && cap.containsKey(left)){
        List<Integer> indexes = new ArrayList<>(cap.get(left));
        indexes.remove(Integer.valueOf(i));
        indexes.remove(Integer.valueOf(i+1));
        if(indexes.size()>0){
          System.out.println(left+"-"+i);
          res++;
        }
      }
    }
    return res;
  }

  static String compress(String str){

    int i = 0;
    int n = str.length();
    String ans = "";
    while(n>0){
      if(n%2==0 && str.substring(i,n/2).equals(str.substring(n/2,n))){
        ans = compress(str.substring(i,n/2))+"*"+ans;
        break;
      }else{
        ans = str.substring(n-1,n)+ans;
        n--;
      }
    }

    return ans;
  }

  void method(long l, long r){
    for (long i = l; i <=r ; i++) {
      //while()
    }
  }
  static int findPrime(int n, int m) {
    int rootM = (int) Math.sqrt(m);
    List<Integer> primes = new ArrayList<>();
    primes.add(2);
    for (int i = 3; i <= rootM; i=i+2) {
      boolean isPrime = true;
      for (int j = 0; primes.get(j)*primes.get(j) <= i ; j++) {
        if (i % primes.get(j) == 0) {
          isPrime = false;
          break;
        }
      }
      if (isPrime){
        primes.add(i);
      }
    }
    System.out.println(primes);
    int count=0;
    if(n%2==0)n++;
    int prev =-1;
    boolean inPrimes= true;
    for (int i = n; i <=m; i=i+2) {
      if(inPrimes && primes.contains(i)){
        if ((i - prev) == 2)count++;
        prev=i;
      }else{
        inPrimes=false;
        boolean isPrime = true;
        for (int j = 0; j<primes.size() && primes.get(j) * primes.get(j) <= i ; j++) {
          if (i % primes.get(j) == 0) {
            isPrime = false;
            break;
          }
        }
        if (isPrime){
          if ((i - prev) == 2) count++;
          prev = i;
        }
      }
    }
    return count;

  }


  public static void testSum() {
    boolean[] arr = new boolean[1000];
    for (int i = 0; i < 500; i++) {
      if (arr[i]) continue;
      for (int j = i - 1; j >= 0; j--) {
        if (arr[j]) continue;
        if (i + j > i) {
          //if(arr[i+j])arr[i]=true;
          arr[i + j] = true;
        }

      }
    }
    int count[] = new int[1000];
    int k = 0;
    for (int i = 1; i < 1000; i++) {
      if (!arr[i]) count[k++] = i;
    }
    System.out.println(k);
    System.out.println(Arrays.toString(count));
    //System.out.println(count);

    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        if (i == j) System.out.print("0 ");
        else System.out.print((count[i] + count[j]) + " ");
      }
      System.out.println();
    }

  }

  public static void graph() {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int[] res = new int[n];
    for (int i = 0; i < n; i++) {
      boolean[] good = new boolean[1001];
      Arrays.fill(good, true);
      for (int j = 0; j < i; j++) {
        good[res[j]] = false;
        for (int k = j + 1; k < i; k++)
          for (int l = 0; l < i; l++) {
            if (res[j] + res[k] - res[l] > 0)
              good[res[j] + res[k] - res[l]] = false;
          }
      }
      System.out.println(Arrays.toString(good));
      for (int j = 1; j <= 1000; j++) {
        if (good[j]) {
          res[i] = j;
          break;
        }
      }
      System.out.println(Arrays.toString(res));
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (i == j) System.out.print("0 ");
        else System.out.print((res[i] + res[j]) + " ");
      }
      System.out.println();
    }
  }

  public static void nextPerm(String s, char[] arr) {
    StringBuilder ans = new StringBuilder();
    StringBuilder suff = new StringBuilder();
    for (int i = s.length() - 1; i >= 0; i--) {
      if (s.charAt(i) == arr[arr.length - 1]) {
        suff.append(arr[0]);
        continue;
      }
      char toBeReplace = s.charAt(i);
      int index = Arrays.binarySearch(arr, toBeReplace);
      char replaceBy = arr[index + 1]; //next char in sequence
      ans.append(s.substring(0, i)).append(replaceBy).append(suff);
      break;
    }
    System.out.println(ans);

  }

  public static void coupan1() throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(reader.readLine());

    if (n == 1) {
      System.out.println(6);
      return;
    }

    char[][] nums = new char[n][6];
    for (int i = 0; i < n; i++) {
      nums[i][0] = (char) reader.read();
      nums[i][1] = (char) reader.read();
      nums[i][2] = (char) reader.read();
      nums[i][3] = (char) reader.read();
      nums[i][4] = (char) reader.read();
      nums[i][5] = (char) reader.read();
      reader.readLine();
    }

    int maxCount = 0;

    for (int i = 0; i < n - 1; i++) {
      for (int y = i + 1; y < n; y++) {
        int count = 0;
        // 1
        if (nums[i][0] == nums[y][0])
          count++;
        if (nums[i][1] == nums[y][1])
          count++;
        if (nums[i][2] == nums[y][2])
          count++;
        if (nums[i][3] == nums[y][3])
          count++;
        if (nums[i][4] == nums[y][4])
          count++;
        if (nums[i][5] == nums[y][5])
          count++;

        if (count >= 4) {
          System.out.println(0);
          return;
        } else if (maxCount < count)
          maxCount = count;
      }
    }
    if (maxCount == 3 || maxCount == 2)
      System.out.println(1);
    else
      System.out.println(2);

  }

  public static void coupan() {
    String[] s = new String[1001];
    int ans = 6;
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    for (int i = 0; i < n; ++i) {
      s[i] = scanner.next();
      for (int j = 0; j < i; ++j) {
        int temp = 0;
        for (int k = 0; k < 6; ++k) {
          if (s[i].charAt(k) != s[j].charAt(k)) {
            ++temp;
          }
        }
        ans = Math.min(ans, (temp - 1) / 2);
      }
    }
    System.out.println(ans);


  }

  public static int findDuplicate() {
    int[] nums = new int[]{1, 2, 2};
    int n = nums.length - 1, res = 0;
    for (int bit = 0; bit < 32; ++bit) {
      int currentBit = (1 << bit), a = 0, b = 0;
      for (int i = 0; i <= n; ++i) {
        if ((i & currentBit) > 0) ++a;
        if ((nums[i] & currentBit) > 0) ++b;
      }
      System.out.println(currentBit + "::" + bit + ":" + a + "-" + b);
      if (b > a) res += currentBit;
    }
    return res;
  }

  public static void numberCycle() {
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        System.out.print("For: " + i + "" + j + " ");
        String intg = String.valueOf(i) + j;
        int sum = i + j;
        for (int k = 0; k < 20; k++) {
          int mod = sum % 10;
          intg += mod;
          sum += mod;
        }
        System.out.println(intg);
      }
    }

  }

  public static void test1() {
    String pat = "0010000010000110000100001100001000001000011000010000110000100000100001100001000011000010000010000110000010000110000100001100001000001000011000010000110000100000100001100001000011000010000010000110000110000110000100001100001000001000011000010000110000100000100001100001000011000010000010000110000100000110000100001100001000001000011000010000110000100000100001100001000011000010000010000110000100001100001000001000011000010000110000100000100001100001000011000010000010000110000100001100001000001000011000001000011000010000110000100000100001100001000011000010000010000110000100001100001000001000011000011000011000010000110000100000100001100001000011000010000010000110000100001100001000001000011000010000011000010000110000100000100001100001000011000010000010000110000100001100001000001000011000010000110000100000100001100001000011000010000010000110000100001100001000001000011000010000110000100000100001100000100001100001000011000010000010000110000100001100001000001000011000010000110000100000100001100001100001100001000011000010000010000110000100001100001000001000011000010000110000100000100001100001000001100001000011000010000010000110000100001100001000001000011000010000110000100000100001100001000011000010000010000110000100001100001000001000011000010000110000100000100001100001000011000010000010000110000010000110000100001100001000001000011000010000110000100000100001100001000011000010000010000110000110000110000100001100001000001000011000010000110000100000100001100001000011000010000010000110000100000110000100001100001000001000011000010000110000100000100001100001000011000010000010000110000100001100001000001000011000010000110000100000100001100001000011000010000010000110000100001100001000001000011000001000011000010000110000100000100001100001000011000010000010000110000100001100001000001000011000011000011000010000110000100000100001100001000011000010000010000110000100001100001000001000011000010000011000010000110000100000100001100001000011000010000010000110000100001100001000001000011000010000110000100000100001100001000011000010000010000110000100001100001000001000011000010000110000100000100001100000100001100001000011000010000010000110000100001100001000001000011000010000110000100000100001100001100001100001000011000010000010000110000100001100001000001000011000010000110000100000100001100001000001100001000011000010000010000110000100001100001000001000011000010000110000100000100001100001000011000010000010000110000100001100001000001000011000010000110000100000100001100001000011000010000010000110000010000110000100001100001000001000011000010000110000100000100001100001000011000010000010000110000110000110000100001100001000001000011000010000110000100000100001100001000011000010000010000110000100000110000100001100001000001000011000010000110000100000100001100001000011000010000010000110000100001100";
    int count = 0;
    for (int i = 2599; i < 2800; i++) {
      count += (pat.charAt(i) - '0');
    }
    System.out.println(count);
        /*for (int i = 1; i <=28*100; i++) {
            System.out.println(2 + " " + i);
            System.out.println(2 + " " + i);

        }*/
  }

  public static int test() {
    try {
      //return -1;
      int i = 0;
      //int x= 10/i;
      return 1;
    } catch (Exception e) {
      //return -2;
    } finally {
      //return 0;
    }
    return 10;
  }

  static int findMaxPath(int mat[][]) {
    // To find max val in first row
    int res = -1;
    for (int i = 0; i < mat[0].length; i++)
      res = Math.max(res, mat[0][i]);

    for (int i = 1; i < mat.length; i++) {
      res = -1;
      for (int j = 0; j < mat[i].length; j++) {
        // When all paths are possible
        if (j > 0 && j < mat[i].length - 1)
          mat[i][j] += Math.max(mat[i - 1][j],
            Math.max(mat[i - 1][j - 1],
              mat[i - 1][j + 1]));
          // When diagonal right is not possible
        else if (j > 0)
          mat[i][j] += Math.max(mat[i - 1][j],
            mat[i - 1][j - 1]);
          // When diagonal left is not possible
        else if (j < mat[i].length - 1)
          mat[i][j] += Math.max(mat[i - 1][j],
            mat[i - 1][j + 1]);

        // Store max path sum
        res = Math.max(mat[i][j], res);
      }
    }
    return res;
  }

  int squareSum(int[][] prefixSum, int x1, int y1, int x2, int y2) {
    return prefixSum[x2][y2] - prefixSum[x1][y2] - prefixSum[x2][y1] + prefixSum[x1][y1];
  }

  public int maxSideLength(int[][] mat, int threshold) {
    int m = mat.length, n = mat[0].length;
    int[][] prefixSum = new int[m + 1][n + 1];
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1] + mat[i - 1][j - 1];
      }
    }
    int res = 0;
    for (int i = 0; i <= m; i++) {
      for (int j = 0; j <= n; j++) {
        int len = res + 1;
        while (i + len <= m && j + len <= n && squareSum(prefixSum, i, j, i + len, j + len) <= threshold) {
          res = len;
          len++;
        }
      }
    }
    return res;
  }

  static class Pair implements Comparable {
    int first;
    int second;

    @Override
    public int compareTo(Object o) {
      Pair p = (Pair) o;
      if (this.first > p.first) {
        return 1;
      } else if (this.first < p.first) {
        return -1;
      }
      return 0;
    }

    @Override
    public String toString() {
      return "{f: " + first + " s: " + second + "}";
    }
  }
}
