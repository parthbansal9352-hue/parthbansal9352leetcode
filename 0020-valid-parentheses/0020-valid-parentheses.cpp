class Solution {
public:
    bool isValid(string s) {
        stack<char> st;
        for (char ch : s) {
            // Push open brackets onto the stack
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else {
                // If stack is empty before matching a close bracket, it's invalid
                if (st.empty()) return false;
                
                char top = st.top();
                st.pop();
                
                // Check if the top bracket matches the current closing bracket
                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }
        // Valid only if all opened brackets were properly matched and closed
        return st.empty();
    }
};