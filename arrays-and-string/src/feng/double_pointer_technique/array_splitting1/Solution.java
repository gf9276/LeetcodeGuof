package feng.double_pointer_technique.array_splitting1;

import java.util.Arrays;

/**
 * ClassName: Solution
 * Package: com.feng.applying_basic_algorithmic_ideas.merge
 * Description: 中心回文，简单粗暴~
 *
 * @Author guof
 * @Create 2023/5/15 21:32
 * @Version 1.0
 */
class Solution {
    public int arrayPairSum(int[] nums) {
        int sum = 0;
        Arrays.sort(nums);

        for (int i = nums.length - 2; i >= 0; i -= 2) {
            sum += nums[i];
        }

        return sum;
    }
}