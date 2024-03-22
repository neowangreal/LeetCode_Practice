class Solution {
    public int trap(int[] height) {
        var l = 0;
        var r = height.length - 1;
        var maxL = Integer.MIN_VALUE;
        var maxR = Integer.MIN_VALUE;
        var res = 0;

        while (l < r) {
            maxL = Math.max(maxL, height[l]);
            maxR = Math.max(maxR, height[r]);
            if (maxL > maxR) {
                res += maxR - height[r--];
            } else {
                res += maxL - height[l++];
            }
        }
        return res;
    }
}