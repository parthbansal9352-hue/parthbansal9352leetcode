import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        // Step 1: Array ko sort karo
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
            // Duplicates for the first element skip karo
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            // Agar pehla number hi 0 se bada hai, toh triplet sum 0 nahi ho sakta
            if (nums[i] > 0) {
                break;
            }
            
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    // Left pointer ke duplicates skip karo
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // Right pointer ke duplicates skip karo
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++; // Sum badhane ke liye left ko aage badao
                } else {
                    right--; // Sum ghatane ke liye right ko peeche laao
                }
            }
        }
        
        return result;
    }
}
    