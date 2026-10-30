class Solution {
public:
    int lengthOfLastWord(std::string s) {
        int k = 0;
        int i = s.length() - 1;

        while (i >= 0 && std::isspace(static_cast<unsigned char>(s[i]))) {
            i--;
        }

        while (i >= 0 && !std::isspace(static_cast<unsigned char>(s[i]))) {
            k++;
            i--;
        }

        return k;
    }
};
