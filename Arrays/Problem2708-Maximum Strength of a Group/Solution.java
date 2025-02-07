class Solution {
    /**
     * Time complexity = O(n)
     * Space complexity = O(1)
     * 
     * @param nums
     * @return
     */
    public long maxStrength(int[] nums) {
        long strength = 1;
        int leastNegativeValue = Integer.MIN_VALUE;
        int maxPositiveValue = Integer.MIN_VALUE;

        for (int num : nums) {
            /**
             * Case 1: num < 0, multiply it to strength.
             * Keep track of the least negative number just in case we need to revert that
             * muliplication at the end.
             * If there are at least 2 -1's, update max positive value to 1.
             */
            if (num < 0) {
                if (leastNegativeValue == -1 && num == -1) {
                    maxPositiveValue = 1;
                }
                leastNegativeValue = Math.max(leastNegativeValue, num);
                strength *= num;
            }
            /**
             * Case 2: num > 1, multiply it to strength.
             */
            else if (num > 1) {
                strength *= num;
            }
            /**
             * Case 3: num is either 0 or 1.
             */
            else {
                maxPositiveValue = Math.max(maxPositiveValue, num);
            }
        }

        if (strength < 0) {
            strength /= leastNegativeValue;
        }

        /**
         * If strength == 1, that means the group is still empty if students with
         * negative or -1/0/1 score are not picked.
         * If there are students with positive score, pick the one with max positive
         * score.
         * If not, pick the student with negative score.
         */
        if (strength == 1) {
            return Math.max(maxPositiveValue, leastNegativeValue);
        }

        return strength;
    }
}