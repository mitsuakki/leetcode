import java.lang.StringBuilder;

class Solution {
    public String clearDigits(String s) {
        StringBuilder sb = new StringBuilder();

        for (char character : s.toCharArray()) {
            if (Character.isDigit(character)) {
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else {
                sb.append(character);
            }
        }

        return sb.toString();
    }
}
