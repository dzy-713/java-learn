package com.dzy.leet;

/**
 * Z 字形变换
 * <p>
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * 请你实现这个将字符串进行指定行数变换的函数：
 * string convert(string s, int numRows);
 * 示例 1:
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * <p>
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author douzy
 * @date 2020-01-13.
 */
public class Question6 {

    /**
     * 定义二维数组,进行行列转换,排列后重新输出
     * 模拟人工思维,效率较低
     *
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        Character[][] result = new Character[s.length()][numRows];
        //向下走势标志
        boolean downTurnFlag = true;
        //定义横坐标,纵坐标
        int x = 0, y = 0;
        for (int index = 0; index < s.length(); index++) {
            char c = s.charAt(index);
            result[x][y] = c;
            //字符走势为向下的情况
            if (x % (numRows - 1) == 0 && downTurnFlag) {
                y = y + 1;
                //转向往右上
                if (y >= numRows) {
                    x++;
                    y = y - 2;
                    downTurnFlag = false;
                    if(y==0){
                        downTurnFlag=true;
                    }
                }
            } else {
                //字符走势为右上方向
                x++;
                y--;
                if (y == 0) {
                    //转为向下
                    downTurnFlag = true;
                }
            }
        }
        //输出结果
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < s.length(); j++) {
                Character c = result[j][i];
                if (c != null) {
                    stringBuffer.append(c);
                }
            }
        }

        return stringBuffer.toString();

    }


    public static void main(String[] args) {
        String s = "1234";
        int numRows = 2;
        String result = new Question6().convert(s, numRows);
        System.out.println(result);
    }
}
