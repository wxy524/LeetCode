/*
Author: Xueyi Wang
Date: OCT 2013
Problem Statement:
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
*/

public class Stock {
    public int maxProfit(int[] prices) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int len = prices.length, profit = 0, maxprofit = 0, min = 0;
    
        if (len < 2) {
            maxprofit = 0;
        }else {
            for (int i = 0; i< len; i++) {
                if (prices[min] > prices[i]) {
                    min = i;
                }
                profit = prices[i] - prices[min];
                if (profit > maxprofit) {
                    maxprofit = profit;
                }
            }
        }   
        return maxprofit;
    }
}