/*
Author: Xueyi Wang
Date: Sep 10 2014

Problem Description:
Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
*/

import java.util.*;

public class MaxPoints {
    public int maxPoints(Point[] points) {
        if(points == null || points.length == 0) {
            return 0;
        }
        HashMap<Double, Integer> hm = new HashMap<Double, Integer>();
        int max = 0;
        for(int i = 0; i < points.length; i++) {
            hm.clear();
            int dup = 1;
            hm.put(Double.MAX_VALUE,0);
            double x1 = points[i].x;
            double y1 = points[i].y;
            for(int j = i+1; j < points.length; j++) {
                double x2 = points[j].x;
                double y2 = points[j].y;
                if(x1 == x2 && y1 == y2) {
                    dup++;
                } else if (x1 == x2) {
                    hm.put(Double.MAX_VALUE, hm.get(Double.MAX_VALUE)+1);   
                } else {
                    double slope = y1 == y2 ? 0.0 : 1.0 * (y2-y1)/(x2-x1);
                    if(hm.containsKey(slope)) {
                        hm.put(slope, hm.get(slope)+1);

                    } else {
                        hm.put(slope, 1);
                    }
                }
            }
            for(Integer numSlope: hm.values()) {
                if(numSlope > max - dup) {
                    max = numSlope + dup;
                }    
            }
        }
        return max;
    }
}