package com.guof.next_beautiful_number;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    static Integer[] save;

    static {
        List<Integer> saveList = new ArrayList<>();
        String[] strings = new String[]{"1", "22", "333", "4444", "55555", "666666"};
        dfs(Arrays.asList(strings), new ArrayList<>(), saveList, "");
        Collections.sort(saveList);
        save = saveList.toArray(new Integer[0]);
    }

    public int nextBeautifulNumber(int n) {
        // 其实就是 1 22 333 4444 55555 66666 的随机组合罢了，没几个数字的
        int left = 0;
        int right = save.length;

        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (save[mid] <= n) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return save[left];
    }

    public static void dfs(List<String> strings, List<String> badStrings, List<Integer> save, String curStr) {
        if (!curStr.isEmpty()) {
            if (curStr.length() > 7) {
                return;
            } else {
                if (badStrings.isEmpty()) {
                    save.add(Integer.parseInt(curStr));
                }
            }
        }
        for (int i = 0; i < strings.size(); i++) {
            String string = strings.get(i);
            List<String> tmp = new ArrayList<>(strings);
            tmp.remove(string);

            if (string.length() > 1) {
                List<String> tmp2 = new ArrayList<>(badStrings);
                tmp2.add(string.substring(1));
                dfs(tmp, tmp2, save, curStr + string.charAt(0));
            } else {
                dfs(tmp, badStrings, save, curStr + string.charAt(0));
            }
        }

        for (int i = 0; i < badStrings.size(); i++) {
            String string = badStrings.get(i);
            List<String> tmp2 = new ArrayList<>(badStrings);
            if (string.length() == 1) {
                tmp2.remove(string);
            } else {
                tmp2.remove(string);
                tmp2.add(i, string.substring(1));
            }
            dfs(strings, tmp2, save, curStr + string.charAt(0));
        }
    }
}