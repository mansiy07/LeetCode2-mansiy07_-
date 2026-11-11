// class Solution {
//     public static int fxn(int nums[],int target,int dp[]){
//         if(target==0) return 1;
//         if(dp[target]!=-1) return dp[target];
//         int ans=0;
//         for(int i=0;i<nums.length;i++){
//             if(nums[i]<=target){
//                 ans=ans+fxn(nums,target-nums[i],dp);
//             }
//         }
//         return dp[target]=ans;
//     }
//     public int combinationSum4(int[] nums, int target) {
//          int n=nums.length;
//          int dp[]=new int[target+1];
//          for(int i=0;i<=n;i++){
//             Arrays.fill(dp,-1);
//          }
//          return fxn(nums,target,dp);
//     }
// }


// Tabulation 


class Solution {
    public int combinationSum4(int[] nums, int target) {
        int dp[]=new int[target+1];
        dp[0]=1;
        for(int i=1;i<=target;i++){
            for(int j=0;j<nums.length;j++){
                if(nums[j]<=i){
                    dp[i]+=dp[i-nums[j]];
                }
            }
        }
        return dp[target];
    }
}


