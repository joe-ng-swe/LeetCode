class Solution {
    /**
     * Let n be the number of elements in the Integer List,
     * m be the bit length of the largest integer element.
     * Time complexity = O(n * m)
     * Space complexity = O(1)
     * 
     * @param nums
     * @return
     */
    public int[] minBitwiseArray(List<Integer> nums) {
        /**
         * If ans is an odd number, ans + 1 will be an even number.
         * odd OR even will always be an odd number.
         * Similarly if ans is an even number, ans + 1 will be an odd number.
         * even OR odd will always be an odd number.
         * Therefore it is impossible to find an ans if num is an even number.
         * Add -1 to the array for this case.
         */
        int n = nums.size();
        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            int num = nums.get(i);
            if (num % 2 == 0) {
                // Even number
                answer[i] = -1;
            } else {
                /**
                 * Traverse from the LSB until a 0 bit is met.
                 * The leftmost 1's bit can be unset and that is the answer.
                 */
                int idx = 0;
                while ((num & (1 << (idx + 1))) > 0) {
                    // Loop until the first 0 bit is met.
                    idx++;
                }

                // Unset the leftmost consecutive 1's bit
                answer[i] = (num - (1 << idx));
            }
        }

        return answer;
    }
}