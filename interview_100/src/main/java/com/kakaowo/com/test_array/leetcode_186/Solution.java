package com.kakaowo.com.test_array.leetcode_186;

/**
 * 186. 反转字符串中的单词 II
 * 中等
 * 相关标签
 * 相关企业
 * 给你一个字符数组 s ，反转其中 单词 的顺序。
 *
 * 单词 的定义为：单词是一个由非空格字符组成的序列。s 中的单词将会由单个空格分隔。
 *
 * 必须设计并实现 原地 解法来解决此问题，即不分配额外的空间。
 *
 */
 /**
 * 示例 1：
 *
 * 输入：s = ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
 * 输出：["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
 * 示例 2：
 *
 * 输入：s = ["a"]
 * 输出：["a"]
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 105
 * s[i] 可以是一个英文字母（大写或小写）、数字、或是空格 ' ' 。
 * s 中至少存在一个单词
 * s 不含前导或尾随空格
 * 题目数据保证：s 中的每个单词都由单个空格分隔
 */

import java.util.Arrays;

/**
 * 分析: 这个题目首先不可以使用额外的内存空间;
 * 所以可以想到的很好的解决办法就是双指针;
 * 但是双指针的话: ??
 * 初步想法, 先将数组整个反转在反转单词
 */
class Solution {
    public void reverseWords(char[] s) {
        reverse(s, 0, s.length - 1);
        int start = 0;
        for (int i = 0; i < s.length; i++) {
            if(s[i] == ' ') {
                reverse(s, start, i - 1);
                start = i + 1;
            }
        }
        reverse(s, start, s.length - 1);
    }

    private void reverse(char[] s, int left, int right) {
        // 先数组逆置
        while(left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            ++left;
            --right;
        }
    }
}