/*
Date: Sep 20
Author: Xueyi Wang

Problem Description:
Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
*/

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
*/

import.java.util.*;

public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) {
            return null;
        }
        Deque<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
        HashMap<Integer, UndirectedGraphNode> hm = new HashMap<Integer, UndirectedGraphNode>();
        
        q.push(node);
        hm.put(node.label, new UndirectedGraphNode(node.label));
        while(!q.isEmpty()) {
            UndirectedGraphNode origin = q.poll();
            UndirectedGraphNode copy = hm.get(origin.label);
            for(UndirectedGraphNode n: origin.neighbors) {
                if(!hm.containsKey(n.label)){
                    UndirectedGraphNode temp = new UndirectedGraphNode(n.label);
                    hm.put(n.label, temp);
                    q.push(n);
                }
                copy.neighbors.add(hm.get(n.label));
            }
        }
        return hm.get(node.label);
    }
}