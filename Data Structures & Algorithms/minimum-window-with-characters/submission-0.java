class Solution {
    public String minWindow(String s, String t) {

        if (s.length() < t.length()) {
            return "";
        }

        // Store the frequency of each character in t
        Map<Character, Integer> map = new HashMap<>();

        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;

        int required = t.length();
        int minLength = Integer.MAX_VALUE;
        int startIndex = 0;

        while (right < s.length()) {

            char rightChar = s.charAt(right);

            // If this character is required, reduce its frequency
            if (map.containsKey(rightChar)) {

                if (map.get(rightChar) > 0) {
                    required--;
                }

                map.put(rightChar, map.get(rightChar) - 1);
            }

            // All characters of t are present in the window
            while (required == 0) {

                // Update minimum window
                int windowLength = right - left + 1;

                if (windowLength < minLength) {
                    minLength = windowLength;
                    startIndex = left;
                }

                char leftChar = s.charAt(left);

                // Remove left character from window
                if (map.containsKey(leftChar)) {

                    map.put(leftChar, map.get(leftChar) + 1);

                    // If frequency becomes positive, a required
                    // character is now missing
                    if (map.get(leftChar) > 0) {
                        required++;
                    }
                }

                left++;
            }

            right++;
        }

        if (minLength == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(startIndex, startIndex + minLength);
        
    }
}
