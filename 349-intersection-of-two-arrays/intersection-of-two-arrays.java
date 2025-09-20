class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1=new HashSet<>();
        for(int num:nums1) set1.add(num);
        
        Set<Integer> resSet=new HashSet<>();
        for(int num: nums2)
        {
            if(set1.contains(num))
            {
                resSet.add(num);
            }
        }
        int[] res=new int[resSet.size()];
        int i=0;
        for(int num: resSet)
        {
            res[i++]=num;
        }
        return res;
    }
}