package algo;

import java.util.HashMap;
import java.util.Map;

public class LCS {
    Map<String, Map<String, Integer>> memo = new HashMap<>();
    public LCS(){
        System.out.println("Constructor");
    }

    public int longestCommonSubSequence(String str1, String str2){
        //System.out.println(str1+"-"+str2);
        if(str1.length()==0||str2.length()==0)return 0;
        if(str1.charAt(0)==str2.charAt(0)){
            return 1+ longestCommonSubSequence(str1.substring(1), str2.substring(1));
        }else{
            return Math.max(longestCommonSubSequence(str1.substring(1), str2),longestCommonSubSequence(str1, str2.substring(1)));
        }
    }

    public int longestCommonSubSequenceDP(String str1, String str2){
        //System.out.println(str1+"-"+str2);
        int[][] memo = new int[str1.length()][str2.length()];
        //int result =0;
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                if(i==0 || j==0){
                    if(str1.charAt(i)==str2.charAt(j)){
                        memo[i][j]=1;
                    }else{
                        memo[i][j]=0;
                    }

                }else if(str1.charAt(i-1)==str2.charAt(j-1)){
                    memo[i][j] = 1+memo[i-1][j-1];
                    //result = Math.max(result,memo[i][j]);
                }else{
                    memo[i][j] =Math.max(memo[i-1][j],memo[i][j-1]);
                }
            }
        }
        return memo[str1.length()-1][str2.length()-1];
    }

    public int longestCommonSubSequenceFirstIncrThenDec(String str1, String str2){

        return  0;
    }



    public static void main(String[] args) {
        System.out.println(
                new LCS().longestCommonSubSequence("ABCDEFGHXXXXXXXXS","XAXBYCXDWEPFQGRHS")
        );
        System.out.println(
                new LCS().longestCommonSubSequenceDP("ABCDEFGHXXXXXXXXS","XAXBYCXDWEPFQGRHS")
        );
        //new LCS().longestCommonSubSequence("ABCDEFGH","AXBYCXDWEPFQGRHS")
//indicator shows start/incr/decr
        System.out.println(
                //new LCS().longestCommonSubSequenceFirstIncrThenDec(new int[]{20,1,21,2,3,4,20,19,18,17,16},0 ,0, 0))
        );
    }
}
