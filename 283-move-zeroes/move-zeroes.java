class Solution {
    public void moveZeroes(int[] nums) {
        int nonzero=0;
        for(int i=0; i<nums.length;i++)
        {
            if(nums[i]!=0)
            {
                int temp=nums[nonzero];
                nums[nonzero]=nums[i];
                nums[i]=temp;
                nonzero++;
            }
        }
    }
}