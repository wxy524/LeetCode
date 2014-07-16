/*
Author: Xueyi Wang
Date: Nov 2013
Problem Statment:

Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
*/

public class NextPermutation {
    public void nextPermutation(int[] num) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        if (num.length <= 1) return;
        
        int tmp = 0, key = 0, position = 0, max = num[num.length-1];
        
        for (int i = num.length - 1; i > 0; i--) {
            key = num[i - 1];
            position = i;
            if (key >= max) {
                max = key;
                while (key >= num[position] && position < num.length) {
                    num[position-1] = num[position];
                    num[position++] = key;
                    if (position == num.length) break;
                }
            }else {
                for (int j = position; j < num.length; j++) {
                    if (num[j] > key) {
                        num[position-1] = num[j];
                        num[j] = key;
                        break;
                    }
                }
                return;
            } 
        }
        return;
    }
}