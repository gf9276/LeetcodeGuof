package com.guof.min_mutation;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public int minMutation(String startGene, String endGene, String[] bank) {
        List<String> bankList = new ArrayList<>(Arrays.asList(bank)); // 方便删除哦
        int output = dfs(startGene, endGene, bankList, 0);
        return output == Integer.MAX_VALUE ? -1 : output;
    }


    public int dfs(String curGene, String endGene, List<String> bankList, int curNbr) {
        if (curGene.equals(endGene)) {
            return curNbr;
        }

        int output = Integer.MAX_VALUE;
        // 既然curGene和endGene还有差距，那就去bankList里面找
        for (int i = 0; i < bankList.size(); i++) {
            String curBank = bankList.get(i);
            if (oneDist(curBank, curGene)) {
                bankList.remove(curBank);
                output = Math.min(output, dfs(curBank, endGene, bankList, curNbr + 1));
                bankList.add(i, curBank);
            }
        }

        return output;
    }


    public boolean oneDist(String s1, String s2) {
        // 判断欧式距离是不是只有1
        int nbr = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (nbr == 1) {
                    return false;
                }
                nbr++;
            }
        }
        return nbr == 1;
    }
}