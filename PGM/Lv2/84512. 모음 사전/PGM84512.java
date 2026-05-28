public class PGM84512 {
    private static final char[] vowels = {'A', 'E', 'I', 'O', 'U'};
    private static int dictionaryIndex = 0; // ArrayList로 사전 만들어서 확인하는 대신 단어 순서 체크
    private static boolean isFound = false; // 단어 사전에서 찾았는지 확인 플래그

    public int solution(String word) {
        StringBuilder sb = new StringBuilder();

        dfs(sb, word);

        return dictionaryIndex;
    }

    private static void dfs(StringBuilder nowWord, String targetWord) {
        if(isFound) {
            return;
        }

        if(nowWord.length() > 0) { // Java 15 이상이면 !nowWord.isEmpty()도 가능
            dictionaryIndex++; // 단어 생성하면 사전 인덱스 증가

            if(nowWord.toString().equals(targetWord)) {
                isFound = true;
                return;
            }
        }

        if(nowWord.length() == 5) { // 사전에 있는 단어의 길이는 최대 5
            return;
        }

        for(char vowel : vowels) {
            nowWord.append(vowel); // 가지치기
            dfs(nowWord, targetWord);

            if(isFound) {
                return;
            }

            nowWord.deleteCharAt(nowWord.length() - 1); // 백트래킹
        }
    }

}
