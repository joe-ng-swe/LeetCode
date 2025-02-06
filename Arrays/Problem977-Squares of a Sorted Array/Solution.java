class Solution {
    /**
     * Time complexity = O(n)
     * Space complexity = O(n)
     */
    public int[] sortedSquares(int[] nums) {
        int[] sorted = new int[nums.length];
        int start = 0, end = nums.length - 1;
        int idx = end;
        /**
         * Avoid unexpected infinite loop.
         */
        final int MAX_ATTEMPTS = 10000;
        int count = 0;

        while (idx >= 0 && count++ < MAX_ATTEMPTS) {
            if (Math.abs(nums[start]) > Math.abs(nums[end])) {
                sorted[idx--] = nums[start] * nums[start];
                start++;
            } else {
                sorted[idx--] = nums[end] * nums[end];
                end--;
            }
        }

        return sorted;
    }
}