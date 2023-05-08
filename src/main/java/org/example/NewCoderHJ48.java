package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//https://www.nowcoder.com/practice/f96cd47e812842269058d483a11ced4f?tpId=37&tqId=21271&ru=/exam/oj
public class NewCoderHJ48 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] argArrs = in.nextLine().split(" ");
        //先处理输入，各就各位
        //表示总节点数
        int maxcCount = Integer.parseInt(argArrs[0]);
        //表示头结点的值为几
        int headValue = Integer.parseInt(argArrs[1]);
        //要删除哪个
        String deleteValue = argArrs[argArrs.length - 1];

        List<String> retList = new ArrayList<>();

        //开始构建链表,默认保证是合法的，就不做校验了
        for (int i = 2; i < argArrs.length - 1; i += 2) {
            if (!retList.contains(argArrs[i + 1])) {
                retList.add(argArrs[i + 1]);
                retList.add(argArrs[i]);
            } else {
                int index = retList.indexOf(argArrs[i + 1]);
                retList.add(index + 1, argArrs[i]);
            }
        }

        retList.remove(retList.indexOf(deleteValue));

        for (int j = 0; j < retList.size(); j++) {
            System.out.print(retList.get(j) + " ");
        }

    }
}
