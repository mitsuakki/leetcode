class Solution {
public:
    int romanToInt(string s) {
        unordered_map<char, int> roman = {
            {'I', 1},
            {'V', 5},
            {'X', 10},
            {'L', 50},
            {'C', 100},
            {'D', 500},
            {'M', 1000}
        };

        int result = 0;
        for (int i = s.length() - 1; i >= 0; i--)
        {
            int curr = roman[s[i]];
            if (i < s.length() - 1 && curr < roman[s[i + 1]])
            {
                result -= curr;
            } else {
                result += curr;
            }
        }

        return result;
    }
};
