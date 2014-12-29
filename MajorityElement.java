 /*
Author: Xueyi Wang
Date: Dec 2014

Problem Description:
Given an array of size n, find the majority element. 
The majority element is the element that appears more than ⌊ n/2 ⌋ times.
You may assume that the array is non-empty and the majority element always exist in the array.
*/

public class MajorityElement {
    public int majorityElement(int[] num) {
        int count = 1, res = num[0];
        for(int i = 1; i < num.length; i++) {
            if(num[i] == res) {
                count ++;
            } else {
                count --;
                if(count == 0) {
                    res = num[i];
                    count = 1;
                }
            }    
        }        
        return res;
    } 
}
