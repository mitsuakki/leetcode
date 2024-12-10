class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        
        int lenN = needle.length();
        for (int i = 0; i <= haystack.length() - lenN; i++) {
            if(haystack.substring(i, i + lenN).equals(needle))
                return i;
        }
        
        return -1;
    }
}
