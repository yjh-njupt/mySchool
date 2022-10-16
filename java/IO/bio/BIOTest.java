package IO.bio;

import org.junit.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class BIOTest {
    /**
     * client  */

    public static void main(String[] args) throws Exception {
        //.创建Socket对象，请求服务器的连接
        Socket socket = new Socket("127.0.0.1", 9999);
        // 从Socket对象中获取一个字节输出流
        OutputStream os = socket.getOutputStream();
        //把字节输出流打包成一个打印流
        PrintStream ps = new PrintStream(os);
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请说...");
            String str = sc.nextLine();
            ps.println(str);
            ps.flush();
        }
    }
    /**
     * server */
    @Test
    public void demo1() throws Exception{
        System.out.println("服务端启动");
        try {
            // 定义一个ServiceSocket对象进行服务端的端口注册
            ServerSocket ss = new ServerSocket(9999);
            // 监听客户端的Socket连接请求
            Socket socket = ss.accept();
            // 从socket管道中得到一个字节输入流对象
            InputStream is = socket.getInputStream();
            // 把字节输入流包装成一个字符输入缓冲流
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String msg;
            while ((msg = br.readLine()) != null) {
                System.out.println("服务端收到msg:" + msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * BIO 多线程处理版  */
    @Test
    public void demo2() throws Exception{
        System.out.println("服务端启动");
        try {
            //1.注册端口
            ServerSocket ss = new ServerSocket(9999);
            //2.定义一个死循环，负责不断地接收socket请求
            while (true) {
                Socket socket = ss.accept();
                //3.创建一个独立的线程来处理与这个客户端socket通信需求
                new Thread(new ServerThreadReader(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public class ServerThreadReader implements Runnable {
        private Socket socket;

        public ServerThreadReader(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                InputStream is = socket.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                String msg;
                while ((msg = br.readLine()) != null) {
                    System.out.println("msg:" + msg);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
