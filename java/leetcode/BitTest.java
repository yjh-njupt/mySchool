package leetcode;

import org.junit.Test;

import java.util.Scanner;

public class BitTest {
    public static void main(String[] args) {

        // 系统输入
        Scanner sc = new Scanner(System.in);
        // 获取一个整数
        int num = sc.nextInt();
        // 转换为字符串
        String s = Integer.toBinaryString(num);
        int var = 1 << num;
        String s1 = Integer.toBinaryString(var);

    }
}
