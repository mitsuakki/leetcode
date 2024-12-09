import java.lang.StringBuilder;

class Solution {
    // 1 <= s.length <= 2 * 10⁵
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();

        StringBuilder fixedS   = new StringBuilder(); 
        StringBuilder reversed = new StringBuilder();

        for(int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);

            if (Character.isLetterOrDigit(c))
                fixedS.append(c);
        }

        for (int j = fixedS.length() - 1; j >= 0; j--) {
            char c = fixedS.charAt(j);
            reversed.append(c);
        }

        return reversed.toString().equals(fixedS.toString());
    }
}
