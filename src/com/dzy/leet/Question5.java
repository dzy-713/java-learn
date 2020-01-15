package com.dzy.leet;

import java.util.HashSet;
import java.util.Set;

/**
 * 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author douzy
 * @date 2020-01-13.
 */
public class Question5 {

    /**
     * 采用中心扩展法处理
     * 遍历字符串每个字符,向两边扩展到最大回文.保留最长的字符串  时间复杂度 1000*1000  n的平方
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        String resultMaxStr = "";
        int index;
        for (index = 0; index <= s.length() - 1; index++) {
            //回文字符串为奇数时
            int leftIndex = index;
            int rightIndex = index;
            while (leftIndex >= 0 && rightIndex <= s.length() - 1){
                if (s.charAt(leftIndex) != s.charAt(rightIndex)) {
                    break;
                }
                leftIndex = leftIndex - 1;
                rightIndex = rightIndex + 1;
            }
            //回退一步
            leftIndex=leftIndex+1;
            rightIndex=rightIndex-1;
            if (resultMaxStr.length() < (rightIndex - leftIndex + 1)) {
                resultMaxStr = s.substring(leftIndex, rightIndex+1);
            }


            //回文字符串为偶数时
            leftIndex = index;
            rightIndex = index + 1;

            while (leftIndex >= 0 && rightIndex <= s.length() - 1) {
                if (s.charAt(leftIndex) != s.charAt(rightIndex)) {
                    break;
                }
                leftIndex = leftIndex - 1;
                rightIndex = rightIndex + 1;
            }
            //回退一步
            leftIndex=leftIndex+1;
            rightIndex=rightIndex-1;
            if (resultMaxStr.length() < (rightIndex - leftIndex + 1)) {
                resultMaxStr = s.substring(leftIndex, rightIndex+1);
            }


        }
        return resultMaxStr;

    }


    /**
     * 废弃的方法
     * 穷举所有子串,判断是否是回文
     * 该方法在处理1000长度字符串是,会出现超时情况  1000*1000 次循环  还要乘以1000做回文判断  时间服再度为n的立方
     *
     * @param s
     * @return
     */
    @Deprecated
    public String longestPalindrome2(String s) {
        int length = s.length();
        Set<Character> characterSet = new HashSet<>();
        int firstIndex, currentIndex;
        int resultMaxStrLength = 0;
        String resultMaxStr = "";
        for (firstIndex = 0; firstIndex <= length - 1; firstIndex++) {
            for (currentIndex = length; currentIndex >= firstIndex; currentIndex--) {
                String temp = s.substring(firstIndex, currentIndex);
                if (isPalindrome(temp)) {
                    if (temp.length() > resultMaxStrLength) {
                        resultMaxStr = temp;
                        resultMaxStrLength = resultMaxStr.length();
                        break;
                    }
                }
            }
            characterSet.clear();
        }
        return resultMaxStr;
    }

    /**
     * 判断是否为回文字符串
     *
     * @param str
     * @return
     */
    public boolean isPalindrome(String str) {
        boolean palindromeFlag = true;
        if (str.length() > 1) {
            for (int beginIndex = 0, endIndex = str.length() - 1; beginIndex <= str.length() / 2; beginIndex++, endIndex--) {
                if (beginIndex >= endIndex) {
                    break;
                }
                char left = str.charAt(beginIndex);
                char right = str.charAt(endIndex);
                if (left != right) {
                    palindromeFlag = false;
                    break;
                }
            }
        }
        System.out.println("判断字符串:[" + str + "]是否回文:" + palindromeFlag);
        return palindromeFlag;
    }


    public static void main(String[] args) {
        String s = "aaa";
        String result = new Question5().longestPalindrome(s);
        System.out.println(result);
    }
}
