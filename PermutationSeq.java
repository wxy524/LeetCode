/*
Author: Xueyi Wang
Date: Nov 2013
Problem Statement:

The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.
*/

import java.util.*;

public class PermutationSeq {
    public String getPermutation(int n, int k) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int curNumIdx = 0, numPostion = 0;
        List<Integer> num = new ArrayList<Integer>();
        StringBuffer res = new StringBuffer();
        
        if(n < 2) {
            return Integer.toString(n);
        }
        
        k = k - 1;
        for(int i = 0; i < n; i++) {
            num.add(i+1);
        }
        int[] fac = getFac(n);
        
        for(int i = 0; i < n; i++) {
            curNumIdx = k / fac[n - i - 1];
            res.append(num.get(curNumIdx));
            num.remove(curNumIdx);
            k = k % fac[n - i - 1];
        }
        return res.toString();
    }
    
    private int[] getFac(int n) {
        int[] res = new int[n];
        res[0] = 1;
        for(int i = 1; i < n; i++) {
            res[i] = res[i-1] * i;
        }
        return res;
    }
}