import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class JUNGOL1050 {

    private static final int CARD_COUNT = 52;

    private static final String SUIT_ORDER = "CDSH";
    private static final String RANK_ORDER = "23456789TJQKA";

    private static final String OUTPUT_PLAYER_POSITIONS = "SWNE";
    private static final int PLAYER_COUNT = 4;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        List<PriorityQueue<Card>> hands = new ArrayList<>();
        for (int i = 0; i < PLAYER_COUNT; i++) {
            hands.add(new PriorityQueue<>(BRIDGE_CARD_COMPARATOR));
        }

        char dealer = br.readLine().charAt(0);
        int dealerIndex = OUTPUT_PLAYER_POSITIONS.indexOf(dealer);
        int starterIndex = (dealerIndex + 1) % PLAYER_COUNT;
        String cards = br.readLine() + br.readLine();

        for (int i = 0; i < CARD_COUNT; i++) {
            int currentPlayerIndex = (starterIndex + i) % PLAYER_COUNT;
            char suit = cards.charAt(i * 2);
            char rank = cards.charAt(i * 2 + 1);

            hands.get(currentPlayerIndex).offer(new Card(suit, rank));
        }

        for (int i = 0; i < PLAYER_COUNT; i++) {
            sb.append(OUTPUT_PLAYER_POSITIONS.charAt(i)).append(':');

            PriorityQueue<Card> hand = hands.get(i);
            while (!hand.isEmpty()) {
                Card card = hand.poll();
                sb.append(' ').append(card.suit).append(card.rank);
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    private static class Card {
        final char suit;
        final char rank;

        Card(char suit, char rank) {
            this.suit = suit;
            this.rank = rank;
        }
    }

    private static final Comparator<Card> BRIDGE_CARD_COMPARATOR = (c1, c2) -> {
        int suitCompare = Integer.compare(SUIT_ORDER.indexOf(c1.suit), SUIT_ORDER.indexOf(c2.suit));
        if (suitCompare != 0) {
            return suitCompare;
        }
        return Integer.compare(RANK_ORDER.indexOf(c1.rank), RANK_ORDER.indexOf(c2.rank));
    };

}
