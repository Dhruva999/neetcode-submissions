class Solution {
    public int longestConsecutive(int[] nums) {

        HashSet<Integer> hs = new HashSet<>();

        for(int num: nums) hs.add(num);

        int longest = 0;

        for(int num: hs){

            if(!hs.contains(num-1)){
                int currNum = num;
                int count = 1;
            

                while(hs.contains(currNum +1)){
                    currNum++;
                    count++;
                }

                longest = Math.max(longest, count);
            }
        }

        return longest;
        
    }
}
