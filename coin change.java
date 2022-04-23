class Solution 
{
    int[][] dp;
    public int coinChange(int[] coins, int amount) 
    {
        int n = coins.length;
        dp = new int[n][amount+1];
        // Arrays.sort(coins,Collections.reverseOrder());
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<=amount;j++)
            {
                dp[i][j] = -1;
            }
        }
        int ans = findans(coins,amount,0);
        return (ans>=100000000)?-1:ans;
    }
    public int findans(int[] a,int amt,int idx)
    {
        if(amt==0)
        {
            return 0;
        }
        if(idx==a.length-1)
        {
            if(amt%a[idx]==0)
            {
                return amt/a[idx];
            }
            return 100000000;
        }
        if(dp[idx][amt]!=-1)
        {
            return dp[idx][amt];
        }
        int notpick = findans(a,amt,idx+1);
        int pick = 100000000;
        if(amt>=a[idx])
        {
            pick = 1+findans(a,amt-a[idx],idx);
        }
        return dp[idx][amt] = Math.min(pick,notpick);
    }
}
