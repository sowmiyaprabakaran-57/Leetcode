class Solution {
    public int maxArea(int[] height) {
        int left=0;
        int right=height.length-1;
        int maxarea=0;
        while(left<right)
        {
            int width=right-left;
            int heights=Math.min(height[left], height[right]);
            int water=width*heights;
            maxarea=Math.max(maxarea,water);
            if(height[left]<height[right])
            {
                left++;
            }
            else
            {
                right--;
            }

        }
        return maxarea;
    }
}