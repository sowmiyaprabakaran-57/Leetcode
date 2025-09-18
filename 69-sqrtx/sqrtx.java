class Solution {
    public int mySqrt(int x) {
        if(x<2) return x;
        long ans=x;
        while(ans*ans>x)
        {
            ans=(ans+x/ans)/2;
        }
        return (int) ans;
    }
}