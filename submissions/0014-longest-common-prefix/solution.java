class Solution {
    private boolean isPrefix(String word, String pref) {
        int n = pref.length();
        if (n > word.length()) return false;

        return word.startsWith(pref);
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        // We assume the first string is a whole prefix
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            // Reduce length until strs[i] starts with a real prefix
            while (!isPrefix(strs[i], prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }

        return prefix;
    }
}
