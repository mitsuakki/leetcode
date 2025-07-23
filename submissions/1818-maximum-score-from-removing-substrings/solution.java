class Result {
    String remaining;
    int points;

    Result(String remaining, int points) {
        this.remaining = remaining;
        this.points = points;
    }
}

class Solution {
    public int maximumGain(String s, int x, int y) {
        int total = 0;
        if (x >= y) {
            Result first = removePattern(s, 'a', 'b', x);
            Result second = removePattern(first.remaining, 'b', 'a', y);
            total = first.points + second.points;
        } else {
            Result first = removePattern(s, 'b', 'a', y);
            Result second = removePattern(first.remaining, 'a', 'b', x);
            total = first.points + second.points;
        }
        return total;
    }

    private Result removePattern(String s, char first, char second, int points) {
        StringBuilder stack = new StringBuilder();
        int localPoints = 0;

        for (char c : s.toCharArray()) {
            int len = stack.length();
            if (len > 0 && stack.charAt(len - 1) == first && c == second) {
                stack.deleteCharAt(len - 1);
                localPoints += points;
            } else {
                stack.append(c);
            }
        }

        return new Result(stack.toString(), localPoints);
    }
}
