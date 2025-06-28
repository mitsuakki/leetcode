class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int[][] indexedNums = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            indexedNums[i][0] = nums[i];  // value
            indexedNums[i][1] = i;        // index
        }

        Arrays.sort(indexedNums, (a, b) -> Integer.compare(b[0], a[0]));

        int[][] topK = Arrays.copyOfRange(indexedNums, 0, k);
        Arrays.sort(topK, Comparator.comparingInt(a -> a[1]));

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = topK[i][0];
        }

        return result;
    }
}
