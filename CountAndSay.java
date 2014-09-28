/*
Author: Xueyi Wang
Date: Jan 19 2014
Probelm Description:

The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.
*/

public class CountAndSay {
    public String countAndSay(int n) {
        char[] ori = {'1'};
        for(int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int start = 0;
            int len = ori.length;
            for(int ii = 1; ii <= len; ii++) {
                if(ii == len || ori[ii] != ori[start]) {
                    sb.append(ii-start);
                    sb.append(ori[start]);
                    start = ii;
                }
            }
            ori = sb.toString().toCharArray();
        }
        return new String(ori);
    }
}