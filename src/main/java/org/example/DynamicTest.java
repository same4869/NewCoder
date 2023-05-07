package org.example;

import java.util.Arrays;

//https://www.bilibili.com/video/BV1AB4y1w7eT/?spm_id_from=333.337.search-card.all.click&vd_source=5760561a0d07cb49cae66a4ba3433932
//找到一个数组中连续子序列的最大和
public class DynamicTest {
    public static int[] setupData() {
        int[] ret = {3, -4, 2, -1, 2, 6, -5, 4};
//        int[] ret = {8, -2, 5, 4};
        return ret;
    }

    //暴力求解法
    public static int solution1(int[] arr) {
        int maxSum = arr[0];
        for (int i = 0; i < arr.length; i++) {
            int curMax = 0;
            for (int j = i; j < arr.length; j++) {
                curMax += arr[j];
                maxSum = Math.max(maxSum, curMax);
            }
        }
        return maxSum;
    }


    public static void main(String[] args) {
        System.out.println(solution1(setupData()));
    }
}
