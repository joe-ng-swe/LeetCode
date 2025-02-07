class Solution {
    /**
     * Time complexity = O(1)
     * Space complexity = O(1)
     * 
     * @param nums
     * @return
     */
    public String triangleType(int[] nums) {
        return getTriangleType(nums[0], nums[1], nums[2]);
    }

    private boolean canFormTriangle(int a, int b, int c) {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }

    private String getTriangleType(int a, int b, int c) {
        if (!canFormTriangle(a, b, c)) {
            return "none";
        }

        if (a == b && a == c) {
            return "equilateral";
        }

        if (a == b || a == c || b == c) {
            return "isosceles";
        }

        return "scalene";
    }
}