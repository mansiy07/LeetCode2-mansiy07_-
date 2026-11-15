class Solution {
    public int minSumOfLengths(int[] arr,int target) {
        int n=arr.length;
        int[] left=new int[n];
        int minLen=Integer.MAX_VALUE;
        int ans=Integer.MAX_VALUE;
        int sum=0,l=0;
        for(int r=0;r<n;r++){
            sum+=arr[r];
            while(sum>target){
                sum-=arr[l++];
            }
            if(sum==target){
                int len=r-l+1;
                if(l>0&&left[l-1]!=Integer.MAX_VALUE){
                    ans=Math.min(ans,len+left[l-1]);
                }
                minLen=Math.min(minLen,len);
            }
            left[r]=minLen;
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}
