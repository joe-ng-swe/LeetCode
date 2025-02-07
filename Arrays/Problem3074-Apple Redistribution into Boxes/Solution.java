class Solution {
    /**
     * Time complexity = O(n + mlogm)
     * Space complexity = O(1)
     * 
     * @param apple
     * @param capacity
     * @return
     */
    public int minimumBoxes(int[] apple, int[] capacity) {
        int apples = 0;
        int boxesNeeded = 0;

        // Calculate the total number of apples
        for (int count : apple) {
            apples += count;
        }

        // Sort the boxes by capacity
        Arrays.sort(capacity);

        // Select largest boxes first to minimize the number of boxes required
        for (int i = capacity.length - 1; i >= 0; i--) {
            apples -= capacity[i];
            boxesNeeded++;

            // if all apples are sorted into boxes, return
            if (apples <= 0) {
                break;
            }
        }

        return boxesNeeded;
    }
}