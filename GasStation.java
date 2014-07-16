/*
Author: Xueyi Wang
Date: Nov 2013
Problem Statement:

There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

Note:
The solution is guaranteed to be unique.
*/

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        int step = 0, rest = 0, index = -1, totgas = 0, totcost = 0;
        int[] station = new int[gas.length];
        
        if (totgas < totcost) return -1;
        
        for (int i = 0; i < gas.length; i++) {
            if (gas[i] >= cost[i]) {
                index = i;
                for (int j = 0; j < gas.length; j++) {
                    if (index + j < gas.length) {
                        rest = rest + gas[index + j] - cost[index + j];
                    }else{
                        rest = rest + gas[index + j - gas.length] - cost[index + j - gas.length];
                    } 
                    if (rest < 0) {
                        index = -1;
                        rest = 0;
                        break;
                    }
                }
                if (index != -1) { return index; }
            }
        }  
        
        return index;
    }
}
