class Solution {
    /**
     * Time complexity = O(n)
     * Space complexity = O(1)
     */
    public int maximizeSum(int[] nums, int k) {
        // max sum = (max int in array) * (k) + (0 + 1 + 2 + ... + (k - 1))
        // max sum = (max int in array) * (k) + ((k - 1) * k / 2)
        int max = 0;
        for (int i : nums) {
            if (i > max) {
                max = i;
            }
        }

        return max * k + sum(k);
    }

    private int sum(int count) {
        return (count - 1) * count / 2;
    }
}