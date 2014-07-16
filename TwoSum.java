/*
Author: Xueyi Wang
Date: July 13 2014

Problem Description:
Given an array of integers, find two numbers such that they add up to a specific 
target number.

The function twoSum should return indices of the two numbers such that they add 
up to the target, where index1 must be less than index2. Please note that your 
returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
*/

import java.util.Arrays;

public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int first = 0, second = numbers.length-1;
        int[] sorted = new int[numbers.length];
        int[] res = new int[2];

        for(int i = 0; i < numbers.length; i++) {
            sorted[i] = numbers[i];
        }
        Arrays.sort(sorted);

        while(first < second) {
            if(sorted[first] + sorted[second] < target) {
                first++;
            } else if(sorted[first] + sorted[second] > target) {
                second--;           
            } else {
                break;
            }
        }
    
        for(int i = 0; i < numbers.length; i++) {
            if(numbers[i] == sorted[first] || numbers[i] == sorted[second]) {
                if(res[0] == 0) {
                    res[0] = i + 1;
                } else {
                    res[1] = i + 1;
                }
            }
        }
        return res;
    }
}