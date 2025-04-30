class Solution {
    public int findNumbers(int[] nums) {
        int counter = 0;
        for (int num : nums) {
            int numOfDigits = (int)Math.floor(Math.log10(num) + 1);
            
            if (numOfDigits % 2 == 0) {
                counter++;
            }
        }
        return counter;
    }
}
