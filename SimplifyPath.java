/*
Author: Xueyi Wang
Date: Dec 2013
Problem Statement:

Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
*/

public class SimplifyPath {
    public String simplifyPath(String path) {
    
        String[] paths = path.split("/");
        Stack<String> stk = new Stack<String>();
        
        for(String s : paths) {
            if(s.equals(".") || s.length() == 0) {
                continue;
            }
            if(s.equals("..")) {
                if(!stk.isEmpty()) {
                    stk.pop();
                }
            } else {
                stk.push(s);
            }
        }
        
        StringBuilder res = new StringBuilder();
        if(stk.isEmpty()) {
            return "/";
        }
        
        while(!stk.isEmpty()) {
            String folder = stk.pop();
            res.insert(0, folder);
            res.insert(0, "/");
        }
        
        return res.toString();
    }
}