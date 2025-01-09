/**
 * Split into two functions by anticipating unit tests 
 * on both functions in a professional context
 */
class Solution {
    private boolean isPrefix(String word, String pref) {
        int n = pref.length();
        if (n > word.length()) return false;

        // could have use "startWith()"
        return word.substring(0, n).equals(pref);
    }
    
    public int prefixCount(String[] words, String pref) {
        int count = 0;
        for (int i = 0; i < words.length; ++i) {
            if (isPrefix(words[i], pref)) {
                count++;
            }
        }
        return count;
    }
}
