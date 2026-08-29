import java.util.ArrayDeque;
import java.util.Queue;

public class PGM43163 {

    public int solution(String begin, String target, String[] words) {
        boolean flag = false;

        for (String word : words) {
            if (word.equals(target)) {
                flag = true;
                break;
            }
        }

        if (!flag) {
            return 0;
        }

        Node result = bfs(begin, target, words);

        return result == null ? 0 : result.count;
    }

    private static Node bfs(String begin, String target, String[] words) {
        Queue<Node> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[words.length];

        queue.offer(new Node(begin, 0));

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.word.equals(target)) {
                return current;
            }

            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && isChangeable(current.word, words[i])) {
                    visited[i] = true;
                    queue.offer(new Node(words[i], current.count + 1));
                }
            }
        }

        return null;
    }

    private static boolean isChangeable(String before, String after) {
        // 모든 단어의 길이가 같음
        int diff = 0;
        for (int i = 0; i < before.length(); i++) {
            if (before.charAt(i) != after.charAt(i)) {
                diff++;
            }
        }

        return diff == 1;
    }

    public static class Node {
        String word; // 단어
        int count; // 변환 횟수

        public Node(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }

}
