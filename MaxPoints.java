import java.util.HashMap;
import java.util.*;

public class MaxPoints {
    public int maxPoints(Point[] points) {
        int res = 0;
        if(points.length == 0) {
            return res;
        }

        HashMap<Double, Integer> map = new HashMap<Double, Integer>();
        
        for(int i = 0; i < points.length; i++) {
            int dup = 0;
            map.clear();
            Point o = points[i];
            for(Point p : points) {
                if(p.x != o.x || p.y != o.y) {
                    double slop = o.x == p.x ? Double.MAX_VALUE : 1.0 * (o.y - p.y) / (o.x - p.x);
                    if(map.containsKey(slop)){
                        map.put(slop, map.get(slop)+1);
                    } else {
                        map.put(slop, 1);
                    }
                } else {
                    dup++;

                }
            }
            if(map.isEmpty()){
                return dup;
            }
            for(Double key : map.keySet()) {
                if(res < map.get(key) + dup) {
                    res = map.get(key) + dup;
                }
            }
        }
        return res;        
    }  
}