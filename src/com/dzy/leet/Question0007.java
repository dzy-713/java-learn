package com.dzy.leet;

/**
 * 整数反转
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 示例 1:
 * 输入: 123
 * 输出: 321
 *  示例 2:
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * 输入: 120
 * 输出: 21
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author douzy
 * @date 2020-01-13.
 */
public class Question0007 {

    /**
     * 更优解,采用数值取余取模换算
     *
     * @param x
     * @return
     */
    public int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            if ((ans * 10) / 10 != ans) {
                ans = 0;
                break;
            }
            ans = ans * 10 + x % 10;
            x = x / 10;
        }
        return ans;
    }


    /**
     * 整数转字符串
     * 逆序输出,注意第一个有效值不能是0,保留符号
     *
     * @param x
     * @return
     */
    public int reverse2(int x) {
        if (x == 0) {
            return 0;
        }
        String s = x + "";
        Character firstChar = s.charAt(0);
        boolean negativeFlag = false;
        if (firstChar.equals('-')) {
            negativeFlag = true;
            s = s.substring(1, s.length());
        }
        StringBuffer stringBuffer = new StringBuffer();
        boolean effectiveFlag = false;
        for (int i = s.length() - 1; i >= 0; i--) {
            Character character = s.charAt(i);
            if (effectiveFlag) {
                stringBuffer.append(character);
            } else {
                if (!character.equals('0')) {
                    effectiveFlag = true;
                    stringBuffer.append(character);
                }
            }
        }
        try {
            x = Integer.parseInt(stringBuffer.toString());
        } catch (Exception e) {
            return 0;
        }

        return negativeFlag ? 0 - x : x;

    }


    public static void main(String[] args) {
        int x = 1534236469;
        int result = new Question0007().reverse(x);
        System.out.println(result);
    }
}
