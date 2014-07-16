import java.util.Arrays;

public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int first = 0, second = numbers.length-1;
        int[] sorted = new int[numbers.length];
        int[] res = new int[2];

        for(int i = 0; i < numbers.length; i++) {
            sorted[i] = numbers[i];
        }
        Arrays.sort(sorted);

        while(first < second) {
            if(sorted[first] + sorted[second] < target) {
                first++;
            } else if(sorted[first] + sorted[second] > target) {
                second--;           
            } else {
                break;
            }
        }
    
        for(int i = 0; i < numbers.length; i++) {
            if(numbers[i] == sorted[first] || numbers[i] == sorted[second]) {
                if(res[0] == 0) {
                    res[0] = i + 1;
                } else {
                    res[1] = i + 1;
                }
            }
        }
        return res;
    }
}