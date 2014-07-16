/*
Author: Xueyi Wang
Date: June 2014
Proble Description:

There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?*/



public class Candy {
    public int candy(int[] ratings) {
        int len = ratings.length;
        if(len == 0) {
            return 0;
        }

        int[] left = new int[len];
        int[] right = new int[len];
        int res = 0;

        left[0] = 1;
        right[len-1] = 1;

        for(int i = 1; i < len; i++) {
            if(ratings[i] > ratings[i-1]) {
                left[i] = left[i-1] + 1;
            } else {
                left[i] = 1;
            }
        }

        for(int i = len-2; i >= 0; i--) {
            if(ratings[i] > ratings[i+1]) {
                right[i] = right[i+1] + 1;
            } else {
                right[i] = 1;
            }
        }

        for (int i = 0; i < len; i++ ) {
            res += Math.max(left[i], right[i]);
        }
        return res;
    }
}