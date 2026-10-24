class Solution {
    public int maxArea(int[] heights) {

        int n = heights.length;

        int maxWater = 0;
        int l =0;
        int r = n-1;

        while(l<=r){

            int currWater = (r-l)* Math.min(heights[r], heights[l]);
            maxWater = Math.max(maxWater, currWater);
            
            if(heights[l]<heights[r]){
                l++;
            }else{
                r--;
            }
        }

        return maxWater;
        
    }
}
