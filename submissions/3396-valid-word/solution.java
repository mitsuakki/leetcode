class Solution {
    public boolean isValid(String word) {
       if (word == null || word.length() < 3) {
            return false;
        }

        if (!word.matches("[a-zA-Z0-9]+")) {
            return false;
        }

        boolean hasVowel = false;
        boolean hasConsonant = false;

        String vowel = "aeiou";
        for (char c : word.toCharArray()) {
            if (Character.isLetter(c)) {
                char lower = Character.toLowerCase(c);
                if (vowel.indexOf(lower) >= 0) {
                    hasVowel = true;
                } else {
                    hasConsonant = true;
                }
            }
        }

        return hasVowel && hasConsonant;
    }
}
