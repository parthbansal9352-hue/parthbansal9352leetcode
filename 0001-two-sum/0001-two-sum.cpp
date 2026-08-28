class Solution {
public:
    std::vector<int> twoSum(std::vector<int>& nums, int target) {
        // Map to store each number and its index: value -> index
        std::unordered_map<int, int> numMap;
        
        for (int i = 0; i < nums.size(); ++i) {
            int complement = target - nums[i];
            
            // Check if the complement already exists in our map
            if (numMap.find(complement) != numMap.end()) {
                return {numMap[complement], i};
            }
            
            // Otherwise, add the current number and index to the map
            numMap[nums[i]] = i;
        }
        
        return {};
    }
};