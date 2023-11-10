package com.kakaowo.com.test_array.leetcode_161;

/**
 * 给定两个字符串 s 和 t ，如果它们的编辑距离为 1 ，则返回 true ，否则返回 false 。
 *
 * 字符串 s 和字符串 t 之间满足编辑距离等于 1 有三种可能的情形：
 *
 * 往 s 中插入 恰好一个 字符得到 t
 * 从 s 中删除 恰好一个 字符得到 t
 * 在 s 中用 一个不同的字符 替换 恰好一个 字符得到 t
 *
 * 示例 1：
 *
 * 输入: s = "ab", t = "acb"
 * 输出: true
 * 解释: 可以将 'c' 插入字符串 s 来得到 t。
 */
class Solution {
    public boolean isOneEditDistance(String s, String t) {
        // 基础判断: 只有在长度相同, 或者相差1的时候才有可能成立, 不然直接false;
        int lengthS = s.length();
        int lengthT = t.length();
        if(lengthT > lengthS) return isOneEditDistance(t, s);
        int n = lengthS - lengthT;
        if(n > 2) return false;
        for(int i = 0; i < lengthT; i++) {
            if(s.charAt(i) != t.charAt(i)) {
                if(n == 0) {
                    return s.substring(i + 1).equals(t.substring(i + 1));
                }
                return s.substring(i + 1).equals(t.substring(i));
            }
        }
        return n != 0;
    }
}