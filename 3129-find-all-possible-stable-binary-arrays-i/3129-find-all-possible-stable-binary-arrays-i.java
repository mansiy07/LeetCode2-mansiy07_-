class Solution {
    int mod=1000000007;
    int dp[][][];
    int solve(int zero,int one,int last,int limit){
        if(zero==0&&one==0) return 1;
        if(dp[zero][one][last]!=-1) return dp[zero][one][last];
        int ans=0;
        if(last==0){
            for(int k=1;k<=Math.min(one,limit);k++){
                ans=(ans+solve(zero,one-k,1,limit))%mod;
            }
        }else{
            for(int k=1;k<=Math.min(zero,limit);k++){
                ans=(ans+solve(zero-k,one,0,limit))%mod;
            }
        }
        return dp[zero][one][last]=ans;
    }
    public int numberOfStableArrays(int zero,int one,int limit){
        dp=new int[zero+1][one+1][2];
        for(int i=0;i<=zero;i++){
            for(int j=0;j<=one;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        int ans=0;
        for(int k=1;k<=Math.min(zero,limit);k++){
            ans=(ans+solve(zero-k,one,0,limit))%mod;
        }
        for(int k=1;k<=Math.min(one,limit);k++){
            ans=(ans+solve(zero,one-k,1,limit))%mod;
        }
        return ans;
    }
}
