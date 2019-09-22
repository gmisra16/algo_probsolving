package algo;

class Permute {

    public static void permutation(String str) {
        permute("", str);
        System.out.println("*************");
        permute2(str,0);
    }

    private static void permute(String prefix, String str) {
        int n = str.length();
        if (n == 0) System.out.println(prefix);
        else {
            for (int i = 0; i < n; i++)
                permute(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
        }
    }

    private static void permute2(String str, int index) {
        int n = str.length();
        if (index>=n-1) System.out.println(str);
        else {
            for (int i = index; i < n; i++){
                String strTemp = swap(str,index,i);
                permute2(strTemp ,index+1);
            }

        }
    }
    private static String swap(String str, int index1, int index2){
        char[] arr = str.toCharArray();
        if(index1==index2)return str;
        else {
            char temp = arr[index1];
            arr[index1] = arr[index2];
            arr[index2] = temp;
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        permutation("ABC");
    }
}
