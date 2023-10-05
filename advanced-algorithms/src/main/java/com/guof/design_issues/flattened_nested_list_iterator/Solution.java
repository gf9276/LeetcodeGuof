package com.guof.design_issues.flattened_nested_list_iterator;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 * <p>
 * // @return true if this NestedInteger holds a single integer, rather than a nested list.
 * public boolean isInteger();
 * <p>
 * // @return the single integer that this NestedInteger holds, if it holds a single integer
 * // Return null if this NestedInteger holds a nested list
 * public Integer getInteger();
 * <p>
 * // @return the nested list that this NestedInteger holds, if it holds a nested list
 * // Return empty list if this NestedInteger holds a single integer
 * public List<NestedInteger> getList();
 * }
 * <p>
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */

//public class NestedIterator implements Iterator<Integer> {
//    Queue<NestedInteger> nestedQueue;
//    Queue<Integer> integerQueue;
//
//    public NestedIterator(List<NestedInteger> nestedList) {
//        nestedQueue = new LinkedList<>(nestedList);
//        integerQueue = new LinkedList<>();
//
//        while (!nestedQueue.isEmpty()) {
//            NestedInteger curNestedInteger = nestedQueue.poll();
//            if (!curNestedInteger.isInteger()) {
//                // 如果是一个列表，直接迭代
//                NestedIterator nestedIterator = new NestedIterator(curNestedInteger.getList());
//                integerQueue.addAll(nestedIterator.integerQueue);
//            } else {
//                // 如果是个数字，直接加入就好了
//                integerQueue.add(curNestedInteger.getInteger());
//            }
//        }
//    }
//
//    @Override
//    public Integer next() {
//        return integerQueue.poll();
//    }
//
//    @Override
//    public boolean hasNext() {
//        return !integerQueue.isEmpty();
//    }
//}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */