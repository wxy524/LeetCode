/*
Author: Xueyi Wang

Problem Description:
Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

For example,
Given:
s1 = "aabcc",
s2 = "dbbca",

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.
*/

 public class InterLeaving {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length(), len2 = s2.length(), len3 = s3.length();
        if(len1 + len2 != len3) {
            return false;
        }
        boolean[][] isValid = new boolean[len1+1][len2+1];
        isValid[0][0] = true;
        
        for(int row = 1; row <= len1; row++) {
            if(s1.charAt(row-1) != s3.charAt(row-1)) {
                break;
            } 
            isValid[row][0] = true;
        }
        
        for(int col = 1; col <= len2; col++) {
            if(s2.charAt(col-1) != s3.charAt(col-1)) {
                break;
            }
            isValid[0][col] = true;
        }
        
        for(int row = 1; row <= len1; row++) {
            for(int col = 1; col <= len2; col++) {
                if(s1.charAt(row-1) == s3.charAt(row+col-1) && isValid[row-1][col]) {
                    isValid[row][col] = true;
                }
                if(s2.charAt(col-1) == s3.charAt(row+col-1) && isValid[row][col-1]) {
                    isValid[row][col] = true;
                }
            }
        }
        
        return isValid[len1][len2];
    }
}
