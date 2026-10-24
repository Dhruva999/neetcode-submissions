class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> mp = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) ->mp.get(a) - mp.get(b));

        for (int num : mp.keySet()) {
            pq.offer(num);
            if (pq.size() > k) {
                pq.poll(); // Remove element with minimum frequency
            }
        }

        int[] result = new int[k];
        int i = 0;

        while (!pq.isEmpty()) {
        result[i++] = pq.poll();
        }
        
        return result;
    }
}
