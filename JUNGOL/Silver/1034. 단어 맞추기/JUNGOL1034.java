import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JUNGOL1034 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();
        char[] wordArray = word.toCharArray();

        System.out.println(findNextPermutation(wordArray) ? String.valueOf(wordArray) : word); // new String(wordArray)
    }

    private static boolean findNextPermutation(char[] chars) {
        int i = chars.length - 1;

        // 뒤에서부터 탐색. 사전 순으로 앞 글자가 더 작아지는 첫 지점(i-1) 찾기
        while (i > 0 && chars[i - 1] >= chars[i]) {
            i--;
        }

        // 순열의 마지막
        if (i <= 0) {
            return false;
        }

        // 다시 뒤에서부터 탐색. i - 1 위치의 문자보다 큰 첫 번째 문자의 위치 찾기
        int j = chars.length - 1;
        while (chars[j] <= chars[i - 1]) {
            j--;
        }

        // 두 위치의 문자 바꾸기
        swap(chars, i - 1, j);

        // i 위치부터 오름차순 정렬 (= Reverse.(이미 내림차순으로 정렬된 상태이기 때문))
        int k = chars.length - 1;
        while (i < k) {
            swap(chars, i++, k--);
        }

        return true;
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
