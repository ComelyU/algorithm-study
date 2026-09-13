public class LTC14 {
    // Horizontal Scan
    public String longestCommonPrefix(String[] strs) {
        // Problem Constraints guarantee 1 <= strs.length <= 200. But added a Guard Clause to safety.
        if (strs == null || strs.length == 0) {
            return "";
        }

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);

                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }

//    // Trie
//    public String longestCommonPrefix(String[] strs) {
//        // Guard Clause
//        if (strs == null || strs.length == 0) {
//            return "";
//        }
//
//        if (strs.length == 1) {
//            return strs[0];
//        }
//
//        TrieNode root = new TrieNode();
//
//        for (String str : strs) {
//            if (str.isEmpty()) {
//                return "";
//            }
//
//            root.insert(str);
//        }
//
//        StringBuilder prefix = new StringBuilder();
//        TrieNode current = root;
//
//        while (current.childCount == 1 && !current.isEndOfWord) {
//            for (int i = 0; i < 26; i++) {
//                if (current.children[i] != null) {
//                    prefix.append((char) (i + 'a'));
//                    current = current.children[i];
//                    break;
//                }
//            }
//        }
//
//        return prefix.toString();
//    }
//
//    private static class TrieNode {
//        private TrieNode[] children = new TrieNode[26]; // lowercase alphabets
//        private boolean isEndOfWord;
//        private int childCount = 0;
//
//        public void insert(String word) {
//            TrieNode current = this;
//
//            for (char c : word.toCharArray()) {
//                int index = c - 'a';
//
//                if (current.children[index] == null) {
//                    current.children[index] = new TrieNode();
//                    current.childCount++;
//                }
//
//                current = current.children[index];
//            }
//
//            current.isEndOfWord = true;
//        }
//    }
}
