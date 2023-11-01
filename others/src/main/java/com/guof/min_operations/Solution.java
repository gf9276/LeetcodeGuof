package com.guof.min_operations;


class Solution {
    public int minOperations(int[] nums) {
        // 其实是通过一种方法，使得nums中的数字都变成一样的
        // 那么 只要出现了一个1，剩下的都是时间问题，剩下的变size-1次就行，如何最快的找到第一个1？

        // 数组里面有1，直接就能传导了
        int oneNbr = 0;
        for (int num : nums) {
            oneNbr += num == 1 ? 1 : 0;
        }
        if (oneNbr > 0) {
            return nums.length - oneNbr;
        }

        // 数组里面没有1，得想办法找到一个1
        int output = dfs(0, nums);
        return output == Integer.MAX_VALUE ? -1 : output + nums.length - 1;
    }


    public int dfs(int curStep, int[] nums) {
        int output = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                continue;
            }
            int gcd = getGcd(nums[i], nums[i + 1]);
            if (gcd == 1) {
                return curStep + 1;
            }
            int tmp;
            // 两种选择，变i或i+1
            if (gcd != nums[i]) {
                // 向左传导
                int left = i;
                while (left >= 0 && nums[left] == nums[i]) {
                    left--;
                }
                tmp = nums[i];
                for (int j = left + 1; j <= i; j++) {
                    nums[j] = gcd;
                }
                output = Math.min(output, dfs(curStep + i - left, nums));
                for (int j = left + 1; j <= i; j++) {
                    nums[j] = tmp;
                }
            }
            if (gcd != nums[i + 1]) {
                // 向右传导
                int right = i + 1;
                while (right < nums.length && nums[right] == nums[i + 1]) {
                    right++;
                }
                tmp = nums[i + 1];
                for (int j = i + 1; j < right; j++) {
                    nums[j] = gcd;
                }
                output = Math.min(output, dfs(curStep + right - (i + 1), nums));
                for (int j = i + 1; j < right; j++) {
                    nums[j] = tmp;
                }
            }
        }
        return output;
    }

    public int getGcd(int num1, int num2) {
        // 获取公约数嘛
        int max = Math.max(num1, num2);
        int min = Math.min(num1, num2);
        int output = 1;

        for (int i = 1; i * i <= min; i++) {
            if (min % i == 0) {
                if (max % (min / i) == 0) {
                    output = min / i;
                    break;
                } else if (max % i == 0) {
                    output = Math.max(output, i);
                }
            }
        }

        return output;
    }
}