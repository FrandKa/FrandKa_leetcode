package com.kakaowo.com.test_array;

import java.util.Arrays;

/**
 * @program: leetcode_part
 * @description:
 * @author: Mr.Ka
 * @create: 2023-11-10 11:00
 **/
public class T1427 {
    public String stringShift(String s, int[][] shift) {
        int num = 0;
        // 计算最后的操作, 如果是左移就是正数, 右移就是负数
        for(int[] arr: shift) {
            num += (arr[0] == 1 ? -arr[1] : arr[1]);
        }
        // 移动:
        // 这里需要注意的是需要对num进行取模, num 可能会 > len;
        int len = s.length();
        num %= len;
        if(num == 0) return s;
        if(num < 0) {
            // 右移
            return s.substring(len + num) + s.substring(0, len + num);
        } else {
            return s.substring(num) + s.substring(0, num);
        }
    }

    public static void main(String[] args) {
        String s = "abcde";
        int length = s.length();
        System.out.println("s.substring(length - 1) = " + s.substring(length - 1));
    }
}
