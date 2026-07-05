public class LTC9 {
    public boolean isPalindrome(int x) {
        if(x < 0) { // negative number is not palindrome
            return false;
        }
        if(x != 0 && x % 10 == 0) { // divisible by 10(= end digit is 0) is not palindrome exclude 0
            return false;
        }

        int reversedHalf = 0;
        while(x > reversedHalf) { // loop until half of the number is reversed
            reversedHalf = (reversedHalf * 10) + (x % 10);
            x /= 10;
        }

        // if x's digits are even, compare with reverseHalf
        // if x's digits are odd, compare with reversedHalf / 10 to remove the middle digit(number)
        return x == reversedHalf || x == reversedHalf / 10;
    }
}
