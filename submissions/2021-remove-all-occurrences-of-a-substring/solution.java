class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder stack = new StringBuilder(s);

        int index;
        while ((index = stack.indexOf(part)) != -1) {
            stack.delete(index, index + part.length());
        }

        return stack.toString();
    }
}
