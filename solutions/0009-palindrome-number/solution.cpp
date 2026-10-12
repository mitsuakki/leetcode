class Solution {
public:
    bool isPalindrome(int x) {
        string strx = std::to_string(x);
        string result = "";

        for (int i = strx.size() - 1; i >= 0; i--)
            result += strx[i];

        return strx == result;
    }
};
