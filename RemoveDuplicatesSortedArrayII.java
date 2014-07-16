/*
Author: Xueyi Wang
Date: Nov 2013
Problem Statement:
Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array A = [1,1,1,2,2,3],

Your function should return length = 5, and A is now [1,1,2,2,3].
*/

public class RemoveDuplicatesSortedArrayII {
    public int removeDuplicates(int[] A) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        int cnt = 1, pre = 0, len = A.length;
        for(int i=pre+1; i<len; i++){
            if(A[pre] == A[i]){
                cnt++;
                if(cnt > 2){
                    if(i == A.length){
                        len--;
                    }else{
                        int index = i;
                        for(int j=i+1; j<A.length; j++){
                            A[index++]=A[j];
                        }
                        len--;
                    }
                    i--;
                }
                
            }else{
                cnt = 1;
                pre = i;
            }    
        }
        return len;
    }
}