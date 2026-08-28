class Solution {
public:
    string longestPalindrome(string s) {
        if (s.empty()) return "";
        
        int start = 0;
        int maxLength = 0;
        
        auto expandAroundCenter = [&](int left, int right) {
            while (left >= 0 && right < s.length() && s[left] == s[right]) {
                left--;
                right++;
            }
            // Length of palindrome found is (right - 1) - (left + 1) + 1 = right - left - 1
            int length = right - left - 1;
            if (length > maxLength) {
                maxLength = length;
                start = left + 1;
            }
        };

        for (int i = 0; i < s.length(); ++i) {
            expandAroundCenter(i, i);     // Odd-length palindromes
            expandAroundCenter(i, i + 1); // Even-length palindromes
        }

        return s.substr(start, maxLength);
    }
};