class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if(s1.length()>s2.length()) return false;

        int[] s1Freq = new int[26];
        int[] windowFreq = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            s1Freq[s1.charAt(i) - 'a']++;
            windowFreq[s2.charAt(i) - 'a']++;
        }

        if (matches(s1Freq, windowFreq)) {
            return true;
        }

        for (int right = s1.length(); right < s2.length(); right++) {

            windowFreq[s2.charAt(right) - 'a']++;

            int left = right - s1.length();
            windowFreq[s2.charAt(left) - 'a']--;

            if (matches(s1Freq, windowFreq)) {
                return true;
            }
        }

        return false;
    }

    public static boolean matches(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
}
