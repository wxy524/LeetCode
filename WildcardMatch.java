/*
Author: Xueyi Wang
Date: August 05 2014

Problem Description:
Implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "*") → true
isMatch("aa", "a*") → true
isMatch("ab", "?*") → true
isMatch("aab", "c*a*b") → false
*/

public class WildcardMatch {
    public boolean isMatch(String s, String p) {
        if(s.equals(p)) {
            return true;
        }
        if(s == null || p == null) {
            return false;
        }
        int positionS = 0, positionP = 0, starP = -1, starS = -1;
        while(positionS < s.length()) {                        
            if((positionP < p.length()) && 
                (s.charAt(positionS) == p.charAt(positionP) || p.charAt(positionP) == '?')) {
                positionS++;
                positionP++;
            } else if (positionP < p.length() && p.charAt(positionP) == '*') {
                starP = positionP;              //record position of star
                starS = positionS;              //rescord position of s when star in p
                positionP++;
                continue;
            } else if (starP != -1) {           //not match, but there exists star 
                positionS = starS;              //go back to star
                positionP = starP + 1;          //go back to the element next to the star
                starS++;                        
            } else {
                return false;
            }
            
        }
        while(positionP < p.length() && p.charAt(positionP) == '*') {
            positionP++;
        }
        return (positionS == s.length() && positionP == p.length());
    }
}