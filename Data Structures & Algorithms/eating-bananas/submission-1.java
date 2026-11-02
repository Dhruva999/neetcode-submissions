class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int n = piles.length;

        int high = 0;
        int low = 1;

        for(int pile: piles){
            high = Math.max(pile, high);
        }

        int ans = high;

        while(low<=high){

            int mid = low + ((high-low)/2);

            if(canEatBananas(mid, piles, h)){

                ans = Math.min(ans, mid);
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }

    public boolean canEatBananas(int rate, int[] piles, int h){

        int n = piles.length;
        long cnt = 0;

        for(int i=0;i<n;i++){

            cnt += (piles[i] + rate - 1)/ rate;
        }

        if(cnt<=h) return true;
        return false;
    }
}
