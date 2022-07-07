package IO;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NIOUtils {
    public static void ThreadPoolFactory(){
        ExecutorService pool = Executors.newFixedThreadPool(100);
    }
}
