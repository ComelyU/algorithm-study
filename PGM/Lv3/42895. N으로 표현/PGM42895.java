import java.util.*;

public class PGM42895 {
    private static final int MAX_N_COUNT = 8;

    public int solution(int N, int number) {
        if(N == number) {
            return 1;
        }

        List<HashSet<Integer>> operationResultDP = new ArrayList<>(MAX_N_COUNT + 1);
        for(int i = 0; i <= MAX_N_COUNT; i++) {
            operationResultDP.add(new HashSet<>());
        }

        int baseNumber = N;
        operationResultDP.get(1).add(baseNumber);

        for(int i = 2; i <= MAX_N_COUNT; i++) {
            HashSet<Integer> currentResultSet = operationResultDP.get(i);

            baseNumber = baseNumber * 10 + N;
            currentResultSet.add(baseNumber);

            for(int j = 1; j <= i / 2; j++) {
                HashSet<Integer> setA = operationResultDP.get(j);
                HashSet<Integer> setB = operationResultDP.get(i - j);

                for(int a : setA) {
                    for(int b : setB) {
                        currentResultSet.add(a + b);
                        currentResultSet.add(a - b);
                        currentResultSet.add(a * b);
                        if(b != 0) {
                            currentResultSet.add(a / b);
                        }

                        currentResultSet.add(b - a);
                        if(a != 0) {
                            currentResultSet.add(b / a);
                        }
                    }
                }
            }

            if(currentResultSet.contains(number)) {
                return i;
            }
        }

        return -1;
    }

//    public int solution(int N, int number) {
//        if(N == number) {
//            return 1;
//        }
//
//        HashSet<Integer>[] operationResultDP = new HashSet[MAX_N_COUNT + 1];
//
//        int baseNumber = 0;
//        for(int i = 1; i <= MAX_N_COUNT; i++) {
//            operationResultDP[i] = new HashSet<>();
//
//            baseNumber = baseNumber * 10 + N;
//
//            operationResultDP[i].add(baseNumber); // N, NN, NNN, NNNN, ... 기본 형태 추가
//        }
//
//        // DP
//        for(int i = 1; i <= MAX_N_COUNT; i++) {
//            for(int j = 1; j <= i / 2; j++) {
//                for(int a : operationResultDP[j]) {
//                    for(int b : operationResultDP[i - j]) {
//                        // 순방향
//                        operationResultDP[i].add(a + b);
//                        operationResultDP[i].add(a - b);
//                        operationResultDP[i].add(a * b);
//                        if(b != 0) {
//                            operationResultDP[i].add(a / b);
//                        }
//
//                        // 역방향 (j < i 가 아닌 j <= i / 2 조건으로 돌기 때문에 추가)
//                        operationResultDP[i].add(b - a);
//                        if(a != 0) {
//                            operationResultDP[i].add(b / a);
//                        }
//                    }
//                }
//            }
//
//            if(operationResultDP[i].contains(number)) {
//                return i;
//            }
//        }
//
//        return -1;
//    }

}
