class Solution {
public:
    vector<vector<int>> generate(int numRows) {
        vector<vector<int>> triangle;

        // Fills the first one
        for (int i = 0; i < numRows; i++)
            triangle.push_back(vector<int>(i + 1, 1));

        // 2 because 0 and 1 is only filled with one
        for (int i = 2; i < numRows; i++)
        {
            for (int j = 1; j < triangle[i].size() - 1; j++)
            {
                triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
            }
        }

        return triangle;
    }
};
