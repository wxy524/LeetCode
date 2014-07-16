/*
Author:Xueyi Wang
Date: One day in 2013...

Say you have an array for which the ith element is the price of a given 
stock on day i.

Design an algorithm to find the maximum profit. You may complete as many 
transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
*/

public class StockII {
    public int maxProfit(int[] prices) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int len = prices.length, profit = 0, diff = 0;
    
        if (len < 2) {
            profit = 0;
        }else {
            for (int i = 0; i < len-1; i++) {
                diff = prices[i+1] - prices[i];
                if(diff > 0) profit = profit + diff;
            }
        }
        return profit;
    }
}