import java.util.*;

public class PGM152996 {

    public long solution(int[] weights) {
        Map<Double, Integer> map = new HashMap<>(); // key: weight, value: count

        Arrays.sort(weights);
        long answer = 0;
        for(double weight : weights) {
            double[] pairWeights = {weight, weight * 2.0 / 3.0, weight * 2.0 / 4.0, weight * 3.0 / 4.0};

            for(double pairWeight : pairWeights) {
                if(map.containsKey(pairWeight)) {
                    answer += map.get(pairWeight);
                }
            }

            map.put(weight, map.getOrDefault(weight, 0) + 1);
        }

        return answer;
    }

}
