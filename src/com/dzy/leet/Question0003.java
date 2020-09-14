package com.dzy.leet;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author douzy
 * @date 2020-01-13.
 */
public class Question0003 {


    public int lengthOfLongestSubstring(String s) {
        //定义指针1
        int index1;
        //定义指针2
        int index2;
        //字符串转数组
        String[] stringArr = s.split("");
        //字符串结果集
        //List<String> stringList = new ArrayList<>();
        int maxLength = 0;
        //StringBuffer maxLengthStr=new StringBuffer();
        StringBuffer stringBuffer;
        Set<String> stringSet;
        if (stringArr.length <= 1) {
            if ("".equals(stringArr[0])) {
                return 0;
            } else {
                return 1;
            }
        }
        //遍历字符串,通过set判断长度
        for (index1 = 0; index1 <= stringArr.length - 2; index1++) {
            //stringBuffer = new StringBuffer();
            stringSet = new HashSet<>();
            String a1 = stringArr[index1];
            stringSet.add(a1);
            //stringBuffer.append(a1);
            for (index2 = index1 + 1; index2 <= stringArr.length - 1; index2++) {
                String a2 = stringArr[index2];
                if (!stringSet.add(a2)) {
                    //stringList.add(stringBuffer.toString());
                    break;
                }
                //stringBuffer.append(a2);
            }
            if (maxLength < stringSet.size()) {
                maxLength = stringSet.size();
                //maxLengthStr=stringBuffer;
            }
        }
        //System.out.println(maxLengthStr.toString());
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "ab";
        int result = new Question0003().lengthOfLongestSubstring(s);
        System.out.println(result);
    }
}
