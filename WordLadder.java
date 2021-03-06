/*
Name:Xueyi Wang
Date:Sep 15 2014

Porblem Description:

Given two words (start and end), and a dictionary, find the length of shortest 
transformation sequence from start to end, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
For example,

Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
*/

import java.util;

public class WordLadder {
    public int ladderLength(String start, String end, HashSet<String> dict) {
        if(dict == null || dict.size() == 0) {
            return 0;
        }
        
        LinkedList<String> wordQ = new LinkedList<String>();
        LinkedList<Integer> disQ = new LinkedList<Integer>();
        wordQ.add(start);
        disQ.add(1);
        
        while(!wordQ.isEmpty()) {
            String word = wordQ.pop();
            Integer dis = disQ.pop();
            if(word.equals(end)){
                return dis;
            }
            for(int i = 0; i < word.length(); i++) {
                char[] temp = word.toCharArray();
                for(char c = 'a'; c < 'z'; c++) {
                    temp[i] = c;
                    String tmp = new String(temp);
                    if(dict.contains(tmp)) {
                        wordQ.add(tmp);
                        disQ.add(dis+1);
                        dict.remove(tmp);
                    }
                }
            }
        }
        return 0;
    }
}