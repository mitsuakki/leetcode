import java.util.HashMap;

class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> syms = new HashMap<>();
        
        syms.put('I', 1);
        syms.put('V', 5);
        syms.put('X', 10);
        syms.put('L', 50);
        syms.put('C', 100);
        syms.put('D', 500);
        syms.put('M', 1000);

        int result = 0;
        int len = s.length();

        for (int i = 0; i < len; i++) {
            int current = syms.get(s.charAt(i));

            if (i < len - 1 && current < syms.get(s.charAt(i + 1))) {
                result -= current;
            } else {
                result += current;
            }
        }

        return result;
    }
}
