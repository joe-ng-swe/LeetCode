class Solution {
    /**
     * Time complexity = O(n)
     * Space complexity = O(1)
     * @param nums
     * @return
     */
    public long findTheArrayConcVal(int[] nums) {
        int n = nums.length;
        long sum = 0;

        for (int first = 0; first < n; first++) {
            int last = n - 1 - first;

            /**
             * Case 1: first and last point to the same element.
             * Add the element to the sum and return.
             */
            if (first == last) {
                sum += nums[first];
                break;
            }

            /**
             * Case 2: first and last point to neighboring elements.
             * Add the concatenation value to the sum and return.
             */
            if (last == first + 1) {
                sum += concat(nums[first], nums[last]);
                break;
            }

            /**
             * Case 3: first and last are far apart.
             * Add the concatenation value and continue.
             */
            sum += concat(nums[first], nums[last]);
        }

        return sum;
    }

    private int concat(int a, int b) {
        return Integer.parseInt(
                Integer.toString(a) + Integer.toString(b));
    }
}