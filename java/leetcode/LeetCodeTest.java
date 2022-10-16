package leetcode;

import org.junit.Test;

import java.util.Scanner;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Node;

public class LeetCodeTest {

    @Test
    public void demo() {

    }

    public static void main(String[] args) {
        // 系统输入
        Scanner sc = new Scanner(System.in);
        // 获取一个整数
        int num = sc.nextInt();
        int highbit = 0;
        // 找出最高位的位置
        for (int i = 1; i <=30; i++) {
            if (num >= 1 << i) {
                highbit = i;
            } else {
                break;
            }
        }
        // 求出掩码的值  1<<(highbit+1))-1
        int mask = highbit == 30?0x7fffffff:(1<<(highbit+1))-1;  // 给int类型赋值的话，0X7FFFFFFF代表最大值，0X80000000代表最小值
        // 亦或掩码
        System.out.println(num^mask);
    }
}

