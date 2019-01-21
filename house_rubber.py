class Solution(object):
    def rob(self, nums):
        return max(reduce(lambda dp, i: [dp[1], dp[2], i + max(dp[0:2])], nums[2:], [0]+nums[:2]))
        