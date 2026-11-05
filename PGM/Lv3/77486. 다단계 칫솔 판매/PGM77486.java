import java.util.*;

public class PGM77486 {

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String, String> parentMap = new HashMap<>(); // 자식, 부모 (판매원, 추천인)
        for (int i = 0; i < enroll.length; i++) {
            parentMap.put(enroll[i], referral[i]);
        }

        Map<String, Integer> profitMap = new HashMap<>(); // 판매원, 수익
        for (String name : enroll) {
            profitMap.put(name, 0);
        }

        final int PROFIT_PRICE_PER_ONE_TOOTHBRUSH = 100;
        final int PROFIT_PERCENT_FOR_PARENT = 10;
        final String ROOT = "-"; // 민호 제외한 최상위

        for (int i = 0; i < seller.length; i++) {
            String name = seller[i];
            int profit = amount[i] * PROFIT_PRICE_PER_ONE_TOOTHBRUSH;

            while (profit > 0 && !name.equals(ROOT)) {
                int profitToParent = profit / PROFIT_PERCENT_FOR_PARENT;
                int profitToChild = profit - profitToParent;

                profitMap.put(name, profitMap.get(name) + profitToChild);

                profit = profitToParent;
                name = parentMap.get(name);
            }
        }

        int[] profitByEnrolledSellers = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++) {
            profitByEnrolledSellers[i] = profitMap.get(enroll[i]);
        }

        return profitByEnrolledSellers;
    }

}
