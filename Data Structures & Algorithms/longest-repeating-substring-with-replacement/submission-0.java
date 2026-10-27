class Solution {
    public int characterReplacement(String s, int k) {

        int n = s.length();
        int[] freq = new int[26];
        int l = 0;
        int maxLen = 0;
        int maxFreq = 0;
        for(int r = 0;r<n;r++){

            char curr = s.charAt(r);
            freq[curr - 'A']++;

            maxFreq = Math.max(maxFreq, freq[curr - 'A']);

            while((r-l+1)-maxFreq > k){
                freq[s.charAt(l) - 'A']--;
                l++;
            }

            maxLen = Math.max(maxLen, r - l + 1);
        }

        return maxLen;
        
    }
}
