class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int increasing = 1, decreasing = 1;
        int globalMax = 1;

        for(int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] > nums[i]) { // Striclty increasing
                increasing++;
                decreasing = 1;

            } else if (nums[i + 1] < nums[i]) { // Strictly decreasing
                decreasing++;
                increasing = 1;

            } else {
                increasing = 1;
                decreasing = 1;
            }

            globalMax = Math.max(globalMax, Math.max(increasing, decreasing));
        }

        return globalMax;
    }
}
