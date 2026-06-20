public class PGM12951 {
    public String solution(String s) {
       char[] charArray = s.toLowerCase().toCharArray(); // s의 길이는 1이상 200 이하

       charArray[0] = Character.toUpperCase(charArray[0]);

       int sLength = s.length(); // s의 길이는 charArray의 길이와 같음
       for(int i = 1; i < sLength; i++) {
           if(charArray[i - 1] == ' ') {
               charArray[i] = Character.toUpperCase(charArray[i]);
           }
       }

       return new String(charArray);
    }

//    public String solution(String s) {
//        StringBuilder jadenCaseString = new StringBuilder();
//
//        s = s.toLowerCase();
//
//        jadenCaseString.append(Character.toUpperCase(s.charAt(0)));
//
//        int sLength = s.length();
//        for(int i = 1; i < sLength; i++) {
//            char c = s.charAt(i);
//
//            if(s.charAt(i - 1) == ' ') {
//                jadenCaseString.append(Character.toUpperCase(c));
//            } else {
//                jadenCaseString.append(c);
//            }
//        }
//
//        return jadenCaseString.toString();
//    }
}
