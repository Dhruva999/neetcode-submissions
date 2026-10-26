class Solution {
    public int lengthOfLongestSubstring(String s) {

        int len = s.length();
        HashSet<Character> hs = new HashSet<>();

        int l=0;
        int maxLen=0;

        for(int r=0;r<len;r++){

            char curr = s.charAt(r);
            while(hs.contains(curr)){
                hs.remove(s.charAt(l));
                l++;
            }

            hs.add(curr);
            maxLen = Math.max(maxLen, r-l+1);

        }
        return maxLen;
    }
}
