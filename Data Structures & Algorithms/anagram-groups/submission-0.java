class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> mp = new HashMap<>();

        for (String str : strs) {

            // Convert string to character array
            char[] chars = str.toCharArray();

            // Sort characters
            Arrays.sort(chars);

            // Sorted string becomes the key
            String key = new String(chars);

            // Add original string to the corresponding group
            mp.putIfAbsent(key, new ArrayList<>());
            mp.get(key).add(str);
        }

        return new ArrayList<>(mp.values());
        
    }
}
