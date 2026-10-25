class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        int n = nums.size();
        int k = 1;

        for (int i = 1; i < n; i++)
        {
            int prev = nums[i - 1];
            if (prev != nums[i])
            {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }
};
