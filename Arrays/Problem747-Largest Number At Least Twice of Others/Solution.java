class Solution {
    /**
     * Time complexity = O(n)
     * Space complexity = O(1)
     */
    public int dominantIndex(int[] nums) {
        int largest = 0, secondLargest = 0;
        int idx = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > largest) {
                secondLargest = largest;
                largest = nums[i];
                idx = i;
            }

            if (nums[i] != largest && nums[i] > secondLargest) {
                secondLargest = nums[i];
            }
        }

        return largest >= secondLargest * 2 ? idx : -1;
    }
}