/*
Author: Xueyi Wang
Date: Dec 2013
Problem Statement:

Implement strStr().

Returns a pointer to the first occurrence of needle in haystack, 
or null if needle is not part of haystack.
*/

public class StrStr {
    public String strStr(String haystack, String needle) {
        assert(haystack!=null && needle!=null);
        if(needle.length() == 0) {
            return haystack;
        }

        for(int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            if(haystack.charAt(i) == needle.charAt(0)) {
                int j = i;
                while(j - i < needle.length()) {
                    if(haystack.charAt(j) == needle.charAt(j-i)) {
                        j++;
                    } else {
                        break;
                    }
                }
                if(j == needle.length() + i) {
                    return haystack.substring(i);
                }
            }
        }
        return null;      
    }
}
