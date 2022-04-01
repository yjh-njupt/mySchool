package thread;

import org.junit.Test;

/**
 * @author ：yjh
 * @date ：Created in 2021/11/14 23:44
 * @description :
 * @version: v 1.0
 */
public class Day1 {
    // 守护线程
    @Test
    public void demo() {
        //Exception in thread "main" java.lang.IllegalThreadStateException
        System.out.println(Thread.currentThread().isDaemon());
    }

    public static void main(String[] args) {
        //Exception in thread "main" java.lang.IllegalThreadStateException
        System.out.println(Thread.currentThread().isDaemon());
        System.out.println();
        Thread.currentThread().setDaemon(true);
        System.out.println(Thread.currentThread().isDaemon());
    }



}
