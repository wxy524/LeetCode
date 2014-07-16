/*
Author: Xueyi Wang
Date: Jan 13, 2014
Problem Description:

Given an array of integers, every element appears three times except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
*/

import java.util.Map;
import java.util.HashMap;

public class SingleNumberII {
    public int singleNumber(int[] A) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < A.length; i++) {
            if (map.containsKey(A[i])) {
                map.put(A[i], map.get(A[i])+1);
            } else {
                map.put(A[i], 1);
            }
        }
        
        for(int key : map.keySet()) {
            if(map.get(key) != 3) {
                return key;
            }
        }
        return 0;
    }
}