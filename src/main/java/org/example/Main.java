package org.example;

import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static String minWindow(String S, String T) {
        // write code here
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int minn = S.length();
        for (int i = 0; i < T.length(); i++) {
            map.put(T.charAt(i), 0);
        }
        for (; right < S.length(); right++) {
            if (map.containsKey(S.charAt(right))) {
                map.put(S.charAt(right), map.get(S.charAt(right)) + 1);
            }
            if (checkCover(map)) {
                do {
                    if (map.containsKey(S.charAt(left))) {
                        map.put(S.charAt(left), map.get(S.charAt(left)) - 1);
                    }
                    left++;
                    System.out.println("left -> " + (left));
                } while (checkCover(map));
            }
//            if (checkCover(map)) {
            minn = Math.min(minn, right - left + 1);
            System.out.println("left -> " + (left) + " right -> " + right + " minn -> " + minn);
//            }
//            }
        }
        return "";
    }

    public static boolean checkCover(Map<Character, Integer> map) {
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() < 1) return false;
        }
        return true;
    }


    public static void main(String[] args) {
        //minWindow("XDOYEZODEYXNZ", "XYZ");
        Scanner in = new Scanner(System.in);
//        int tCount = Integer.parseInt(in.nextLine());//砝码总类型数
        String[] mStrs = in.nextLine().split(" ");//每种砝码重量
        String[] xStrs = in.nextLine().split(" ");//每种砝码数量
        HashSet<Integer> mRetSet = new HashSet<>();
        mRetSet.add(0);

        for (int j = 0; j < mStrs.length; j++) {
            for (int k = 0; k < Integer.parseInt(xStrs[j]); k++) {
                setupSet(mRetSet, Integer.parseInt(mStrs[j]));
            }
        }

        System.out.println(mRetSet.size());
    }

    public static void setupSet(HashSet<Integer> set, int addWeight) {
        List<Integer> list = new ArrayList<>();
        for(Integer value : set){
            int newValue = value + addWeight;
            list.add(newValue);
        }
        set.addAll(list);
    }
}