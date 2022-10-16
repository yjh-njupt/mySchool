package innerclass;

import org.junit.Test;

public class InnerClassTest {
    @Test
    public void demo() throws Exception {
        // 创建外部类对象
        InnerClassTest innerClassTest = new InnerClassTest();
        // 创建内部类对象
        Inner inner = innerClassTest.new Inner();
        // 调用内部类对象的方法
        inner.demo();
    }


    public class Inner{

        public void demo() throws Exception{
            System.out.println("welcome to imooc");
        }
    }
}
