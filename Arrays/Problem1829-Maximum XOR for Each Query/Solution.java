class Solution {
    /**
     * Time complexity = O(n)
     * Space complexity = O(1)
     * 
     * @param nums
     * @param maximumBit
     * @return
     */
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int[] answer = new int[nums.length];
        int n = nums.length;
        int xor = 0;
        /**
         * Mask is the maximum possible value for k.
         */
        int mask = (1 << maximumBit) - 1;

        for (int i = 0; i < n; i++) {
            xor = xor ^ nums[i];

            /**
             * End of a query.
             * Add mask - truncated xor to the answer array.
             */
            answer[n - 1 - i] = mask - (xor & mask);
        }

        return answer;
    }
}