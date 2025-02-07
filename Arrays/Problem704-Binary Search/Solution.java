class Solution {
    /**
     * Time complexity = O(logn)
     * Space complexity = O(1)
     * 
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int n = nums.length;
        int start = 0, end = n - 1;

        while (end >= start) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                // target is found, return
                return mid;
            }

            if (nums[mid] > target) {
                // num is larger than target, move end to the left
                end = mid - 1;
            } else {
                // num is smaller than target, move start to the right
                start = mid + 1;
            }
        }

        return -1;
    }
}