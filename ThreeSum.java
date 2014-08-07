/*
Author: Xueyi Wang
Date: August 6 2014

Problem Description:
Given an array S of n integers, are there elements a, b, c in S 
such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
*/

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] num) {
                List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(num.length < 3) {
            return res;
        }
        Arrays.sort(num);
        int start = 0, end = num.length-1;
        for(int i = 0; i < num.length-2; i++) {
            if(i == 0 || num[i-1] < num[i]) {
                start = i + 1;
                end = num.length - 1;
                while(start < end) {
                    if(num[start] + num[end] == -num[i]) {
                        ArrayList<Integer> temp = new ArrayList<Integer>();
                        temp.add(num[i]);
                        temp.add(num[start]);
                        temp.add(num[end]);
                        res.add(temp);
                        start++;
                        end--;
                        /*Avoid duplicate*/
                        while(start < end && num[start] == num[start-1]) {
                            start ++;
                        }
                        while(end > start && num[end] == num[end+1]) {
                            end--;
                        }
                        /*The current result less than 0*/
                    } else if(num[start] + num[end] < -num[i]) {
                        start++;                //increase result
                        /*The current result greater than 0*/
                    } else {            
                        end--;                  //decrease result;
                    }
                }
            }
        }
        return res;
    }
}