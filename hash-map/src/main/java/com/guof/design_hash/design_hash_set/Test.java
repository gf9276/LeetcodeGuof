package com.guof.design_hash.design_hash_set;

/**
 * ClassName: Test
 * Package: com.feng.arrays_and_strings.letter_heterotopic_word_grouping
 * Description:
 *
 * @Author guof
 * @Create 2023/4/4 19:53
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        MyHashSet solo = new MyHashSet();
        solo.add(1);
        solo.add(2);
        System.out.println(solo.contains(1));
        System.out.println(solo.contains(3));
        solo.add(2);
        System.out.println(solo.contains(2));
        solo.remove(2);
        System.out.println(solo.contains(2));
        System.out.println();

    }
}
