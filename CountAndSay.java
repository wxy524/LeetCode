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
        if(n == 1) {
            return "1";
        }
        
        String res = "1";
        
        for(int i = 1; i < n; i++) {
            String temp = "";
            char cur = res.charAt(0);
            int size = res.length();
            int count = 1;
            for(int j = 1; j < size; j++) {
                if( res.charAt(j) == cur) {
                    count++;
                } else {
                    temp += count + "" + cur;
                    cur = res.charAt(j);
                    count = 1;
                }
            }
            temp += count + "" + cur;
            res = temp;
        }
        return res;
    }
}