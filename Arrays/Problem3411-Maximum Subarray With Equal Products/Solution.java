class Solution {
    /**
     * Time complexity = O(n ^ 2)
     * Space complexity = O(1)
     * @param nums
     * @return
     */
    public int maxLength(int[] nums) {
        int max = 0;
        for (int start = 0; start < nums.length; start++) {
            int lcmValue = nums[start];
            int gcdValue = nums[start];
            int product = nums[start];

            for (int end = start; end < nums.length; end++) {
                if (end > start) {
                    lcmValue = lcm(lcmValue, nums[end]);
                    gcdValue = gcd(gcdValue, nums[end]);
                    product *= nums[end];
                }

                if (product == lcmValue * gcdValue) {
                    max = Math.max(max, end - start + 1);
                }
            }
        }

        return max;
    }

    private int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }

        return a;
    }
}