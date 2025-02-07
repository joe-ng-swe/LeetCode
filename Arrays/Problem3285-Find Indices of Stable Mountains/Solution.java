class Solution {
    /**
     * Time complexity = O(n)
     * Space complexity = O(1)
     * 
     * @param height
     * @param threshold
     * @return
     */
    public List<Integer> stableMountains(int[] height, int threshold) {
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i < height.length; i++) {
            if (height[i - 1] > threshold) {
                // This mountain is stable, add its index to the solution arraylist
                list.add(i);
            }
        }

        return list;
    }
}