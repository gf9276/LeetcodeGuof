package com.guof.prefix_product_and_prefix_xor.the_product_of_the_last_k_numbers;

import java.util.ArrayList;
import java.util.List;

class ProductOfNumbers {
    // 积有一个问题，那就是0会被截断，所以我们可以分成很多个区域，以0为末尾

    List<List<Integer>> prefix;

    public ProductOfNumbers() {
        prefix = new ArrayList<>();
        prefix.add(new ArrayList<>());
    }

    public void add(int num) {
        List<Integer> curList = prefix.get(prefix.size() - 1);
        if (num == 0) {
            curList.add(0); // 封存
            prefix.add(new ArrayList<>()); // 新创建一个区块
        } else {
            if (curList.isEmpty()) {
                curList.add(num);
            } else {
                Integer lastNum = curList.get(curList.size() - 1);
                curList.add(lastNum * num);
            }
        }
    }

    public int getProduct(int k) {
        List<Integer> curList = prefix.get(prefix.size() - 1);
        if (k > curList.size()) {
            return 0;
        } else {
            if (k == curList.size()) {
                return curList.get(curList.size() - 1);
            } else {
                return curList.get(curList.size() - 1) / curList.get(curList.size() - 1 - k);
            }
        }
    }
}