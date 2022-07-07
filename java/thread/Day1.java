package thread;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author ：yjh
 * @date ：Created in 2021/11/14 23:44
 * @description :
 * @version: v 33.xlsx.0
 */
public class Day1 {
    private static final Logger logger = LoggerFactory.getLogger(Day1.class);


    // 守护线程
    @Test
    public void demo() {
        //Exception in thread "main" java.lang.IllegalThreadStateException
        System.out.println(Thread.currentThread().isDaemon());
    }

    public static void main(String[] args) {
        //Exception in thread "main" java.lang.IllegalThreadStateException
        /*System.out.println(Thread.currentThread().isDaemon());
        System.out.println();
        Thread.currentThread().setDaemon(true);
        System.out.println(Thread.currentThread().isDaemon());*/

        logger.info("test info");
        logger.error("test error");
        logger.debug("test debug");
        logger.warn("test warn");
    }

    @Test
    public void demo1(){
        // log4j:WARN No appenders could be found for logger (thread.Day1).
        // log4j.properties
        logger.info("test info");
        logger.error("test error");
        logger.debug("test debug");
        logger.warn("test warn");
    }


    @Test
    public void demo2() {
         class MyThread extends Thread{
            public void run(){
                logger.info("MyThread1.run()");
            }
        }
        MyThread myThread = new MyThread();
        myThread.start();
    }

    @Test
    public void demo3(){
        class MyThread implements Runnable{

            public void run() {
                logger.info("MyThread2.run()");
            }
        }

        MyThread myThread = new MyThread();
        Thread thread = new Thread(myThread);
        thread.start();
    }

    /**
     * Futrure f = pool.submit(Callable);
     * 只需要将任务提交给pool就可以了。
     * */
    @Test
    public void demo4() throws ExecutionException, InterruptedException {

        // 创建一个线程池
        ExecutorService pool = Executors.newFixedThreadPool(3);
        // 创建多个有返回值的任务
        List<Future> list = new ArrayList<Future>();
        for (int i = 0; i < 3; i++) {
            Callable c = new Callable() {
                public Object call() throws Exception {
                    return Thread.currentThread().getName();
                }
            };
            Future f = pool.submit(c);
            list.add(f);
        }
        // 关闭线程池
        pool.shutdown();
        for (Future f :
                list) {
            //从Future对象上获取任务的返回值，输出
            //logger.info("res: {}",f.get().toString());
            System.out.println(f.get().toString());
        }
    }

    // pool.execute(Runable r)
    @Test
    public void demo5(){
        ExecutorService pool = Executors.newFixedThreadPool(10);
        while (true) {
            pool.execute(new Runnable() {
                public void run() {
                    logger.info("{} is running...", Thread.currentThread().getName());
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    // new CachedThreadPool
    // 伪同步
    // new ThreadPoolExecutor
    @Test
    public void demo6(){
        ExecutorService pool = Executors.newCachedThreadPool();
        /*return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                                      60L, TimeUnit.SECONDS,
                                      new SynchronousQueue<Runnable>());
                                      */
        /*2022-04-11 00:43:49 [thread.Day1]-[INFO] ----0
2022-04-11 00:43:49 [thread.Day1]-[INFO] ----33.xlsx
2022-04-11 00:43:49 [thread.Day1]-[INFO] pool-33.xlsx-thread-33.xlsx is running
2022-04-11 00:43:49 [thread.Day1]-[INFO] ----2
2022-04-11 00:43:49 [thread.Day1]-[INFO] pool-33.xlsx-thread-2 is running
2022-04-11 00:43:49 [thread.Day1]-[INFO] ----3
2022-04-11 00:43:49 [thread.Day1]-[INFO] pool-33.xlsx-thread-3 is running
2022-04-11 00:43:49 [thread.Day1]-[INFO] ----4
2022-04-11 00:43:49 [thread.Day1]-[INFO] pool-33.xlsx-thread-4 is running
2022-04-11 00:43:49 [thread.Day1]-[INFO] ----5
2022-04-11 00:43:49 [thread.Day1]-[INFO] pool-33.xlsx-thread-5 is running
2022-04-11 00:43:49 [thread.Day1]-[INFO] ----6
2022-04-11 00:43:49 [thread.Day1]-[INFO] pool-33.xlsx-thread-6 is running
2022-04-11 00:43:49 [thread.Day1]-[INFO] ----7
2022-04-11 00:43:49 [thread.Day1]-[INFO] pool-33.xlsx-thread-7 is running*/
        for (int i = 0; i < 100; i++) {
                logger.info("----{}",i);
                pool.execute(new Runnable() {
                    public void run() {
                        logger.info("{} is running",Thread.currentThread().getName());
                        try {
                            Thread.sleep(10000);
                        } catch (InterruptedException e) {
                            logger.error("sleep error:",e);
                        }
                    }
                });
        }
    }
    // newCachedThreadPool
    // new ThreadPoolExecutor
    // 线程结束
    // time的影响
    @Test
    public void demo7(){
        ExecutorService pool = Executors.newCachedThreadPool();
        /*return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                                      60L, TimeUnit.SECONDS,
                                      new SynchronousQueue<Runnable>());*/
        for (int i = 0; i < 100; i++) {

            logger.info("----{}", i);
            pool.execute(new Runnable() {
                public void run() {
                    logger.info("{} is running", Thread.currentThread().getName());
                }
            });
        }
        /*2022-04-11 00:47:10 [thread.Day1]-[INFO] ----0
2022-04-11 00:47:10 [thread.Day1]-[INFO] ----33.xlsx
2022-04-11 00:47:10 [thread.Day1]-[INFO] pool-33.xlsx-thread-33.xlsx is running
2022-04-11 00:47:10 [thread.Day1]-[INFO] ----2
2022-04-11 00:47:10 [thread.Day1]-[INFO] pool-33.xlsx-thread-2 is running
2022-04-11 00:47:10 [thread.Day1]-[INFO] pool-33.xlsx-thread-3 is running
2022-04-11 00:47:10 [thread.Day1]-[INFO] ----3
2022-04-11 00:47:10 [thread.Day1]-[INFO] ----4
2022-04-11 00:47:10 [thread.Day1]-[INFO] pool-33.xlsx-thread-3 is running
2022-04-11 00:47:10 [thread.Day1]-[INFO] pool-33.xlsx-thread-2 is running
2022-04-11 00:47:10 [thread.Day1]-[INFO] ----5
2022-04-11 00:47:10 [thread.Day1]-[INFO] ----6
2022-04-11 00:47:10 [thread.Day1]-[INFO] pool-33.xlsx-thread-2 is running
2022-04-11 00:47:10 [thread.Day1]-[INFO] pool-33.xlsx-thread-3 is running
2022-04-11 00:47:10 [thread.Day1]-[INFO] ----7
2022-04-11 00:47:10 [thread.Day1]-[INFO] ----8
2022-04-11 00:47:10 [thread.Day1]-[INFO] pool-33.xlsx-thread-3 is running
2022-04-11 00:47:10 [thread.Day1]-[INFO] pool-33.xlsx-thread-2 is running*/
    }

    /**
     * 本想验证isInterrupted（）的，但是确没有验证出来。
     * 反而，验证了main结束，而ThreadSafe的对象不得不结束的情况。
     * 为了观察ThreadSafe在isInterrupted=false，while循环，
     * 只好使main sleep更长的时间。*/
    @Test
    public void demo8(){
        class ThreadSafe  extends  Thread{
            public void run(){
                logger.info("{}",isInterrupted());
                while(!isInterrupted()){
                    try {
                        logger.info("{}",5*1000);
                        Thread.sleep(5*1000);
                    } catch (InterruptedException e) {
                        logger.error("{}",e);
                        break;
                    }
                }

            }
        }
        ThreadSafe threadSafe = new ThreadSafe();
        threadSafe.start();
        try {
            logger.info("15*1000");

            Thread.sleep(15*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /*INFO - 15*1000
INFO - false
INFO - 5000
INFO - 5000
INFO - 5000*/
    }

    /**
     * 已经过时的方法stop()，阻断了线程。stop后的程序没有打印出来*/
    @Test
    public void demo9(){
        class ThreadSafe  extends  Thread{
            public void run(){
                System.out.println("-");
                stop();
                System.out.println("--");
            }
        }
        System.out.println("---");
        ThreadSafe threadSafe = new ThreadSafe();
        threadSafe.start();
        try {
            Thread.sleep(5*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("----");
        /*
        * ---
-
----*/
    }
    private static int i = 100*1000;
    /**上面的demo里，线程都是在单独做自己的事情，现在让两个线程合作去做一件事情。
     * 结果出现了混乱的问题。*/
    @Test
    public void demo10(){
        i = 10*1000;
        class ThreadSafe  extends  Thread{
            public void run(){
                while (i > 0) {
                    System.out.println(i--);
                }
            }
        }
        ThreadSafe threadSafe = new ThreadSafe();
        threadSafe.start();

        while (i > 0) {
            System.out.println(i--);
        }

        /*5
4
3
2
33.xlsx
111*/
    }

    /**
     * 如何解决10*1000出现demo10混乱的问题。
     * 某个线程Thread-0一直霸占了线程
     * 利用了sleepq（）不释放锁资源*/
    @Test
    public void demo11() {
        i = 10*10000;
        class ThreadSafe  extends  Thread{
            public void run(){
                while (i > 0) {
                    logger.info(i-- + "-" + Thread.currentThread().getName());
                }
            }
        }
        ThreadSafe threadSafe = new ThreadSafe();
        threadSafe.start();

        synchronized (Day1.class) {
            try {
                Thread.sleep(10*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (i > 0) {
                logger.info(i-- + "-" + Thread.currentThread().getName());
            }
        }
        /*
        * 9992Thread-0
9991Thread-0
9990Thread-0
9989Thread-0
9988Thread-0
9987Thread-0
9986Thread-0
9985Thread-0
9984Thread-0
9983Thread-0
*/
    }

    /*
    * 另一个线程似乎无法正常参与对i的操作*/
    @Test
    public void demo12() {
        i = 10*10000;
        class ThreadSafe  extends  Thread{
            public void run(){
                synchronized (Day1.class) {
                    try {
                        Thread.sleep(10*1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    while (i > 0) {
                        logger.info(i-- + "-" + Thread.currentThread().getName());
                    }
                }
            }
        }
        ThreadSafe threadSafe = new ThreadSafe();
        threadSafe.start();


            while (i > 0) {
                logger.info(i-- + "-" + Thread.currentThread().getName());
            }

    }
    /*
    * 18-main
17-main
16-main
15-main
14-main
13-main
12-main
11-main
10-main*/

    /**
     * 使用线程池测试多线程的表现。
     */
    @Test
    public void demo13(){
        i = 100*1000;
        ExecutorService pool
                = Executors.newFixedThreadPool(3);
        for (int j = 0; j <3 ; j++) {
            pool.execute(new Runnable() {
                public void run() {
                    while (i > 0) {
                        logger.info(i-- + "-" + Thread.currentThread().getName());
                        /**
                         * 多个线程之间并不能互相协作*/
                    }
                }
            });
        }
        /**
         如果我不这么做，线程池就会异常终止。@Test不太清楚是否会强制关闭所有线程。
         */
        sleepy();
    }

    private static void sleepy(){
        try {
            Thread.sleep(5*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void demo14(){

    }
}
