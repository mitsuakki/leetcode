class Solution {
public:
    int singleNumber(vector<int>& nums) {
        int unique = 0;
        int n = nums.size();

        if (n == 1)
            return nums[0];

        for (int i = 0; i < n; i++)
            unique ^= nums[i];

        return unique;
    }
};
