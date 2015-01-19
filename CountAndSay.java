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
import java.lang.*;

public class CountAndSay {
    public String countAndSay(int n) {
        String res = "1";
        for(int i = 1; i < n; i++) {
            int start = 0;
            StringBuilder sb = new StringBuilder();
            for(int strIdx = 1; strIdx <= res.length(); strIdx++) {
                if(strIdx == res.length() || res.charAt(strIdx) != res.charAt(start)){                
                    sb.append(strIdx - start);
                    sb.append(res.charAt(start));
                    start = strIdx;
                } 
            }
            res = sb.toString();
        }
        return res;    
    }
}
