class Solution {
public:
    int numJewelsInStones(string jewels, string stones) {
        bool isjewels[128] = {false};
        
        // Mark characters that are jewels
        for (char ch : jewels) {
            isjewels[ch] = true;
        }
        
        int count = 0;
        // Count stones that are jewels
        for (char ch : stones) {
            if (isjewels[ch]) {
                count++;
            }
        }
        
        return count;
    }
};