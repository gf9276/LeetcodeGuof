package feng.brief_summary.yang_hui_triangle2;

import java.util.ArrayList;
import java.util.List;

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
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) {
            List<Integer> aa = new ArrayList<>();
            aa.add(1);
            return aa;

        }

        List<Integer> lastLst = new ArrayList<>();
        List<Integer> curLst = new ArrayList<>();

        for (int i = 1; i <= rowIndex; i++) {
            curLst.add(1);
            for (int j = 1; j < i; j++) {
                curLst.add(lastLst.get(j) + lastLst.get(j - 1));
            }
            curLst.add(1);
            lastLst = new ArrayList<>(curLst);
            curLst.clear();

        }

        return lastLst;
    }
}