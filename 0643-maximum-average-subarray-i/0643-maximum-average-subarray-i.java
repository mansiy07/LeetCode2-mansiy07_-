
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum=0;
        for(int i=0;i<k;i++){
            sum+=nums[i];
        }
        int maxSum=sum;
        int i=0,j=k;
        while(j<nums.length){
            sum+=nums[j];
            sum-=nums[i];
            maxSum=Math.max(maxSum,sum);
            i++;
            j++;
        }
        return (double)maxSum/k;
    }
}
