// class Solution {
//     int dp[];
//     public int fib(int n) {
//         dp=new int[n+1];
//         Arrays.fill(dp,-1);
//         return solve(n);
//     }
//     public int solve(int n){
//         if(n<=1) return n;
//         if(dp[n]!=-1) return dp[n];
//         return dp[n]=solve(n-1)+solve(n-2);
//     }
// }

class Solution{
    public int fib(int n){
        if(n<=1){
            return n;
        }
        return fib(n-1)+fib(n-2);
    }
}