class Solution {
public:
    int equalPairs(vector<vector<int>>& grid) {
        int n = grid.size();
        int count = 0;
        map<vector<int>, int> mp;
        
        //1
        for(int row = 0; row < n; row++) {
            mp[grid[row]]++;
        }
        
        //2
        for(int c = 0; c < n; c++) {
            vector<int> temp;
            for(int r = 0; r<n; r++) {
                temp.push_back(grid[r][c]);
            }
            count += mp[temp];
        }
        return count;
    }
};