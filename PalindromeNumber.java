/*
Author: Xueyi Wang
Date: Nov 2013
Problem Statement:
Determine whether an integer is a palindrome. Do this without extra space.
*/

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        int reverse = 0, tmp = x;
        
        while(tmp > 0){
            reverse = tmp%10 + reverse*10;
            tmp = tmp/10;
        }
        if(reverse == x)
            return true;
        else
            return false;
    }
}