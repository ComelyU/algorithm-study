import java.util.*;

public class PGM49993 {
    public int solution(String skill, String[] skill_trees) {
        HashSet<Character> skillHashSet = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        int answer = 0;

        // 선행 스킬에 있는 스킬들을 HashSet에 넣음
        for(char c : skill.toCharArray()) {
            skillHashSet.add(c);
        }

        // 스킬트리 검사
        for(String skillTree : skill_trees) {
            sb.setLength(0);

            // HashSet에 포함된 선행 스킬만 순서대로 추출
            for(char c : skillTree.toCharArray()) {
                if(skillHashSet.contains(c)) {
                    sb.append(c);
                }
            }

            // 추출된 스킬트리별 포함된 선행스킬이 skill(주어진 선행스킬트리)의 접두사인지 확인
            if(skill.startsWith(sb.toString())) {
                answer++;
            }
        }

         return answer;
    }

}
