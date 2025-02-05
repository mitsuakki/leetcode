class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        
        int first = -1, second = -1;
        int diffCount = 0;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diffCount++;
                if (diffCount > 2) return false; // more than two diff → one swap will not be enough
                
                // allocation of indices
                if (first == -1) first = i;
                else second = i;
            }
        }

        if (diffCount == 0) return true; // same stirng
        if (diffCount != 2) return false; // only one diff → useless swap

        return s1.charAt(first) == s2.charAt(second) && s1.charAt(second) == s2.charAt(first);
    }
}

