package org.example;

//大数相乘，也就是字符串相乘
//https://leetcode.cn/problems/multiply-strings/solution/you-hua-ban-shu-shi-da-bai-994-by-breezean/
public class BigNumMulti {
    public static String solution(String a, String b) {
        if (a.isEmpty() || b.isEmpty()) return "";
        if (a.equals("0") || b.equals("0")) return "0";

        for (int i = a.length() - 1; i >= 0; i--) {
            StringBuilder sb = new StringBuilder(); //记录结果
            int flag1 = 0;//乘法进位记录
            for (int j = b.length() - 1; j >= 0; j--) {
                int temp = Integer.parseInt(String.valueOf(a.charAt(i))) * Integer.parseInt(String.valueOf(b.charAt(j)));
                sb.append(temp % 10 + flag1);
                flag1 = temp / 10;
            }
            if (flag1 != 0 && i == 0) {
                sb.append(flag1);
            }
        }


        return ""; //sb.reverse().toString();
    }

    //https://www.nowcoder.com/discuss/397711821816213504
    public static String strPlus(String a, String b) {
        StringBuilder sb = new StringBuilder(); //记录结果
        int flag = 0;//进位记录
        int plusCount = Math.min(a.length(), b.length());

        for (int i = 1; i <= plusCount; i++) {
            int temp = Integer.parseInt(String.valueOf(a.charAt(a.length() - i))) + Integer.parseInt(String.valueOf(b.charAt(b.length() - i)));
            sb.append(temp % 10 + flag);
            flag = temp / 10;
        }

        String c = a.length() >= b.length() ? a : b;
        c = c.substring(0, c.length() - plusCount);
        System.out.println("c -> " + c + " flag -> " + flag);
        for (int k = c.length() - 1; k >= 0; k--) {
            int temp = Integer.parseInt(String.valueOf(c.charAt(k))) + flag;
            sb.append(temp % 10 + flag);
            flag = temp / 10;
        }

//        for (int i = a.length() - 1; i >= 0; i--) {
//            for (int j = b.length() - 1; j >= 0; j--) {
//                int temp = Integer.parseInt(String.valueOf(a.charAt(i))) + Integer.parseInt(String.valueOf(b.charAt(j)));
//                sb.append(temp % 10 + flag);
//                flag = temp / 10;
//            }
//        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(strPlus("1998", "11"));
    }
}
