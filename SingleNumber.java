/*Given an array of integers, every element appears twice except for one. 
Find that single one.

Note:
Your algorithm should have a linear runtime complexity. 
Could you implement it without using extra memory?
*/

public class SingleNumber {
    public int singleNumber(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int len = A.length;
        int num = 0;
        for ( int i = 0; i < len; i++ ){
            num ^= A[i];   
        }
        return num;
    }
}